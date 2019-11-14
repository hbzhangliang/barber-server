package cn.com.cube.platform.barber.mysql.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class TestController {
    private static Logger log = LoggerFactory.getLogger(TestController.class);


    @RequestMapping(value = "/login")
    public Object login(@RequestBody Map<String,String>map){
        String username=map.get("username");
        String password=map.get("password");
        log.info("username is [{}],password is [{}]",username,password);
        Map<String,String> result=new HashMap<>();
        result.put("token","admin-token");
        return result;
    }


    @RequestMapping(value = "/info")
    public Object info(@RequestParam("token") String token){
        log.info("token is [{}]",token);
        Map<String,Object> result=new HashMap<>();
        result.put("introduction","I am a super administrator");
        result.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        result.put("name","Super Admin");
        List<String> roles=new ArrayList<>();
        roles.add("admin");
        result.put("roles",roles);
        return result;
    }


    @RequestMapping(value = "/logout")
    public Object logout(){
        return "success";
    }

}
