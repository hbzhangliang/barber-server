package cn.com.cube.platform.barber.mysql.service;

import cn.com.cube.platform.barber.mysql.entity.TSysAccount;
import cn.com.cube.platform.barber.mysql.vo.AccountVo;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jh
 * @since 2019-11-12
 */
public interface ITSysAccountService extends IService<TSysAccount> {

    PageParams<TSysAccount> listPage(PageParams<TSysAccount> pageParams);

    Long testCount();


    /**
     * 登录接口  如果成功，一次 登录，  否则 选择企业，或登录账号错误
     * @param account
     * @param pwd
     * @return
     */
    Map<String,Object> checkAccount(@NotEmpty String account,@NotEmpty String pwd);


    /**
     * 选择企业登录
     * @param accountId
     * @param departId
     * @return
     */
    Map<String,Object> chooseDepart(int accountId,int departId);


    /**
     * 通过 token 得到用户信息
     * @param token
     * @return
     */
    AccountVo getInfoByToken(@NotEmpty String token);


    void logout(String token);

}
