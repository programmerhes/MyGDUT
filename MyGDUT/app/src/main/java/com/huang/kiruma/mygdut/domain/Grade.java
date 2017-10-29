package com.huang.kiruma.mygdut.domain;

import java.io.Serializable;

public class Grade implements Serializable {

	public String xnxqmc;	//2016秋季
	public String kcdlmc;	//专业基础课
	public String kcmc;		//java程序设计
	public String cjjd;		//绩点
	public String zcj;		//成绩
	public String xf;		//百分制

	public String getXf() {
		return xf;
	}
	public void setXf(String xf) {
		this.xf = xf;
	}
	public String getXnxqmc() {
		return xnxqmc;
	}
	public void setXnxqmc(String xnxqmc) {
		this.xnxqmc = xnxqmc;
	}
	public String getKcdlmc() {
		return kcdlmc;
	}
	public void setKcdlmc(String kcdlmc) {
		this.kcdlmc = kcdlmc;
	}
	public String getKcmc() {
		return kcmc;
	}
	public void setKcmc(String kcmc) {
		this.kcmc = kcmc;
	}
	public String getCjjd() {
		return cjjd;
	}
	public void setCjjd(String cjjd) {
		this.cjjd = cjjd;
	}
	public String getZcj() {
		return zcj;
	}
	public void setZcj(String zcj) {
		this.zcj = zcj;
	}
}
