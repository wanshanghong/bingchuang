package cn.bingchuang.service;

import java.util.List;

import cn.bingchuang.pojo.Temperature;

public interface TemperatureService {
	//添加温度
	public boolean addtemperature(Temperature temperature);
		
	//查找所有的温度
	public List<Temperature> selectalltemperaturebyId(Integer patientId);
	
	//查询最新的一条温度信息 
	public Temperature selectOnetemperaturebyId(Integer patientId);
}
