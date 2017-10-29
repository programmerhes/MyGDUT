package com.huang.kiruma.mygdut.service;

import com.huang.kiruma.mygdut.domain.TalkLoginMessage;

import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Lenovo on 2017/10/26.
 */

public class WebService {

    //private String ip="http://10.0.2.2:8080/Blog/mvc/logi";
    //private URL url=null;
   // Map<String, String> params = new HashMap<String, String>();
    JSONObject jsonObject=new JSONObject();
    private byte[] data;
    private String username=null;
    private String password=null;
    private JsonHandle jsonHandle=null;
    private TalkLoginMessage talkLoginMessage=null;
    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public TalkLoginMessage postRequest() {
        try {
            jsonHandle=new JsonHandle();
            jsonObject.put("username",username);
            jsonObject.put("password",password);
            data=jsonObject.toString().getBytes();
            System.out.println("data"+jsonObject.toString());

            URL url=new URL("http://10.0.2.2:8080/Blog/mvc/login");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            System.out.println("ss"+httpURLConnection.toString());
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");

            httpURLConnection.connect();

            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(data);
            outputStream.flush();

            InputStream is=httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "/n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                   is.close();
                } catch (Exception e)
                {e.printStackTrace();
                }
            }
            System.out.println(sb.toString());

           talkLoginMessage= jsonHandle.doTalkLoginMessageHandle(sb.toString());


        }catch (Exception e){
            e.printStackTrace();
        }
        return  talkLoginMessage;
    }



}
