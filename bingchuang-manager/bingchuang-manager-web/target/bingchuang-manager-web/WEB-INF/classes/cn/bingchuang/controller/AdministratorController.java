package cn.bingchuang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bingchuang.pojo.Administrator;
import cn.bingchuang.service.AdministratorService;
import net.sf.json.JSONObject;

@Controller
public class AdministratorController {
	
	@Autowired
	private AdministratorService administratorService;
		
	
	//管理员注册
	@RequestMapping("register.action")
	@ResponseBody
	public String Register(@RequestParam("administratorName") String administratorName,
			@RequestParam("administratorPassword") String administratorPassword)
	{
		System.out.println("管理员注册功能开启......请求信息：administratorName="+administratorName+"  administratorPassword="+administratorPassword);
		Administrator administrator=new Administrator();
		administrator.setAdministratorPassword(administratorPassword);
		administrator.setAdministratorName(administratorName);
		boolean result=administratorService.addadministrator(administrator);
		JSONObject json=new JSONObject();
		json.put("administratorId", administrator.getAdministratorId());
		System.out.println("管理员注册成功.....返回结果"+json.toString());
		return json.toString();
	}
	
	//管理员登录
	@RequestMapping("login.action")
	@ResponseBody
	public String Login(@RequestParam("administratorName") String administratorName,
			@RequestParam("administratorPassword") String administratorPassword)
	{
		System.out.println("管理员登录功能开启......请求信息：administratorName="+administratorName+"  administratorPassword="+administratorPassword);

		Administrator result=administratorService.selectbyusernameandpassword(administratorName, administratorPassword);
		JSONObject json=JSONObject.fromObject(result);
		System.out.println("管理员登录成功.....返回结果"+json.toString());
		return json.toString();
	}
	
}
