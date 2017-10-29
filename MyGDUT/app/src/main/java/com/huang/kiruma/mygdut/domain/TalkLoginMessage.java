package com.huang.kiruma.mygdut.domain;

import java.io.Serializable;

/**
 * Created by Lenovo on 2017/10/28.
 */

public class TalkLoginMessage  implements Serializable {
    private String user;
    private String msg;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
