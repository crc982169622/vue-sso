package com.crc.vue.sso.server.controller;

import com.crc.vue.sso.common.domain.User;
import com.crc.vue.sso.common.util.ResultMessage;
import com.crc.vue.sso.server.service.SsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: chenrencun
 * @Date: 2019/12/10 17:18
 * @Description: 描述
 */
@RestController
@RequestMapping("/sso")
public class SsoServerController {

    @Autowired
    private SsoService ssoService;

    @RequestMapping("/login")
    public ResultMessage login(User user, HttpServletRequest request, HttpServletResponse response) {
        return ssoService.login(user, request, response);
    }

    @RequestMapping("/getUserByToken")
    public ResultMessage getUserByToken(String token) {
        return ssoService.getUserByToken(token);
    }
}
