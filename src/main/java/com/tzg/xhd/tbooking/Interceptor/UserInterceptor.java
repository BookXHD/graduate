package com.tzg.xhd.tbooking.Interceptor;

import com.tzg.xhd.tbooking.entity.User;
import com.tzg.xhd.tbooking.util.HttpSessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor extends HandlerInterceptorAdapter {
    private static Logger log = LoggerFactory.getLogger(UserInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的URL
        String url = request.getRequestURI();
        log.info("UserInterceptor preHandle url:" + url);

        //验证用户是否登录
        User user = HttpSessionUtil.getLoginUserSession();
        if(null != user) {
            return true;
        }

        //非法访问，则跳转到登录界面
        request.getRequestDispatcher("/user/login").forward(request, response);

        return false;
    }
}
