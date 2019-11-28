package cn.com.cube.platform.barber.mysql.controller;


import cn.com.cube.platform.barber.mysql.entity.TBizCustomer;
import cn.com.cube.platform.barber.mysql.entity.VBizCustomer;
import cn.com.cube.platform.barber.mysql.service.ITBizCustomerService;
import cn.com.cube.platform.barber.mysql.service.IVBizCustomerService;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 * @author jh
 * @since 2019-11-28
 */
@RestController
@RequestMapping("/v-customer")
public class VBizCustomerController extends BaseController{

    @Autowired
    private IVBizCustomerService customerService;

    @RequestMapping(value = "/list-all")
    public Object list(){
        return customerService.list();
    }


    @RequestMapping(value = "/list")
    public Object list(@RequestBody PageParams<VBizCustomer> bean){
        return customerService.listPage(bean);
    }

    @RequestMapping(value = "/get")
    public Object get(@RequestBody Map<String, Integer> map){
        Integer id=map.get("id");
        return customerService.getById(id);
    }

    @RequestMapping(value = "/save")
    public Object save(@RequestBody VBizCustomer bean){
        boundData(bean);
        return customerService.saveOrUpdate(bean);
    }

    @RequestMapping(value = "/del")
    public Object del(@RequestBody Map<String, List<Integer>> map){
        List<Integer> ids=map.get("ids");
        return customerService.removeByIds(ids);
    }

}
