package com.crc.vue.sso.common.domain;

import java.io.Serializable;

/**
 * @Author: chenrencun
 * @Date: 2019/12/10 17:25
 * @Description: 描述
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
