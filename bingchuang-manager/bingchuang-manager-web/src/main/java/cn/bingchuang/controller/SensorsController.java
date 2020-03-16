package cn.bingchuang.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bingchuang.pojo.Liquid;
import cn.bingchuang.pojo.Temperature;
import cn.bingchuang.pojo.Urine;
import cn.bingchuang.service.SensorsService;
import net.sf.json.JSONObject;

//传感器的Controller层
@Controller
public class SensorsController {
	//注解   获取SensorsService
	@Autowired
	private SensorsService sensorsService;   

	//液位传感器（数据传入）
	@RequestMapping("AddLiquid.action")
	@ResponseBody
	public String AddLiquid(@RequestParam( value = "pid", required = false) Integer pid,
			@RequestParam(value = "lData", required = false) double lData)
	{
		System.out.println("液位传感器（数据传入）功能开始： 请求信息：lData："+lData);
		Liquid liquid=new Liquid();
		Date date=new Date();
		if(pid==null){
			liquid.setPid(32501);
		}else{
			liquid.setPid(pid.intValue());
		}
		liquid.setlData(lData);
		liquid.setlTime(date);
		//调用sensorsService的AddLiquid
		boolean result=sensorsService.AddLiquid(liquid); 
		//封装JSONObject
		JSONObject json =new JSONObject();					
		json.put("result", result);
		System.out.println("液位传感器（数据传入）功能结束........返回内容："+json.toString());
		//返回数据到移动终端
		return json.toString();                  
	}
	
	//查找液位传感器数据,传到移动终端
	@RequestMapping("FindLiquidById.action")
	@ResponseBody
	public String FindLiquidById(@RequestParam( value = "pid", required = false) Integer pid)
	{
		int p_id;
		if(pid==null){
			p_id=32501;
		}else{
			p_id=pid.intValue();
		}
		System.out.println("查找液位传感器数据,传到移动终端功能开始： 请求信息：pid："+p_id);
		 //调用sensorsService的AddLiquid
		Liquid liquid=sensorsService.FindLiquidById(p_id);			
		//将Liquid实体封装成JSONOject
		JSONObject json =JSONObject.fromObject(liquid);				
		System.out.println("查找液位传感器数据,传到移动终端功能结束........返回内容："+json.toString());
		//返回数据到移动终端
		return json.toString();					
	}

	//温度传感器（数据传入）
	@RequestMapping("AddTemperature.action")
	@ResponseBody
	public String AddTemperature(@RequestParam( value = "patientId", required = false) Integer patientId,
			@RequestParam(value = "temp", required = false) double temp)
	{
		System.out.println("温度传感器（数据传入）功能开始： 请求信息：temp："+temp);
		Temperature temperature=new Temperature();
		Date date=new Date();
		if(patientId==null){
			temperature.setPatientId(32501);
		}else{
			temperature.setPatientId(patientId.intValue());
		}
		temperature.setDate(date);
		temperature.setTemp(temp);
		//调用sensorsService的AddTemperature
		boolean result=sensorsService.AddTemperature(temperature);    
		//封装JSONObject
		JSONObject json =new JSONObject();				
		json.put("result", result);
		System.out.println("温度传感器（数据传入）功能结束........返回内容："+json.toString());
		 //返回数据到移动终端
		return json.toString();                 
	}
	 
	//查找温度传感器数据,传到移动终端
	@RequestMapping("SelectTemperatureById.action")
	@ResponseBody
	public String SelectTemperatureById(@RequestParam( value = "patientId", required = false) Integer patientId)
	{
		int p_id;
		if(patientId==null){
			p_id=32501;
		}else{
			p_id=patientId.intValue();
		}
		System.out.println("查找温度传感器数据,传到移动终端功能开始： 请求信息：pid："+p_id);
		//调用sensorsService的SelectTemperatureById方法
		Temperature temperature=sensorsService.SelectTemperatureById(p_id);		 
		//将Liquid实体封装成JSONOject
		JSONObject json =JSONObject.fromObject(temperature);				
		System.out.println("查找温度传感器数据,传到移动终端功能结束........返回内容："+json.toString());
		//返回数据到移动终端
		return json.toString();					
	}
	
	//尿液检测传感器（数据传入）
	@RequestMapping("AddUrine.action")
	@ResponseBody
	public String AddUrine(@RequestParam( value = "pId", required = false) Integer pId,
			@RequestParam(value = "uData", required = false) double uData)
	{
		System.out.println("尿液检测传感器（数据传入）功能开始： 请求信息：uData："+uData);
		Urine urine=new Urine();
		Date date=new Date();
		if(pId==null){
			urine.setpId(32501);
		}else{
			urine.setpId(pId.intValue());
		}
		urine.setuData(uData);
		urine.setuTime(date);
		 //调用sensorsService的AddUrine方法
		boolean result=sensorsService.AddUrine(urine);  
		//封装JSONObject
		JSONObject json =new JSONObject();					
		json.put("result", result);
		System.out.println("尿液检测传感器（数据传入）功能结束........返回内容："+json.toString());
		//返回数据到移动终端
		return json.toString();                  
	}
	
	//查找尿液检测传感器数据,传到移动终端
	@RequestMapping("SelectUrineById.action")
	@ResponseBody
	public String SelectUrineById(@RequestParam( value = "pId", required = false) Integer pId)
	{
		int p_id;
		if(pId==null){
			p_id=32501;
		}else{
			p_id=pId.intValue();
		}
		System.out.println("查找尿液检测传感器数据,传到移动终端功能开始： 请求信息：pid："+p_id);
		//调用sensorsService的SelectUrineById方法
		Urine urine=sensorsService.SelectUrineById(p_id);		 
		//将Liquid实体封装成JSONOject
		JSONObject json =JSONObject.fromObject(urine);				
		System.out.println("查找尿液检测传感器数据,传到移动终端功能结束........返回内容："+json.toString());
		//返回数据到移动终端
		return json.toString();					
	}
}
