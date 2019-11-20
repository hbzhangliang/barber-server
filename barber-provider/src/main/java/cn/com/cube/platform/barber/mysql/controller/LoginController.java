package cn.com.cube.platform.barber.mysql.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/account")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    //登录接口
    @RequestMapping(value = "/login")
    public Object login(@RequestBody Map<String,String> map){
        String username=map.get("username");
        String password=map.get("password");
        log.info("username is [{}],password is [{}]",username,password);


        return null;
    }


}
