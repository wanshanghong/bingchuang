package cn.bingchuang.service;

import java.util.List;

import cn.bingchuang.pojo.Patient;

//病人 模块的Service层接口类
public interface PatientService {
		
	//添加病人
	public boolean addpatient(Patient patient);
		
	//修改病人
	public boolean updatepatient(Patient patient);
		
	//通过ID找病人
	public Patient findpatientbypatientId(int  patientId);
		
	//查找全部病人
	public List<Patient> findpatientallpatient();
		
	//通过ID删除病人
	public boolean deletepatientbypatientId(int patientId);
		
	//删除所有病人 
	public int deletepatientallpatient();
	
	



}
