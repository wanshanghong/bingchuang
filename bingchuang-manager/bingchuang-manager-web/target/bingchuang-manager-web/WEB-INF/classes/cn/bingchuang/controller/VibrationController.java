package cn.bingchuang.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bingchuang.pojo.Vibration;
import cn.bingchuang.service.VibrationService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class VibrationController {
	@Autowired
	private VibrationService vibrationService;
	/**
	 * class Vibration {
	private int patientId;         //病人ID
	private double vibrationData;	//病人震动数据
	private Date vibrationTime;		//震动时间
	*/
	//接收网络编程数据（震动）
	@RequestMapping("receivevibration.action")
	@ResponseBody
	public String ReceiveVibration(@RequestParam( value = "patientId", required = false) Integer patientId,
			@RequestParam( value = "vibrationData", required = false) double vibrationData)
	{
		System.out.println("接收网络编程数据（震动）功能开始： 请求信息：patientId="+patientId+"   vibrationData="+vibrationData);
		Date date=new Date();
		Vibration vibration=new Vibration();
		if(patientId==null){
			vibration.setPatientId(32501);
		}else{
			vibration.setPatientId(patientId);
		}
		
		vibration.setVibrationData(vibrationData);
		vibration.setVibrationTime(date);
		boolean vibaddp=vibrationService.insertvibration(vibration);
		JSONObject json =new JSONObject();
		json.put("vibaddp", vibaddp);
		System.out.println("接收网络编程数据（震动）功能结束........返回内容："+json.toString());
		return json.toString();
	}	
	
	
	//查找病人全部震动信息(byId)
	@RequestMapping("selectallvibrationbyid.action")
	@ResponseBody
	public String SelectAllVibrationbyId(@RequestParam( value = "patientId", required = false) Integer patientId)
	{
		System.out.println("查找全部震动功能开始： 请求信息：patientId="+patientId);
		if(patientId==null){
			patientId=32501;
		}
		List<Vibration> lists=vibrationService.selectallvibrationbyId(patientId);
		JSONArray json =JSONArray.fromObject(lists);
		System.out.println("查找全部震动功能结束........返回内容："+json.toString());
		return json.toString();
	}	
}
