package com.crc.vue.server2.interceptor;

import com.crc.vue.server2.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: chenrencun
 * @Date: 2019/11/26 9:24
 * @Description: 描述
 */
public class WebAdminInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisCacheService redisCacheService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String token = request.getParameter("token");
        //token为空，一定没有登录
        if (token == null || token.isEmpty()) {
            response.setStatus(401);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws IOException {

    }
}
