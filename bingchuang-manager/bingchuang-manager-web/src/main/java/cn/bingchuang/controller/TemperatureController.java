package cn.bingchuang.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bingchuang.pojo.Temperature;
import cn.bingchuang.service.TemperatureService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class TemperatureController {
	@Autowired
	private TemperatureService temperatureService;
	
	//接收网络编程数据（体温）
	@RequestMapping("receivetemperature.action")
	@ResponseBody
	public String ReceiveTemperature(@RequestParam( value = "patientId", required = false) Integer patientId,
			@RequestParam(value = "temp", required = false) double temp)
	{
		System.out.println("接收网络编程数据（体温）功能开始： 请求信息：temp："+temp);
		Temperature temperature=new Temperature();
		Date date=new Date();
		temperature.setPatientId(32501);
		temperature.setDate(date);
		temperature.setTemp(temp);
		boolean receive=temperatureService.addtemperature(temperature);
		JSONObject json =new JSONObject();
		json.put("receive", receive);
		System.out.println("通接收网络编程数据（体温）功能结束........返回内容："+json.toString());
		return json.toString();
	}
	//查找病人全部温度信息(byId)
	@RequestMapping("selectalltemperaturebyId.action")
	@ResponseBody
	public String SelectAllTemperatureById(@RequestParam( value = "patientId", required = false) Integer patientId)
	{
		System.out.println("查找病人全部温度信息(byId)： 请求信息：patientId="+patientId);
		if(patientId==null){
			patientId=32501;
		}
		System.out.println("patientId="+patientId.intValue());
		List<Temperature> lists=temperatureService.selectalltemperaturebyId(patientId);
		JSONArray json =JSONArray.fromObject(lists);
		System.out.println("查找病人全部温度信息(byId)结束........返回内容："+json.toString());
		return json.toString();
	}
	
	
	//查询最新的一条温度信息 
	@RequestMapping("selectonetemperaturebyId.action")
	@ResponseBody
	public String selectOnetemperaturebyId(@RequestParam( value = "patientId", required = false) Integer patientId)
	{
		System.out.println("查询最新的一条温度信息 (byId)： 请求信息：patientId="+patientId);
		if(patientId==null){
			patientId=32501;
		}
		System.out.println("patientId="+patientId.intValue());
		Temperature temperature=temperatureService.selectOnetemperaturebyId(patientId);
		JSONObject json =JSONObject.fromObject(temperature);
		System.out.println("查询最新的一条温度信息 (byId)结束........返回内容："+json.toString());
		return json.toString();
	}
	
}
