package cn.com.cube.platform.barber.mysql.controller;


import cn.com.cube.platform.barber.mysql.entity.TSysAccount;
import cn.com.cube.platform.barber.mysql.service.ITSysAccountService;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jh
 * @since 2019-11-12
 */
@RestController
@RequestMapping("/sys-account")
public class TSysAccountController extends BaseController {

    @Autowired
    private ITSysAccountService sysAccountService;

    @RequestMapping(value = "/list_all")
    public Object list(){
        return sysAccountService.list();
    }

    @RequestMapping(value = "/list")
    public Object listPage(@RequestBody PageParams<TSysAccount> pageParams){
        return  sysAccountService.listPage(pageParams);
    }

    @RequestMapping(value = "/save")
    public Object save(@RequestBody TSysAccount bean){
        boundData(bean);
        return sysAccountService.saveOrUpdate(bean);
    }

    @RequestMapping(value = "/get")
    public Object get(@RequestBody Map<String, Integer> map){
        Integer id=map.get("id");
        return sysAccountService.getById(id);
    }

    @RequestMapping(value = "/del")
    public Object del(@RequestBody Map<String, Integer> map){
        Integer id=map.get("id");
        return sysAccountService.removeById(id);
    }


    @RequestMapping(value = "/login")
    public Object login(@RequestBody Map<String, String> map){
        String account=map.get("username");
        String pwd=map.get("password");
        QueryWrapper<TSysAccount> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TSysAccount::getAccount,account).eq(TSysAccount::getPassword,pwd);

        List<TSysAccount> list=sysAccountService.list(queryWrapper);
        Map<String,String> map1=new HashMap<>();
        map1.put("token","admin-token");
        return map1;
    }



    @RequestMapping(value = "/test")
    public Object test(){
        return sysAccountService.testCount();
    }

}
