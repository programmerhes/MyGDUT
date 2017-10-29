package com.huang.kiruma.mygdut.service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LoginHandle extends AsyncTask<String, Integer, Bitmap>{

	private ImageView imageView=null;
	private Handler handler=null;
	private String session=null;
	private ResultHandle resultHandle=new ResultHandle();
	public LoginHandle(){

	}
	public LoginHandle(Handler handler){

        this.handler=handler;
	}

	public void setImageView(ImageView imageView){

        this.imageView=imageView;
	}
	

    @Override
	protected Bitmap doInBackground(String... params){
		URL url = null;
		Bitmap bitmap = null;
		try {
			url = new URL("http://222.200.98.146/yzm");
			URLConnection con = url.openConnection();
			String session = con.getHeaderField("Set-Cookie");
			this.session=session;

			InputStream is = con.getInputStream();
			bitmap = BitmapFactory.decodeStream(is);
			is.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return bitmap;
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		//TODO Auto-generated method stub

		Message msg = handler.obtainMessage();
		msg.what = 1;
		msg.obj =session.substring(11,43);

		handler.sendMessage(msg);
        imageView.setImageBitmap(result);
	}






	//登录操作
	public String doLogin(String url,String code,String account,String password,String session) throws Exception{
		Connection con= Jsoup.connect(url);
		con.header("Host", "222.200.98.147");
		con.header("Accept", "application/json, text/javascript, */*; q=0.01");
		con.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36 OPR/47.0.2631.80");
		con.header("Referer", "http://222.200.98.147/");
		con.header("Accept-Language", "zh-CN,zh;q=0.8");
		con.header("X-Requested-With", "XMLHttpRequest");
		con.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		
		con.data("account",account);
		con.data("pwd",password);
		con.data("verifycode",code);
		con.cookie("JSESSIONID",session);
		Document d=con.post();
		System.out.println(d);
		return resultHandle.doResultHandle(d);

	}


	
}
