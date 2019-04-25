package cn.bingchuang.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bingchuang.pojo.Pressure;
import cn.bingchuang.service.PressureService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class PressureController {
	@Autowired
	private PressureService pressureService;
	

	//接收网络编程数据（压力）
	@RequestMapping("receivepressure.action")
	@ResponseBody
	public String ReceivePressure(@RequestParam( value = "patientId", required = false) Integer patientId,
			@RequestParam( value = "pressureData", required = false) double pressureData)
	{
		System.out.println("接收网络编程数据（压力）功能开始： 请求信息：patientId="+patientId+"   pressureData="+pressureData);
		Date date=new Date();
		Pressure pressure=new Pressure();
		
		if(patientId==null){
			pressure.setPatientId(32501);
		}else {
			pressure.setPatientId(patientId);
		}
		pressure.setPressureData(pressureData);
		pressure.setPressureTime(date);
		boolean blnaddp=pressureService.insertpressure(pressure);
		JSONObject json =new JSONObject();
		json.put("blnaddp", blnaddp);
		System.out.println("接收网络编程数据（压力）功能结束........返回内容："+json.toString());
		return json.toString();
	}	
		
		
	//查找病人全部压力信息(byId)
	@RequestMapping("selectallpressurebyid.action")
	@ResponseBody
	public String SelectAllPressurebyId(@RequestParam( value = "patientId", required = false) Integer patientId)
	{
		System.out.println("查找全部压力功能开始： 请求信息：patientId:"+patientId);
		if(patientId==null){
			patientId=32501;
		}
		List<Pressure> lists=pressureService.selectallpressurebyId(patientId);
		JSONArray json =JSONArray.fromObject(lists);
		System.out.println("查找全部压力功能结束........返回内容："+json.toString());
		return json.toString();
	}	
	
}
