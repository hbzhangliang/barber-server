package cn.com.cube.platform.barber.controller;


import cn.com.cube.platform.barber.mongo.models.User;
import cn.com.cube.platform.barber.mongo.repo.UserRepo;
import cn.com.cube.platform.barber.mysql.entity.TSysAccount;
import cn.com.cube.platform.barber.mysql.service.TSysAccountService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping(value = "test")
@ResponseBody
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TSysAccountService tSysAccountService;

    @RequestMapping(value = "/health")
    public Object health(){
        log.info("health fire ");
        JSONObject jsonObject=new JSONObject(2);
        jsonObject.put("name","spdier-data-modify");
        jsonObject.put("status","up");
        jsonObject.put("remark","爬虫数据清洗服务");
        return jsonObject;
    }


    @RequestMapping(value = "/redis")
    public Object redis(){
        log.info("redis fire ");
        redisTemplate.opsForValue().set("aa","this iisisisi");
        return redisTemplate.opsForValue().get("aa");
    }

    @RequestMapping(value = "/mongodb")
    public Object mongodb(){
        log.info("mongodb fire ");
        User user=new User();
        user.setName("ttt");
        user.setPsd("1111");
        userRepo.save(user);
        return "dddd";
    }

    @RequestMapping(value = "/mysql")
    public Object mysql(){
        log.info("mysql fire ");
        TSysAccount account=new TSysAccount();
        account.setName("dfff");
        account.setPassword("vvv");
        account.setId(UUID.randomUUID().toString().replaceAll("-",""));
        tSysAccountService.insert(account);
        return account;
    }

}
