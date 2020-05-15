package com.xxx.order.interceptor;

import com.xxx.auth.entity.UserInfo;
import com.xxx.auth.utils.JwtUtils;
import com.xxx.common.utils.CookieUtils;
import com.xxx.config.JwtProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private JwtProperties jwtProperties;

    // 定义一个线程域，存放登录用户
    private static final ThreadLocal<UserInfo> tl = new ThreadLocal<>();

    public LoginInterceptor(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 查询token
        String token = CookieUtils.getCookieValue(request, "XXX_TOKEN");
        if (StringUtils.isBlank(token)) {
            // 未登录,返回401
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            logger.error("登陆拦截：未登录，返回401。");
            return false;
        }
        // 有token，查询用户信息
        try {
            // 解析成功，证明已经登录
            UserInfo user = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
            // 放入线程域
            tl.set(user);
            logger.info("Token 解析成功，已经登录。用户信息放入线程。放行！");
            return true;
        } catch (Exception e) {
            // 抛出异常，证明未登录或超时,返回401
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            logger.error("登陆拦截：抛出异常，证明未登录或超时，返回401。");
            return false;
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        tl.remove();
    }

    public static UserInfo getLoginUser() {
        return tl.get();
    }
}