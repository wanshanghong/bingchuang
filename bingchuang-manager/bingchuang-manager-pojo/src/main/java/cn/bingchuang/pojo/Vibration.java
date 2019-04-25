package cn.bingchuang.pojo;

import java.util.Date;

public class Vibration {
	private int patientId;         //病人ID
	private double vibrationData;	//病人震动数据
	private Date vibrationTime;		//震动时间
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public double getVibrationData() {
		return vibrationData;
	}
	public void setVibrationData(double vibrationData) {
		this.vibrationData = vibrationData;
	}
	public Date getVibrationTime() {
		return vibrationTime;
	}
	public void setVibrationTime(Date vibrationTime) {
		this.vibrationTime = vibrationTime;
	}
	@Override
	public String toString() {
		return "Vibration [patientId=" + patientId + ", vibrationData=" + vibrationData + ", vibrationTime="
				+ vibrationTime + "]";
	}
	
}
