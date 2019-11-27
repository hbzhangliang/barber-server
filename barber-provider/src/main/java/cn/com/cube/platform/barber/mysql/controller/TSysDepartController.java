package cn.com.cube.platform.barber.mysql.controller;


import cn.com.cube.platform.barber.mysql.entity.TSysDepart;
import cn.com.cube.platform.barber.mysql.service.ITSysDepartService;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jh
 * @since 2019-11-14
 */
@RestController
@RequestMapping("/depart")
public class TSysDepartController extends BaseController{

    @Autowired
    private ITSysDepartService itSysDepartService;

    @RequestMapping(value = "/list-all")
    public Object list(){
        return itSysDepartService.list();
    }


    @RequestMapping(value = "/list")
    public Object list(@RequestBody PageParams<TSysDepart> bean){
        return itSysDepartService.listPage(bean);
    }

    @RequestMapping(value = "/get")
    public Object get(@RequestBody Map<String, Integer> map){
        Integer id=map.get("id");
        return itSysDepartService.getById(id);
    }

    @RequestMapping(value = "/save")
    public Object save(@RequestBody TSysDepart bean){
        boundData(bean);
        return itSysDepartService.saveOrUpdate(bean);
    }

    @RequestMapping(value = "/del")
    public Object del(@RequestBody Map<String, List<Integer>> map){
        List<Integer> ids=map.get("ids");
        return itSysDepartService.removeByIds(ids);
    }


}
