package cn.com.cube.platform.barber.mysql.service;

import cn.com.cube.platform.barber.mysql.entity.TSysDepart;
import cn.com.cube.platform.barber.mysql.entity.TSysDict;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jh
 * @since 2019-11-27
 */
public interface ITSysDictService extends IService<TSysDict> {

    PageParams<TSysDict> listPage(PageParams<TSysDict> pageParams);


    Boolean del(List<Integer> ids);


    List<TSysDict> listChildren(String code);

}
