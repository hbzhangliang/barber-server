package cn.com.cube.platform.barber.mysql.service;

import cn.com.cube.platform.barber.mysql.entity.TSysAccount;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
