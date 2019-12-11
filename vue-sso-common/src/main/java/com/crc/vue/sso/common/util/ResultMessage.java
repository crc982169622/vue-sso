package com.crc.vue.sso.common.util;

import java.io.Serializable;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/12 22:29
 **/
public class ResultMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String stateInfo = "success";

    private Object message ;

    public ResultMessage(String stateInfo, Object message) {
        this.stateInfo = stateInfo;
        this.message = message;
    }

    public ResultMessage() {
        super();
    }

    public ResultMessage(Object message) {
        this.message = message;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
