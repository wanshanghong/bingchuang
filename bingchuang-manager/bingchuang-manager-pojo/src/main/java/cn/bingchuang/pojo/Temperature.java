package cn.bingchuang.pojo;

import java.util.Date;

//温度javabean
public class Temperature {
	private int patientId;   //病床ID
	private double temp;	//温度数据
	private Date date;		//时间
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Temperature [patientId=" + patientId + ", temp=" + temp + ", date=" + date + "]";
	}
	
}
