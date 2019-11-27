package cn.com.cube.platform.barber.mysql.controller;


import cn.com.cube.platform.barber.mysql.entity.TSysDepart;
import cn.com.cube.platform.barber.mysql.entity.TSysDict;
import cn.com.cube.platform.barber.mysql.service.ITSysDictService;
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
 * @since 2019-11-27
 */
@RestController
@RequestMapping("/dict")
public class TSysDictController extends BaseController{

    @Autowired
    private ITSysDictService sysDictService;

    @RequestMapping(value = "/list-all")
    public Object list(){
        return sysDictService.list();
    }


    @RequestMapping(value = "/list")
    public Object list(@RequestBody PageParams<TSysDict> bean){
        return sysDictService.listPage(bean);
    }

    @RequestMapping(value = "/list-children")
    public Object listChildren(@RequestBody Map<String,String> map){
        String code=map.get("code");
        return sysDictService.listChildren(code);
    }


    @RequestMapping(value = "/get")
    public Object get(@RequestBody Map<String, Integer> map){
        Integer id=map.get("id");
        return sysDictService.getById(id);
    }

    @RequestMapping(value = "/save")
    public Object save(@RequestBody TSysDict bean){
        boundData(bean);
        return sysDictService.saveOrUpdate(bean);
    }

    @RequestMapping(value = "/del")
    public Object del(@RequestBody Map<String, List<Integer>> map){
        List<Integer> ids=map.get("ids");
        return sysDictService.del(ids);
    }


}
