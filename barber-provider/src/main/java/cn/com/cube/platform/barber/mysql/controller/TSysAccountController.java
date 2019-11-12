package cn.com.cube.platform.barber.mysql.controller;


import cn.com.cube.platform.barber.mysql.entity.TSysAccount;
import cn.com.cube.platform.barber.mysql.service.ITSysAccountService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.h2.pagestore.Page;
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
 * @since 2019-11-12
 */
@RestController
@RequestMapping("/mysql/t-sys-account")
public class TSysAccountController {

    @Autowired
    private ITSysAccountService sysAccountService;

    @RequestMapping(value = "/list_all")
    public Object list(){
        return sysAccountService.list();
    }

    @RequestMapping(value = "/list_page")
    public Object listPage(){

//        IPage<TSysAccount> page=
//        sysAccountService.page()
//        return sysAccountService.list();
        return null;
    }

    @RequestMapping(value = "/save")
    public Object save(@RequestBody TSysAccount bean){
        return sysAccountService.saveOrUpdate(bean);
    }

    @RequestMapping(value = "/get")
    public Object get(@RequestBody Map<String, Integer> map){
        Integer id=map.get("id");
        return sysAccountService.getById(id);
    }

    @RequestMapping(value = "/del")
    public Object del(@RequestBody Map<String, Integer> map){
        Integer id=map.get("id");
        return sysAccountService.removeById(id);
    }


}
