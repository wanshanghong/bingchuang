package cn.bingchuang.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bingchuang.pojo.Prescription;
import cn.bingchuang.service.PrescriptionService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class PrescriptionController {
	@Autowired
	private PrescriptionService prescriptionService;
	
	/**public class Prescription {
	private int prescriptionId;
	private int patientId;
	private String prescriptionName;
	private Date prescriptionDate;
	private String prescriptionSrc;*/
	//插入一条用药信息
	@RequestMapping("addprescription.action")
	@ResponseBody
	public String addPrescription(@RequestParam( value = "patientId", required = false) Integer patientId,
			@RequestParam(value = "prescriptionName", required = false) String prescriptionName,
			@RequestParam(value = "prescriptionDate", required = false) Date prescriptionDate,
			@RequestParam(value = "prescriptionSrc", required = false) String prescriptionSrc)
	{
		System.out.println("插入一条用药信息功能开始： 请求信息："+"prescriptionName="+prescriptionName+"prescriptionSrc="+prescriptionSrc);
		Prescription prescription=new Prescription();
		if(patientId==null){
			patientId=32501;
		}
		prescription.setPatientId(patientId);
		prescription.setPrescriptionName(prescriptionName);
		prescription.setPrescriptionDate(prescriptionDate);
		prescription.setPrescriptionSrc(prescriptionSrc);
		
		boolean presid=prescriptionService.addoneprescription(prescription);
		JSONObject json =new JSONObject();
		json.put("receive", presid);
		System.out.println("插入一条用药信息功能结束........返回内容："+json.toString());
		return json.toString();
	}
		
	//查询所有的用药信息（bypatientid）
	@RequestMapping("selectallprescriptionbypatientid.action")
	@ResponseBody
	public String selectAllprescriptionbypatientid(@RequestParam( value = "patientId", required = false) Integer patientId)
	{
		System.out.println("查询所有的用药信息（bypatientid）： 请求信息：patientId="+patientId);
		if(patientId==null){
			patientId=32501;
		}
		System.out.println("patientId="+patientId.intValue());
		List<Prescription> lists=prescriptionService.selectAllprescriptionbypatientid(patientId);
		JSONArray json =JSONArray.fromObject(lists);
		System.out.println("查询所有的用药信息（bypatientid）结束........返回内容："+json.toString());
		return json.toString();
	}
		
}
