package cn.com.cube.platform.barber.mysql.service;

import cn.com.cube.platform.barber.mysql.entity.VBizBarber;
import cn.com.cube.platform.barber.mysql.entity.VBizCustomer;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author jh
 * @since 2019-11-28
 */
public interface IVBizBarberService extends IService<VBizBarber> {

    //分页查询
    PageParams<VBizBarber> listPage(PageParams<VBizBarber> pageParams);
}
