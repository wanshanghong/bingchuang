package cn.bingchuang.pojo;

import java.util.Date;

public class Temperature {
	private int patientId;
	private double temp;
	private Date date;
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
