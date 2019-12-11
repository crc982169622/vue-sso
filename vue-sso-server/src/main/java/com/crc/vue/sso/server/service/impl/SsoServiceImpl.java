package com.crc.vue.sso.server.service.impl;

import com.crc.vue.sso.common.domain.User;
import com.crc.vue.sso.common.util.CookieUtils;
import com.crc.vue.sso.common.util.ResultMessage;
import com.crc.vue.sso.server.service.RedisCacheService;
import com.crc.vue.sso.server.service.SsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author: chenrencun
 * @Date: 2019/12/10 17:30
 * @Description: 描述
 */
@Service
public class SsoServiceImpl implements SsoService {

    @Autowired
    private RedisCacheService redisCacheService;

    @Override
    public ResultMessage login(User user, HttpServletRequest request, HttpServletResponse response) {
        if (user.getUserName().equals("admin") && user.getPassword().equals("11111111")) {
            String token = UUID.randomUUID().toString();
            redisCacheService.put(token, user.getUserName(), 60 * 60 * 24);
/*            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);*/
            return new ResultMessage(token);
        }
        return new ResultMessage("error", "用户名密码错误");
    }

    @Override
    public ResultMessage getUserByToken(String token) {
        String userName = redisCacheService.get(token);
        if (userName.isEmpty()) {
            return new ResultMessage("error", "登录信息已过期");
        } else if (userName.equals("admin")) {
            User user = new User();
            user.setUserName("admin");
            user.setPassword("11111111");
            return new ResultMessage(user);
        }
        return new ResultMessage("error", "获取用户信息失败");
    }
}
