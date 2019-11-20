package cn.com.cube.platform.barber.utils.filter;

import cn.com.cube.platform.barber.mysql.vo.AccountVo;
import cn.com.cube.platform.barber.utils.CookieUtils;
import cn.com.cube.platform.barber.utils.RedisUtils;
import cn.com.cube.platform.barber.utils.exception.PostException;
import cn.com.cube.platform.barber.utils.global.GlobalHolder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Order(2)
@Component
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);

    @Value("${sso.path.url}")
    private String loginUrl;

    @Value("${sso.path.exclude}")
    private String excludePath;

    private String[] excludePaths;

    private static String TOKEN="token";

    private AntPathMatcher antPathMatcher=new AntPathMatcher();

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String encodeToken= CookieUtils.getCookie(request,TOKEN);
        String requestURI = request.getRequestURI().replace(request.getContextPath(), "");

        log.info("request url is [{}],token is [{}]",requestURI,encodeToken);

        Boolean flag=false;
        if(excludePaths!=null&&excludePaths.length>0){
            for(String item:excludePaths){
                if(antPathMatcher.match(item,requestURI)){
                    flag=true;
                    break;
                }
            }
        }
        //如果是exclude的请求，通行
        if(flag){
            log.info("excludepath contains [{}],request ok",requestURI);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //如果是登录的页面，直接通行
        if(antPathMatcher.match(loginUrl,requestURI)){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //如果是其他页面
        // 必须要有token， token 必须要是有效token
        if(StringUtils.isNotBlank(encodeToken)){
           if(redisUtils.getObj(encodeToken)!=null){
              log.info("token [{}] is ok",encodeToken);
               GlobalHolder.set((AccountVo) redisUtils.getObj(encodeToken));
               filterChain.doFilter(servletRequest, servletResponse);
               return;
            }
        }
        log.info("request url is [{}] forbid",requestURI);
        throw new PostException("鉴权错误");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if(StringUtils.isNotBlank(excludePath)){
            excludePaths=excludePath.split(",");
        }
    }

    @Override
    public void destroy() {

    }
}
