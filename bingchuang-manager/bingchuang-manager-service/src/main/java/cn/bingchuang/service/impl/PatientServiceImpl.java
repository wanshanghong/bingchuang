package cn.bingchuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bingchuang.mapper.PatientMapper;
import cn.bingchuang.pojo.Patient;
import cn.bingchuang.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	private PatientMapper patientMapper;
	
	@Override
	public boolean addpatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientMapper.addpatient(patient);
	}
	@Override
	public boolean updatepatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientMapper.updatepatient(patient);
	}
	@Override
	public Patient findpatientbypatientId(int patientId) {
		// TODO Auto-generated method stub
		return patientMapper.findpatientbypatientId(patientId);
	}
	@Override
	public List<Patient> findpatientallpatient() {
		// TODO Auto-generated method stub
		return patientMapper.findpatientallpatient();
	}
	@Override
	public boolean deletepatientbypatientId(int patientId) {
		// TODO Auto-generated method stub
		return patientMapper.deletepatientbypatientId(patientId);
	}
	@Override
	public int deletepatientallpatient() {
		// TODO Auto-generated method stub
		return patientMapper.deletepatientallpatient();
	}
	
	

	
	
}
