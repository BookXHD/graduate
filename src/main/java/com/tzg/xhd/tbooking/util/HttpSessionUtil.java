package com.tzg.xhd.tbooking.util;

import com.tzg.xhd.tbooking.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpSessionUtil {private static Logger log = LoggerFactory.getLogger(HttpSessionUtil.class);
    /** 用户session失效时间 */
    private static final int    SESSION_INVALID_SECONDS = 900;

    /*******登录用户信息KEY**********/
    public static final String SESSION_LOGIN_USER_KEY  = "_loginSessionInfo";

    /**
     * 把用户对象放入session
     * @param user
     */
    public static void setLoginUserSession(User user) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(SESSION_INVALID_SECONDS);
        session.setAttribute(SESSION_LOGIN_USER_KEY, user);
    }

    /**
     * 从session中获取用户对象
     * @return
     */
    public static User getLoginUserSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        if (session == null) {
            return null;
        }
        User user = (User) session.getAttribute(SESSION_LOGIN_USER_KEY);
        return user;
    }
}
