package com.crc.vue.server2.controller;

import com.crc.vue.sso.common.util.ResultMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenrencun
 * @Date: 2019/12/11 14:08
 * @Description: 描述
 */
@RestController
@RequestMapping("/server2")
public class Server1Controller {

    @RequestMapping("/index")
    public ResultMessage index(String token) {
        if (token != null && !token.isEmpty()) {
            return new ResultMessage("这是系统2的资源");
        }
        return new ResultMessage("error", "登录用户过期");
    }
}
