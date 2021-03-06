package cn.bingchuang.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.bingchuang.pojo.Patient;
import cn.bingchuang.service.PatientService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class PatientController {
	@Autowired
	private PatientService patientService;
	/**
	 *  private int patientId;            //病人ID
		private String patientName;       //病人名字
		private String patientSex;        //病人性别
		private int patientAge;           //病人年龄
		private String patientIdcard;     //病人身份证
		private String patientAddress;    //病人家庭地址
		private int patientPhone;         //病人电话
		private String patientPhoto;      //病人头像
	 * @throws IOException 
	 * @throws IllegalStateException 
	*/
	
	//添加病人信息
	@RequestMapping("addpatient.action")
	@ResponseBody
	public String AddPatient(@RequestParam( value = "patientId", required = false) int patientId,
			@RequestParam( value = "patientName", required = false) String patientName,@RequestParam( value = "patientSex", required = false) String patientSex,
			@RequestParam( value = "patientAge", required = false) int patientAge,@RequestParam( value = "patientIdcard", required = false) String patientIdcard,
			@RequestParam( value = "patientAddress", required = false) String patientAddress,@RequestParam( value = "patientPhone", required = false) int patientPhone,
			@RequestParam( value = "patientPhoto", required = false) MultipartFile patientPhoto,HttpServletRequest request) throws IllegalStateException, IOException
	{
		System.out.println("添加病人信息功能开始： 请求信息：patientId："+patientId+"  patientName:"+patientName+"  patientSex:"+patientSex
				+"  patientAge:"+patientAge+"  patientIdcard:"+patientIdcard+"  patientAddress:"+patientAddress+"  patientPhone:"+patientPhone
				+"  patientPhoto:"+patientPhoto);
		
		Patient patient=new Patient();
		patient.setPatientId(patientId);
		patient.setPatientName(patientName);
		patient.setPatientSex(patientSex);
		patient.setPatientAge(patientAge);
		patient.setPatientIdcard(patientIdcard);
		patient.setPatientAddress(patientAddress);
		patient.setPatientPhone(patientPhone);
		
		//上传图片
		//获得物理路径webapp所在路径
		String pathRoot = request.getSession().getServletContext().getRealPath("");
		String path1="";
		if(!patientPhoto.isEmpty()){
			//生成uuid作为文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("","");
			//获得文件类型（可以判断如果不是图片，禁止上传）			
			String contentType=patientPhoto.getContentType();
			//获得文件后缀名称
			String imageName=contentType.substring(contentType.indexOf("/")+1);
			path1="/static/images/patientphoto"+uuid+"."+imageName;
			patientPhoto.transferTo(new File(pathRoot+path1));
			}
		patient.setPatientPhoto(path1);
		boolean addbln=patientService.addpatient(patient);
		JSONObject json =new JSONObject();
		json.put("addbln", addbln);
		System.out.println("添加病人信息功能结束........返回内容："+json.toString());
		return json.toString();
	}
	
	//修改病人
	@RequestMapping("updatepatient.action")
	@ResponseBody
	public String UpdatePatient(@RequestParam( value = "patientId", required = false) Integer patientId,
			@RequestParam( value = "patientName", required = false) String patientName,@RequestParam( value = "patientSex", required = false) String patientSex,
			@RequestParam( value = "patientAge", required = false) int patientAge,@RequestParam( value = "patientIdcard", required = false) String patientIdcard,
			@RequestParam( value = "patientAddress", required = false) String patientAddress,@RequestParam( value = "patientPhone", required = false) int patientPhone,
			@RequestParam( value = "patientPhoto", required = false) String patientPhoto)
	{
		System.out.println("修改病人功能开始： 请求信息：patientId："+patientId+"  patientName:"+patientName+"  patientSex:"+patientSex
				+"  patientAge:"+patientAge+"  patientIdcard:"+patientIdcard+"  patientAddress:"+patientAddress+"  patientPhone:"+patientPhone
				+"  patientPhoto:"+patientPhoto);
		Patient patient=new Patient();
		patient.setPatientId(patientId);
		patient.setPatientName(patientName);
		patient.setPatientSex(patientSex);
		patient.setPatientAge(patientAge);
		patient.setPatientIdcard(patientIdcard);
		patient.setPatientAddress(patientAddress);
		patient.setPatientPhone(patientPhone);
		patient.setPatientPhoto(patientPhoto);
		boolean updatebln=patientService.updatepatient(patient);
		JSONObject json =new JSONObject();
		json.put("updatebln", updatebln);
		System.out.println("修改病人功能结束........返回内容："+json.toString());
		return json.toString();
	}

	//通过ID找病人
	@RequestMapping("findpatientbypatientId.action")
	@ResponseBody
	public String FindPatientByPatientId(@RequestParam( value = "patientId", required = false) int patientId)
	{
		System.out.println("通过ID找病人功能开始： 请求信息：patientId："+patientId);
		Patient patient=patientService.findpatientbypatientId(patientId);
		JSONObject json =JSONObject.fromObject(patient);
		System.out.println("通过ID找病人功能结束........返回内容："+json.toString());
		return json.toString();
	}
	
	//查找全部病人
	@RequestMapping("findpatientallpatient.action")
	@ResponseBody
	public String FindPatientAllPatient()
	{
		System.out.println("查找全部病人功能开始： 请求信息：无");
		List<Patient> lists=patientService.findpatientallpatient();
		JSONArray json =JSONArray.fromObject(lists);
		System.out.println("查找全部病人功能结束........返回内容："+json.toString());
		return json.toString();
	}		
	
	//通过ID删除病人
	@RequestMapping("deletepatientbypatientId.action")
	@ResponseBody
	public String DeletePatientByPatientId(@RequestParam( value = "patientId", required = false) int patientId)
	{
		System.out.println("通过ID删除病人功能开始： 请求信息：无");
		boolean deletebln=patientService.deletepatientbypatientId(patientId);
		JSONObject json =new JSONObject();
		json.put("deletebln", deletebln);
		System.out.println("通过ID删除病人功能结束........返回内容："+json.toString());
		return json.toString();
	}	
			
	//删除所有病人 
	@RequestMapping("deletepatientallpatient.action")
	@ResponseBody
	public String DeletePatientAllPatient()
	{
		System.out.println("通过ID删除病人功能开始： 请求信息：无");
		int deletesum=patientService.deletepatientallpatient();
		JSONObject json =new JSONObject();
		json.put("deletesum", deletesum);
		System.out.println("通过ID删除病人功能结束........返回内容："+json.toString());
		return json.toString();
	}	
		
	
	
}
