package cn.bingchuang.service;

import cn.bingchuang.pojo.Liquid;
import cn.bingchuang.pojo.Temperature;
import cn.bingchuang.pojo.Urine;

//传感器的Service层接口
public interface SensorsService {
	//液位传感器（数据传入）
	public boolean AddLiquid(Liquid liquid);
		
	//查找液位传感器数据,传到移动终端
	public Liquid FindLiquidById(int pid);
	
	//温度传感器（数据传入）
	public boolean AddTemperature(Temperature temperature);

	//查找温度传感器数据,传到移动终端
	public Temperature SelectTemperatureById(int patientId);

	//尿液检测传感器（数据传入）
	public boolean AddUrine(Urine urine);

	//查找温尿液检测传感器数据,传到移动终端
	public Urine SelectUrineById(int pId);
}
