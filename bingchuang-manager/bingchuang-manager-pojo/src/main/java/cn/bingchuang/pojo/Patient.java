package cn.bingchuang.pojo;

import java.util.Date;

//患者javabean
public class Patient {
	private int patientId;              //病人ID/床号
	private String patientName;         //病人名字
	private String patientSex;          //病人性别
	private int patientAge;             //病人年龄
	private String patientIdcard;       //病人身份证
	private String patientAddress;      //病人家庭地址
	private int patientPhone;           //病人电话
	private String diseaseInformation;  //病症信息
	private Date  admissionTime;	    //入院时间
	private String hospitalName;        //医院名称
	private String patientPhoto;        //病人头像
	public String getPatientPhoto() {
		return patientPhoto;
	}
	public void setPatientPhoto(String patientPhoto) {
		this.patientPhoto = patientPhoto;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientIdcard() {
		return patientIdcard;
	}
	public void setPatientIdcard(String patientIdcard) {
		this.patientIdcard = patientIdcard;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public Date getAdmissionTime() {
		return admissionTime;
	}
	public void setAdmissionTime(Date admissionTime) {
		this.admissionTime = admissionTime;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public int getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(int patientPhone) {
		this.patientPhone = patientPhone;
	}
	public String getDiseaseInformation() {
		return diseaseInformation;
	}
	public void setDiseaseInformation(String diseaseInformation) {
		this.diseaseInformation = diseaseInformation;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientSex=" + patientSex
				+ ", patientAge=" + patientAge + ", patientIdcard=" + patientIdcard + ", patientAddress="
				+ patientAddress + ", patientPhone=" + patientPhone + ", diseaseInformation=" + diseaseInformation
				+ ", admissionTime=" + admissionTime + ", hospitalName=" + hospitalName + ", patientPhoto="
				+ patientPhoto + "]";
	}
	
}
