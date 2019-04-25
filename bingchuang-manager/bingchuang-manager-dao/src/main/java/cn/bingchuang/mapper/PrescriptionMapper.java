package cn.bingchuang.mapper;

import java.util.List;

import cn.bingchuang.pojo.Prescription;

public interface PrescriptionMapper {
	//插入一条用药信息
	public boolean addoneprescription(Prescription prescription);
	
	//查询所有的用药信息（bypatientid）
	public List<Prescription> selectAllprescriptionbypatientid(Integer patientId);
}
