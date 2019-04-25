package cn.bingchuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bingchuang.mapper.PrescriptionMapper;
import cn.bingchuang.pojo.Prescription;
import cn.bingchuang.service.PrescriptionService;


@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	@Autowired
	private  PrescriptionMapper prescriptionMapper;
	
	//插入一条用药信息
	@Override
	public boolean addoneprescription(Prescription prescription) {
		// TODO Auto-generated method stub
		return prescriptionMapper.addoneprescription(prescription);
	}

	//查询所有的用药信息（bypatientid）
	@Override
	public List<Prescription> selectAllprescriptionbypatientid(Integer patientId) {
		// TODO Auto-generated method stub
		return prescriptionMapper.selectAllprescriptionbypatientid(patientId);
	}
}
