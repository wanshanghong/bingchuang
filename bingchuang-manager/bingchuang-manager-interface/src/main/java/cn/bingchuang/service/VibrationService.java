package cn.bingchuang.service;

import java.util.List;

import cn.bingchuang.pojo.Vibration;

public interface VibrationService {
	//插入震动数据
	public boolean insertvibration(Vibration vibration);
					
	//查找病人全部震动信息(byId)
	public List<Vibration> selectallvibrationbyId(Integer patientId);
	
	//查询最新的一条震动信息(byId)
	public Vibration selectOnevibrationbyId(Integer patientId);
}
