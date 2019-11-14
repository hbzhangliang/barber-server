package cn.com.cube.platform.barber.mysql.service;

import cn.com.cube.platform.barber.mysql.entity.TSysDepart;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jh
 * @since 2019-11-14
 */
public interface ITSysDepartService extends IService<TSysDepart> {

    //分页查询
    PageParams<TSysDepart> listPage(PageParams<TSysDepart> pageParams);


}
