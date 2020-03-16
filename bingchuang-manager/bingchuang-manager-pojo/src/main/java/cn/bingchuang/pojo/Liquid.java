package cn.bingchuang.pojo;

import java.util.Date;

//液位javabean
public class Liquid {
	private int pid;     //病床id
	private double lData;   //液位数据
	private Date lTime;		//液位时间
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public double getlData() {
		return lData;
	}
	public void setlData(double lData) {
		this.lData = lData;
	}
	public Date getlTime() {
		return lTime;
	}
	public void setlTime(Date lTime) {
		this.lTime = lTime;
	}
	
}
