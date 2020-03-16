package cn.bingchuang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bingchuang.mapper.SensorsMapper;
import cn.bingchuang.pojo.Liquid;
import cn.bingchuang.pojo.Temperature;
import cn.bingchuang.pojo.Urine;
import cn.bingchuang.service.SensorsService;

//传感器 Service层实现类
@Service
public class SensorsServiceImpl implements SensorsService {
	 //注解 获取Dao层的SensorsMapper
	@Autowired
	private SensorsMapper sensorsMapper;   
	
	//实现SensorsService的AddLiquid(Liquid liquid)方法
	@Override
	public boolean AddLiquid(Liquid liquid) {      
		// TODO Auto-generated method stub
		//调用SensorsMapper的方法
		return sensorsMapper.AddLiquid(liquid);		
	}

	//实现SensorsService的FindLiquidById(int pid)方法
	@Override
	public Liquid FindLiquidById(int pid) {		
		// TODO Auto-generated method stub
		//调用SensorsMapper的方法
		return sensorsMapper.FindLiquidById(pid);     
	}

	//实现SensorsService的AddTemperature(Temperature temperature)方法
	@Override
	public boolean AddTemperature(Temperature temperature) {          
		// TODO Auto-generated method stub
		//调用SensorsMapper的方法
		return sensorsMapper.AddTemperature(temperature);			
	}

	 //实现SensorsService的SelectTemperatureById(int patientId)方法
	@Override
	public Temperature SelectTemperatureById(int patientId) {   
		// TODO Auto-generated method stub
		//调用SensorsMapper的方法
		return sensorsMapper.SelectTemperatureById(patientId);			
	}
	
	//实现SensorsService的AddUrine(Urine urine)方法
	@Override
	public boolean AddUrine(Urine urine) {	
		// TODO Auto-generated method stub
		//调用SensorsMapper的方法
		return sensorsMapper.AddUrine(urine);   
	}

	//实现SensorsService的SelectUrineById(int pId)方法
	@Override
	public Urine SelectUrineById(int pId) { 
		// TODO Auto-generated method stub
		//调用SensorsMapper的方法
		return sensorsMapper.SelectUrineById(pId);
	}

}
