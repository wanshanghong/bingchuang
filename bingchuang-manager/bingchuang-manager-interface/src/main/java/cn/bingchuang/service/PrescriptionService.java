package cn.bingchuang.service;

import java.util.List;

import cn.bingchuang.pojo.Prescription;

//用药模块的Service层接口
public interface PrescriptionService {
	//插入一条用药信息
	public boolean addoneprescription(Prescription prescription);
		
	//查询所有的用药信息（bypatientid）
	public List<Prescription> selectAllprescriptionbypatientid(Integer patientId);
}
