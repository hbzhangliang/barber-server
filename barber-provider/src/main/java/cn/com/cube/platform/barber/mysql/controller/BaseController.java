package cn.com.cube.platform.barber.mysql.controller;


import cn.com.cube.platform.barber.mysql.entity.entity;
import cn.com.cube.platform.barber.mysql.vo.AccountVo;
import cn.com.cube.platform.barber.utils.global.GlobalHolder;
import java.time.LocalDateTime;


public abstract class BaseController {

    protected void boundData(entity e){
        AccountVo vo= GlobalHolder.get();
        LocalDateTime dt= LocalDateTime.now();
        //update
        if(e.getId()!=null){
            e.setUpdateTime(dt);
            e.setUpdateBy(vo.getAccount().getAccount());
        }
        // insert
        else {
            e.setCreateTime(dt);
            e.setCreateBy(vo.getAccount().getAccount());
        }
    }

}
