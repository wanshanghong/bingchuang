package cn.bingchuang.pojo;

import java.util.Date;

//检测尿液的Javabean
public class Urine {
	private int pId;      //病床ID
	private double uData;	//尿液检测数据
	private Date uTime;		//时间
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public double getuData() {
		return uData;
	}
	public void setuData(double uData) {
		this.uData = uData;
	}
	public Date getuTime() {
		return uTime;
	}
	public void setuTime(Date uTime) {
		this.uTime = uTime;
	}
	
}
