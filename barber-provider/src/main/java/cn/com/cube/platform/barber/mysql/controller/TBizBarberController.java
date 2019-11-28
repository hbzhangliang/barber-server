package cn.com.cube.platform.barber.mysql.controller;


import cn.com.cube.platform.barber.mysql.entity.TBizBarber;
import cn.com.cube.platform.barber.mysql.entity.TSysDepart;
import cn.com.cube.platform.barber.mysql.service.ITBizBarberService;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jh
 * @since 2019-11-20
 */
@RestController
@RequestMapping("/barber")
public class TBizBarberController extends BaseController{

    @Autowired
    private ITBizBarberService bizBarberService;


    @RequestMapping(value = "/list-all")
    public Object list(){
        return bizBarberService.list();
    }


    @RequestMapping(value = "/list")
    public Object list(@RequestBody PageParams<TBizBarber> bean){
        return bizBarberService.listPage(bean);
    }

    @RequestMapping(value = "/get")
    public Object get(@RequestBody Map<String, Integer> map){
        Integer id=map.get("id");
        return bizBarberService.getById(id);
    }

    @RequestMapping(value = "/save")
    public Object save(@RequestBody TBizBarber bean){
        boundData(bean);
        return bizBarberService.saveOrUpdate(bean);
    }

    @RequestMapping(value = "/del")
    public Object del(@RequestBody Map<String, List<Integer>> map){
        List<Integer> ids=map.get("ids");
        return bizBarberService.removeByIds(ids);
    }


}
