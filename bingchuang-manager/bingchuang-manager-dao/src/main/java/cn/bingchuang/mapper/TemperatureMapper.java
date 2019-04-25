package cn.bingchuang.mapper;

import java.util.List;

import cn.bingchuang.pojo.Temperature;

public interface TemperatureMapper {
	//添加温度
	public boolean addtemperature(Temperature temperature);
		
	//查找病人全部温度信息(byId)
	public List<Temperature> selectalltemperaturebyId(Integer patientId);
	
	//查询最新的一条温度信息 
	public Temperature selectOnetemperaturebyId(Integer patientId);
}
