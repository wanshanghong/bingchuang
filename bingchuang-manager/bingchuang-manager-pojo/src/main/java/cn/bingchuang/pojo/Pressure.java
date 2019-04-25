package cn.bingchuang.pojo;

import java.util.Date;

public class Pressure {
	private int patientId;	//病人ID	
	private double pressureData;	//压力数据
	private Date pressureTime;		//时间
	
	public int getPatientId() {
		
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public double getPressureData() {
		return pressureData;
	}
	public void setPressureData(double pressureData) {
		this.pressureData = pressureData;
	}
	public Date getPressureTime() {
		return pressureTime;
	}
	public void setPressureTime(Date pressureTime) {
		this.pressureTime = pressureTime;
	}
	@Override
	public String toString() {
		return "Pressure [patientId=" + patientId + ", pressureData=" + pressureData + ", pressureTime=" + pressureTime
				+ "]";
	}
}
