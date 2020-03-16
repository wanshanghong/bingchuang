package cn.bingchuang.pojo;

import java.util.Date;

//吃药准则javabean
public class Prescription {
	private int prescriptionId;  	 //药id
	private int patientId;			 //病人id
	private String prescriptionName;	//药名
	private Date prescriptionDate;		//吃药时间
	private String prescriptionSrc;		//吃药准则
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPrescriptionName() {
		return prescriptionName;
	}
	public void setPrescriptionName(String prescriptionName) {
		this.prescriptionName = prescriptionName;
	}
	public Date getPrescriptionDate() {
		return prescriptionDate;
	}
	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}
	public String getPrescriptionSrc() {
		return prescriptionSrc;
	}
	public void setPrescriptionSrc(String prescriptionSrc) {
		this.prescriptionSrc = prescriptionSrc;
	}
	@Override
	public String toString() {
		return "Prescription [prescriptionId=" + prescriptionId + ", patientId=" + patientId + ", prescriptionName="
				+ prescriptionName + ", prescriptionDate=" + prescriptionDate + ", prescriptionSrc=" + prescriptionSrc
				+ "]";
	}
	
}
