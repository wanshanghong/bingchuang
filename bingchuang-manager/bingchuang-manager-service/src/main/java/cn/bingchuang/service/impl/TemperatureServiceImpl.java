package cn.bingchuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bingchuang.mapper.TemperatureMapper;
import cn.bingchuang.pojo.Temperature;
import cn.bingchuang.service.TemperatureService;

@Service
public class TemperatureServiceImpl implements TemperatureService{
	@Autowired
	private  TemperatureMapper  temperatureMapper;
	//插入温度 
	@Override
	public boolean addtemperature(Temperature temperature) {
		// TODO Auto-generated method stub
		return temperatureMapper.addtemperature(temperature);
	}
		
	//查找病人全部温度信息(byId)
	@Override
	public List<Temperature> selectalltemperaturebyId(Integer patientId) {
		// TODO Auto-generated method stub
		return temperatureMapper.selectalltemperaturebyId(patientId);
	}

	@Override
	public Temperature selectOnetemperaturebyId(Integer patientId) {
		// TODO Auto-generated method stub
		return temperatureMapper.selectOnetemperaturebyId(patientId);
	}
}
