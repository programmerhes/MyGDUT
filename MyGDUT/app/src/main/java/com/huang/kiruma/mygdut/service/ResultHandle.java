package com.huang.kiruma.mygdut.service;

import org.jsoup.nodes.Document;

/**
 * Created by Lenovo on 2017/10/23.
 */

/**
 * 处理网页返回的数据
 */
public class ResultHandle {


    public String doResultHandle(Document doc) {
        String str = doc.getElementsByTag("body").toString();
        str = str.substring(6);
        str = str.substring(0, str.length() - 7);
        return str;
    }

}
