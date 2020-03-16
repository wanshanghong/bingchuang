package cn.bingchuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bingchuang.mapper.PatientMapper;
import cn.bingchuang.pojo.Patient;
import cn.bingchuang.service.PatientService;

//病人 模块的Service层实现类
@Service
public class PatientServiceImpl implements PatientService{
	//注解 获取Dao层的PatientMapper
	@Autowired
	private PatientMapper patientMapper;
	
	//添加病人
	@Override
	public boolean addpatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientMapper.addpatient(patient);
	}
	
	//修改病人
	@Override
	public boolean updatepatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientMapper.updatepatient(patient);
	}
	//通过ID找病人
	@Override
	public Patient findpatientbypatientId(int patientId) {
		// TODO Auto-generated method stub
		return patientMapper.findpatientbypatientId(patientId);
	}
	//查找全部病人
	@Override
	public List<Patient> findpatientallpatient() {
		// TODO Auto-generated method stub
		return patientMapper.findpatientallpatient();
	}
	//通过ID删除病人
	@Override
	public boolean deletepatientbypatientId(int patientId) {
		// TODO Auto-generated method stub
		return patientMapper.deletepatientbypatientId(patientId);
	}

	//删除所有病人 
	@Override
	public int deletepatientallpatient() {
		// TODO Auto-generated method stub
		return patientMapper.deletepatientallpatient();
	}
	
	

	
	
}
