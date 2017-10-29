package com.huang.kiruma.mygdut.service;

import com.huang.kiruma.mygdut.domain.Grade;
import com.huang.kiruma.mygdut.domain.LoginMessage;
import com.huang.kiruma.mygdut.domain.TalkLoginMessage;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonHandle {


    ArrayList<Grade> al = new ArrayList<Grade>();
    JSONObject jo = null;
    JSONArray marks = null;
    JSONObject mark = null;
    LoginMessage loginMessage =null;
    TalkLoginMessage talkLoginMessage=null;
    /**
     * @成绩的json解析
     * @param json
     * @return
     */
    public ArrayList<Grade> doJsonHandle(String json) {
        if (json == null) {
            return null;
        } else {
            try {
                jo = new JSONObject(json);
                marks=jo.getJSONArray("rows");
                for(int i=0; i<marks.length();i++){
                    Grade g=new Grade();
                    mark = (JSONObject)marks.get(i);
                    g.setXnxqmc(mark.getString("xnxqmc"));
                    g.setCjjd(mark.getString("cjjd"));
                    g.setKcdlmc(mark.getString("kcdlmc"));
                    g.setKcmc(mark.getString("kcmc"));
                    g.setZcj(mark.getString("zcj"));
                    g.setZcj(mark.getString("zcj"));
                    g.setXf(mark.getString("xf"));
                    al.add(g);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            for(Grade g:al){
                System.out.println(g.getCjjd());
            }
         return al;
        }
    }

    /**
     * @对login 信息的解析
     */
    public LoginMessage doLoginMessageJsonHandle(String json){
        loginMessage=new LoginMessage();
        if (json == null) {
            return null;
        }else {
            try {

                jo = new JSONObject(json);
                System.out.println("this is json"+jo.getString("msg"));

                loginMessage.setMsg(jo.getString("msg"));
                loginMessage.setStatus(jo.getString("status"));

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return loginMessage;
    }
    /**
     * 树洞登录信息的解析
     */
    public TalkLoginMessage doTalkLoginMessageHandle(String json){
        talkLoginMessage=new TalkLoginMessage();
        if(json==null){
            return null;
        }else {
            try{
                jo=new JSONObject(json);
                talkLoginMessage.setMsg(jo.getString("msg"));
                talkLoginMessage.setCode(jo.getString("code"));
                if("200".equals(talkLoginMessage.getCode())){
                    talkLoginMessage.setUser(jo.getString("user"));
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return talkLoginMessage;
    }


}

