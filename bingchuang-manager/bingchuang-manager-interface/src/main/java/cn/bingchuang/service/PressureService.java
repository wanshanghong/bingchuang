package cn.bingchuang.service;

import java.util.List;

import cn.bingchuang.pojo.Pressure;

public interface PressureService {
	
	//添加压力
	public boolean insertpressure(Pressure pressure);
		
	//查找病人全部压力信息(byId)
	public List<Pressure> selectallpressurebyId(Integer patientId);
	
	//查询最新的一条压力信息(byId)
	public Pressure selectOnepressurebyId(Integer patientId);
}
