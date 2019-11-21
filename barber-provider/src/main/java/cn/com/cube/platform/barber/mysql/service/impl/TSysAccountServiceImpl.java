package cn.com.cube.platform.barber.mysql.service.impl;

import cn.com.cube.platform.barber.mysql.entity.*;
import cn.com.cube.platform.barber.mysql.mapper.TSysAccountMapper;
import cn.com.cube.platform.barber.mysql.service.*;
import cn.com.cube.platform.barber.mysql.vo.AccountVo;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import cn.com.cube.platform.barber.utils.CodeUtils;
import cn.com.cube.platform.barber.utils.ComEnum;
import cn.com.cube.platform.barber.utils.RedisUtils;
import cn.com.cube.platform.barber.utils.Tuple2;
import cn.com.cube.platform.barber.utils.global.GlobalHolder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jh
 * @since 2019-11-12
 */
@Service
public class TSysAccountServiceImpl extends ServiceImpl<TSysAccountMapper, TSysAccount> implements ITSysAccountService {

    private static Logger log = LoggerFactory.getLogger(TSysAccountServiceImpl.class);

    @Autowired
    private ITBizAccountDepartService accountDepartService;

    @Autowired
    private ITSysDepartService departService;

    @Autowired
    private ITBizBarberService barberService;

    @Autowired
    private ITBizCustomerService customerService;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public PageParams<TSysAccount> listPage(PageParams<TSysAccount> pageParams) {
        QueryWrapper<TSysAccount> queryWrapper=BaseServiceCom.wrapper(pageParams);
        Page<TSysAccount> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        IPage<TSysAccount> iPage = this.page(page,queryWrapper);

        pageParams.setData(iPage.getRecords());
        int totalRows=(int)iPage.getTotal();
        int totalPage=(totalRows-1)/pageParams.getPageSize()+1;
        pageParams.setTotalRows(totalRows);
        pageParams.setTotalPage(totalPage);

        return pageParams;
    }

    @Override
    public Long testCount() {
        return baseMapper.testCount();
    }


    /**
     * status  ==1 表示已经成功登录了
     * status  ==2 表示登录成功 需要选择门店
     * 返回空  表示账号或其他错误
     * @param account
     * @param pwd
     * @return
     */
    @Override
    public Map<String,Object> checkAccount(String account, String pwd) {
        QueryWrapper<TSysAccount> queryWrapper= new QueryWrapper<>();
        queryWrapper.lambda().eq(TSysAccount::getAccount,account).eq(TSysAccount::getPassword, CodeUtils.getEncryptedCode(pwd));
        TSysAccount tSysAccount=this.getOne(queryWrapper);
        if(tSysAccount==null){
            log.error("未查找到相应账号,account [{}],pwd [{}]",account,pwd);
            return null;
        }
        AccountVo result=new AccountVo();
        result.setAccount(tSysAccount);
        //查找depart
        QueryWrapper<TBizAccountDepart> accountDepartQueryWrapper=new QueryWrapper<>();
        accountDepartQueryWrapper.lambda().eq(TBizAccountDepart::getAccountId,tSysAccount.getId());
        List<TBizAccountDepart> accountDepartList=accountDepartService.list(accountDepartQueryWrapper);
        if(CollectionUtils.isEmpty(accountDepartList)){
            log.error("未找到门店信息,account [{}],pwd [{}]",account,pwd);
            return null;
        }
        //正常的
        if(accountDepartList.size()==1){
            int departId=accountDepartList.get(0).getDepartId();
            result.setDepart(departService.getById(departId));

            //在检索 barber和customer表
            QueryWrapper<TBizBarber> barberQueryWrapper=new QueryWrapper<>();
            barberQueryWrapper.lambda().eq(TBizBarber::getAccountId,tSysAccount.getId()).eq(TBizBarber::getDepartId,departId);
            result.setBarber(barberService.getOne(barberQueryWrapper));

            QueryWrapper<TBizCustomer> customerQueryWrapper=new QueryWrapper<>();
            customerQueryWrapper.lambda().eq(TBizCustomer::getAccountId,tSysAccount.getId()).eq(TBizCustomer::getDepartId,departId);
            result.setCustomer(customerService.getOne(customerQueryWrapper));

            //写入redis,返回 token
            String token= UUID.randomUUID().toString().replaceAll("-","");
            GlobalHolder.set(result);
            Map<String,Object> map=new HashMap<>(2);
            map.put("status","1");
            map.put("token",token);
            map.put("accountVo",result);
            String redisTimeKey="COMMON";
            redisUtils.setObj(token,result,redisTimeKey);
            return map;
        }
        //返回所有门店信息
        else{
            QueryWrapper<TSysDepart> departQueryWrapper=new QueryWrapper<>();
            departQueryWrapper.lambda().in(TSysDepart::getId,accountDepartList.stream().map(p->p.getDepartId()).collect(Collectors.toList()));
            result.setDepartList(departService.list(departQueryWrapper));

            Map<String,Object> map=new HashMap<>(2);
            map.put("status","2");
            map.put("accountVo",result);
            return map;
        }
    }

    @Override
    public Map<String, Object> chooseDepart(int accountId, int departId) {
        TSysAccount tSysAccount=this.getById(accountId);
        TSysDepart tSysDepart=departService.getById(departId);

        AccountVo result=new AccountVo();
        result.setAccount(tSysAccount);
        result.setDepart(tSysDepart);
        //在检索 barber和customer表
        QueryWrapper<TBizBarber> barberQueryWrapper=new QueryWrapper<>();
        barberQueryWrapper.lambda().eq(TBizBarber::getAccountId,tSysAccount.getId()).eq(TBizBarber::getDepartId,departId);
        result.setBarber(barberService.getOne(barberQueryWrapper));

        QueryWrapper<TBizCustomer> customerQueryWrapper=new QueryWrapper<>();
        customerQueryWrapper.lambda().eq(TBizCustomer::getAccountId,tSysAccount.getId()).eq(TBizCustomer::getDepartId,departId);
        result.setCustomer(customerService.getOne(customerQueryWrapper));

        //写入redis,返回 token
        String token= UUID.randomUUID().toString().replaceAll("-","");
        GlobalHolder.set(result);
        Map<String,Object> map=new HashMap<>(2);
        map.put("status","1");
        map.put("token",token);
        map.put("accountVo",result);
        String redisTimeKey="COMMON";
        redisUtils.setObj(token,result,redisTimeKey);
        return map;
    }


    @Override
    public AccountVo getInfoByToken(String token) {
        return (AccountVo) redisUtils.getObj(token);
    }


    @Override
    public void logout(String token) {
        redisUtils.delKeys(token);
    }
}
