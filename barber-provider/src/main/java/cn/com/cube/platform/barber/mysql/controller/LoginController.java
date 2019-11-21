package cn.com.cube.platform.barber.mysql.controller;

import cn.com.cube.platform.barber.mysql.service.ITSysAccountService;
import cn.com.cube.platform.barber.utils.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class LoginController {
    private static String TOKEN="Admin-Token";

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ITSysAccountService accountService;

    //登录接口
    @RequestMapping(value = "/login")
    public Object login(@RequestBody Map<String,String> map){
        String username=map.get("username");
        String password=map.get("password");
        log.info("username is [{}],password is [{}]",username,password);
        return accountService.checkAccount(username,password);
    }

    @RequestMapping(value = "/enter-corp")
    public Object enterCorp(@RequestBody Map<String,Integer> map){
        Integer accountId=map.get("accountId");
        Integer departId=map.get("departId");
        log.info("accountId is [{}],departId is [{}]",accountId,departId);
        return accountService.chooseDepart(accountId,departId);
    }

    @RequestMapping(value = "/info")
    public Object info(){
//        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String encodeToken= CookieUtils.getCookie(httpServletRequest,TOKEN);
        log.info("token is [{}]",encodeToken);
        return accountService.getInfoByToken(encodeToken);
    }

    @RequestMapping(value = "/logout")
    public Object logout(){
        String encodeToken= CookieUtils.getCookie(httpServletRequest,TOKEN);
        log.info("token is [{}]",encodeToken);
        accountService.logout(encodeToken);
        return true;
    }


    @Resource
    private HttpServletRequest httpServletRequest;


}
