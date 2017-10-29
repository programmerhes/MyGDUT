package com.huang.kiruma.mygdut.service;

import com.huang.kiruma.mygdut.domain.Grade;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/10/16.
 */

public class GradeSearch {

    LoginHandle lh=new LoginHandle();
    JsonHandle jh=new JsonHandle();
    GradeHandle gh=new GradeHandle();
    Grade grade=new Grade();
    ArrayList<Grade> al=null;
    String session=null;

    String code_url="http://222.200.98.146/yzm";
    String login_url="http://222.200.98.146/login!doLogin.action";
    String grade_url="http://222.200.98.146/xskccjxx!getDataList.action";



    public String login(String code,String account,String password,String session) throws Exception{

        return lh.doLogin(login_url,code,account,password,session);

    }
    public ArrayList<Grade> search(String session){
        String json=null;
        try {
             json = gh.getGrade(grade_url, session,"201602");
             //json=gh.getAllGrade(grade_url,session);
        }catch (Exception e){
            e.printStackTrace();
        }

        return jh.doJsonHandle(json);

    }

}
