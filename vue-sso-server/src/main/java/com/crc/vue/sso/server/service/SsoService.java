package com.crc.vue.sso.server.service;

import com.crc.vue.sso.common.domain.User;
import com.crc.vue.sso.common.util.ResultMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: chenrencun
 * @Date: 2019/12/10 17:28
 * @Description: 描述
 */
public interface SsoService {

    public ResultMessage login(User user, HttpServletRequest request, HttpServletResponse response);

    public ResultMessage getUserByToken(String token);

}
