package com.huang.kiruma.mygdut.domain;

import java.io.Serializable;

/**
 * Created by Lenovo on 2017/10/23.
 */

public class LoginMessage implements Serializable {
    private String msg;
    private String status;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
