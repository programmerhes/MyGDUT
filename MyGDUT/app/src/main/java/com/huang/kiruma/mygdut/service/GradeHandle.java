package com.huang.kiruma.mygdut.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GradeHandle {
	private ResultHandle resultHandle=new ResultHandle();
	
	public String getGrade(String url,String session,String year) throws Exception{
		Document doc = null;
		
		Connection con= Jsoup.connect(url);
		con.header("Host", "222.200.98.147");
		con.header("Accept", "application/json, text/javascript, */*; q=0.01");
		con.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36 OPR/47.0.2631.80");
		con.header("Referer", "http://222.200.98.147/xskccjxx!xskccjList.action?firstquery=1");
		con.header("Accept-Language", "zh-CN,zh;q=0.8");
		con.header("X-Requested-With", "XMLHttpRequest");
		con.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		con.data("xnxqdm",year);
		con.data("page","1");
		con.data("rows","50");
		con.data("sort","xnxqdm");
		con.data("order","asc");
		con.cookie("JSESSIONID",session);
		doc=con.post();
		if(doc!=null){
			System.out.print(doc);
			return resultHandle.doResultHandle(doc);
		}else{
			return null;
		}
	}
		
	public String getAllGrade(String url,String session) throws Exception{
		return resultHandle.doResultHandle(Jsoup.connect(url).cookie("JSESSIONID",session).get());
	}

}
