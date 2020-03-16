package cn.bingchuang.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.bingchuang.pojo.Patient;
import cn.bingchuang.service.PatientService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//病人（Patient）模块的Controller层
@Controller
public class PatientController {
	
	//注解获取Service的PatientService对象
	@Autowired
	private PatientService patientService; 

	//增加病人
	@RequestMapping("addpatient.action")
	@ResponseBody
	public String AddPatient(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, ParseException
	{
		System.out.println("开始");
		//获取一个文件请求的MultipartHttpServletRequest对象
		MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);  
		//通过MultipartHttpServletRequest对象获取文件
		MultipartFile patientPhoto = ((MultipartHttpServletRequest) request).getFile("patientPhoto");
		MultipartFile file = null;    
		int patientId;
		//获取前端参数的值，及封装
		String id1=params.getParameter("patientId");
		if(id1==null){
			patientId=32501;
		}else{
			patientId=Integer.parseInt(id1);
		}
		String patientName=params.getParameter("patientName");
		String patientSex=params.getParameter("patientSex");
		int patientAge;
		String age=params.getParameter("patientAge");
		if(age==null){
			patientAge=18;
		}else{
			patientAge=Integer.parseInt(age);
		}
		String patientIdcard=params.getParameter("patientIdcard");
		String patientAddress=params.getParameter("patientAddress");
		
		int patientPhone;
		String phone=params.getParameter("patientPhone");
		if(phone==null){
			patientPhone=18;
		}else{
			patientPhone=Integer.parseInt(phone);
		}
		String diseaseInformation=params.getParameter("diseaseInformation");
		
		Date admissionTime=new Date();
		String hospitalName=params.getParameter("hospitalName");
		
		System.out.println("添加病人信息功能开始： 请求信息：patientId："+patientId+"  patientName:"+patientName+"  patientSex:"+patientSex
				+"  patientAge:"+patientAge+"  patientIdcard:"+patientIdcard+"  patientAddress:"+patientAddress+"  patientPhone:"+patientPhone
				+"  diseaseInformation:"+diseaseInformation+"   admissionTime："+admissionTime+"   hospitalName:"+hospitalName+"  patientPhoto:"+patientPhoto);
		
		Patient patient=new Patient();
		patient.setPatientId(patientId);
		patient.setPatientName(patientName);
		patient.setPatientSex(patientSex);
		patient.setPatientAge(patientAge);
		patient.setPatientIdcard(patientIdcard);
		patient.setPatientAddress(patientAddress);
		patient.setPatientPhone(patientPhone);
		patient.setDiseaseInformation(diseaseInformation);
		patient.setHospitalName(hospitalName);
		patient.setAdmissionTime(admissionTime);
		
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
			path1="/static/images/patientphoto/"+uuid+"."+imageName;
			patientPhoto.transferTo(new File(pathRoot+path1));
			}
		patient.setPatientPhoto("http://47.103.6.223:8080/bingchuang-manager-web/"+path1);
		boolean addbln;
		if(patientService.findpatientbypatientId(patientId)!=null){
			//调用patientService的一个方法进行数据更新
			addbln=patientService.updatepatient(patient);
		}else{
			//调用patientService的一个对象进行存储数据
			addbln=patientService.addpatient(patient);
		}
		//封装JSONObject
		JSONObject json =new JSONObject();
		json.put("addbln", addbln);
		System.out.println("添加病人信息功能结束........返回内容："+json.toString());
		return json.toString();
	}
	//添加病人信息(无照片）
	@RequestMapping("addpatientnophote.action")
	@ResponseBody
	public String AddPatientNoPhote(@RequestParam( value = "patientId", required = false) Integer patientId,
		@RequestParam( value = "patientName", required = false) String patientName,@RequestParam( value = "patientSex", required = false) String patientSex,
		@RequestParam( value = "patientAge", required = false) Integer patientAge,@RequestParam( value = "patientIdcard", required = false) String patientIdcard,
		@RequestParam( value = "patientAddress", required = false) String patientAddress,@RequestParam( value = "patientPhone", required = false) Integer patientPhone,
		@RequestParam( value = "diseaseInformation", required = false) String diseaseInformation,
		@RequestParam( value = "admissionTime", required = false) Date admissionTime,
		@RequestParam( value = "hospitalName", required = false) String hospitalName)
	{
		System.out.println("添加病人信息无图片功能开始： 请求信息：patientId："+patientId+"  patientName:"+patientName+"  patientSex:"+patientSex
				+"  patientAge:"+patientAge+"  patientIdcard:"+patientIdcard+"  patientAddress:"+patientAddress+"  patientPhone:"+patientPhone
				+"  diseaseInformation:"+diseaseInformation+"   admissionTime："+admissionTime+"   hospitalName:"+hospitalName);
		if(patientId==null){
			patientId=32501;
		}
		//将前端数据封装成为一个Javabean实体类
		Patient patient=new Patient();
		patient.setPatientId(patientId);
		patient.setPatientName(patientName);
		patient.setPatientSex(patientSex);
		patient.setPatientAge(patientAge.intValue());
		patient.setPatientIdcard(patientIdcard);
		patient.setPatientAddress(patientAddress);
		patient.setPatientPhone(patientPhone.intValue());
		patient.setDiseaseInformation(diseaseInformation);
		patient.setHospitalName(hospitalName);
		patient.setPatientPhoto("http://47.103.6.223:8080/bingchuang-manager-web/static/images/patientphoto/fault.jpg");
		if(admissionTime==null){
			admissionTime=new Date();
		}
		patient.setAdmissionTime(admissionTime);
		
		boolean addbln;
		//判断是否存在病人
		if(patientService.findpatientbypatientId(patientId)!=null){
			//对病人进行更新操作
			addbln=patientService.updatepatient(patient);
		}else{
			//对病人进行添加操作
			addbln=patientService.addpatient(patient);
		}
		//封装JSONObject
		JSONObject json =new JSONObject();
		json.put("addbln", addbln);
		System.out.println("添加病人无图片信息功能结束........返回内容："+json.toString());
		//回应给移动终端
		return json.toString();
	}
	

	
	//修改病人
	@RequestMapping("updatepatient.action")
	@ResponseBody
	public String UpdatePatient(@RequestParam( value = "patientId", required = false) Integer patientId,
			@RequestParam( value = "patientName", required = false) String patientName,@RequestParam( value = "patientSex", required = false) String patientSex,
			@RequestParam( value = "patientAge", required = false) Integer patientAge,@RequestParam( value = "patientIdcard", required = false) String patientIdcard,
			@RequestParam( value = "patientAddress", required = false) String patientAddress,@RequestParam( value = "patientPhone", required = false) Integer patientPhone,
			@RequestParam( value = "diseaseInformation", required = false) String diseaseInformation,
			@RequestParam( value = "admissionTime", required = false) Date admissionTime,
			@RequestParam( value = "hospitalName", required = false) String hospitalName,
			@RequestParam( value = "patientPhoto", required = false) MultipartFile patientPhoto,HttpServletRequest request) throws IllegalStateException, IOException
	{
		System.out.println("修改病人病人信息功能开始： 请求信息：patientId："+patientId+"  patientName:"+patientName+"  patientSex:"+patientSex
				+"  patientAge:"+patientAge+"  patientIdcard:"+patientIdcard+"  patientAddress:"+patientAddress+"  patientPhone:"+patientPhone
				+"  diseaseInformation:"+diseaseInformation+"   admissionTime："+admissionTime+"   hospitalName:"+hospitalName+"  patientPhoto:"+patientPhoto);
		if(patientId==null){
			patientId=32501;
		}
		Patient patient=new Patient();
		patient.setPatientId(patientId);
		patient.setPatientName(patientName);
		patient.setPatientSex(patientSex);
		if(patientAge==null){
			patient.setPatientAge(20);
		}else{
			patient.setPatientAge(patientAge.intValue());
		}
		//patient.setPatientAge(patientAge.intValue());
		patient.setPatientIdcard(patientIdcard);
		patient.setPatientAddress(patientAddress);
		if(patientPhone==null){
			patient.setPatientPhone(123456789);
		}else{
			patient.setPatientPhone(patientPhone.intValue());
		}
		
		//patient.setPatientPhone(patientPhone.intValue());
		patient.setDiseaseInformation(diseaseInformation);
		patient.setHospitalName(hospitalName);
		if(admissionTime==null){
			admissionTime=new Date();
		}
		patient.setAdmissionTime(admissionTime);
			
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
		boolean updatebln=patientService.updatepatient(patient);
		//封装JSONObject
		JSONObject json =new JSONObject();
		json.put("updatebln", updatebln);
		System.out.println("修改病人功能结束........返回内容："+json.toString());
		//回应给移动终端
		return json.toString();
	}
		
	//修改病人(无图片)
	@RequestMapping("updatepatientnophoto.action")
	@ResponseBody
	public String UpdatePatientNoPhoto(@RequestParam( value = "patientId", required = false) Integer patientId,
			@RequestParam( value = "patientName", required = false) String patientName,@RequestParam( value = "patientSex", required = false) String patientSex,
			@RequestParam( value = "patientAge", required = false) Integer patientAge,@RequestParam( value = "patientIdcard", required = false) String patientIdcard,
			@RequestParam( value = "patientAddress", required = false) String patientAddress,@RequestParam( value = "patientPhone", required = false) Integer patientPhone,
			@RequestParam( value = "diseaseInformation", required = false) String diseaseInformation,
			@RequestParam( value = "admissionTime", required = false) Date admissionTime,
			@RequestParam( value = "hospitalName", required = false) String hospitalName)
	{
		System.out.println("修改病人病人信息(无图片)功能开始： 请求信息：patientId："+patientId+"  patientName:"+patientName+"  patientSex:"+patientSex
				+"  patientAge:"+patientAge+"  patientIdcard:"+patientIdcard+"  patientAddress:"+patientAddress+"  patientPhone:"+patientPhone
				+"  diseaseInformation:"+diseaseInformation+"   admissionTime："+admissionTime+"   hospitalName:"+hospitalName);
		if(patientId==null){
			patientId=32501;
		}
		//将参数信息封装成为一个Javabean实体类
		Patient patient=new Patient();
		patient.setPatientId(patientId);
		patient.setPatientName(patientName);
		patient.setPatientSex(patientSex);
		if(patientAge==null){
			patient.setPatientAge(20);
		}else{
			patient.setPatientAge(patientAge.intValue());
		}
		
		patient.setPatientIdcard(patientIdcard);
		patient.setPatientAddress(patientAddress);
		if(patientPhone==null){
			patient.setPatientPhone(123456789);
		}else{
			patient.setPatientPhone(patientPhone.intValue());
		}
		
		patient.setDiseaseInformation(diseaseInformation);
		patient.setHospitalName(hospitalName);
		if(admissionTime==null){
			admissionTime=new Date();
		}
		patient.setAdmissionTime(admissionTime);
		//调用patientService的一个更新函数
		boolean updatebln=patientService.updatepatient(patient);
		//封装JSONObject
		JSONObject json =new JSONObject();
		json.put("updatebln", updatebln);
		System.out.println("修改病人功能(无图片)结束........返回内容："+json.toString());
		//回应给移动终端
		return json.toString();
	}
		
	//通过ID找病人
	@RequestMapping("findpatientbypatientId.action")
	@ResponseBody
	public String FindPatientByPatientId(@RequestParam( value = "patientId", required = false) Integer patientId)
	{
		if(patientId==null)
		{
			patientId=32501;
		}
		System.out.println("通过ID找病人功能开始： 请求信息：patientId："+patientId);
		//调用patientService的findpatientbypatientId方法
		Patient patient=patientService.findpatientbypatientId(patientId);
		//将patient封装成一个JSONObject实体
		JSONObject json =JSONObject.fromObject(patient);
		System.out.println("通过ID找病人功能结束........返回内容："+json.toString());
		//回应给移动终端
		return json.toString();
	}
	
	//查找全部病人
	@RequestMapping("findpatientallpatient.action")
	@ResponseBody
	public String FindPatientAllPatient()
	{
		System.out.println("查找全部病人功能开始： 请求信息：无");
		
		List<Patient> lists=patientService.findpatientallpatient();
		//将lists封装成一个JSONArray实体
		JSONArray json =JSONArray.fromObject(lists);
		System.out.println("查找全部病人功能结束........返回内容："+json.toString());
		//回应给移动终端
		return json.toString();
	}		
	
	//通过ID删除病人
	@RequestMapping("deletepatientbypatientId.action")
	@ResponseBody
	public String DeletePatientByPatientId(@RequestParam( value = "patientId", required = false) int patientId)
	{
		System.out.println("通过ID删除病人功能开始： 请求信息：无");
		//调用patientService的deletepatientbypatientId方法
		boolean deletebln=patientService.deletepatientbypatientId(patientId);
		//封装JSONObject
		JSONObject json =new JSONObject();
		json.put("deletebln", deletebln);
		System.out.println("通过ID删除病人功能结束........返回内容："+json.toString());
		//回应给移动终端
		return json.toString();
	}	
			
	//删除所有病人 
	@RequestMapping("deletepatientallpatient.action")
	@ResponseBody
	public String DeletePatientAllPatient()
	{
		System.out.println("通过ID删除病人功能开始： 请求信息：无");
		//调用patientService的deletepatientallpatient方法
		int deletesum=patientService.deletepatientallpatient();   
		//封装JSONObject
		JSONObject json =new JSONObject();
		json.put("deletesum", deletesum);
		System.out.println("通过ID删除病人功能结束........返回内容："+json.toString());
		//回应给移动终端
		return json.toString();
	}
}
