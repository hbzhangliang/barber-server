package cn.com.cube.platform.barber.mysql.service;

import cn.com.cube.platform.barber.mysql.entity.TBizCustomer;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jh
 * @since 2019-11-20
 */
public interface ITBizCustomerService extends IService<TBizCustomer> {


    //分页查询
    PageParams<TBizCustomer> listPage(PageParams<TBizCustomer> pageParams);

}
