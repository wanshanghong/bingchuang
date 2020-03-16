package cn.bingchuang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bingchuang.pojo.User;
import cn.bingchuang.service.UserService;
import net.sf.json.JSONObject;

//用户User模块的Controller层
@Controller
public class UserController {
	//注解   获取UserService
	@Autowired
	private UserService userService;
	
	//用户注册(无图片)
	@RequestMapping("userregisternophoto.action")
	@ResponseBody
	public String UserRegisterNoPhoto(@RequestParam( value = "userName", required = false) String userName,
			@RequestParam( value = "userPhone", required = false) String userPhone,
			@RequestParam( value = "userPassword", required = false) String userPassword,
			@RequestParam( value = "userPhoto", required = false) String userPhoto)
	{
		System.out.println("用户注册(无图片)功能开启......请求信息：userName="+userName+"  userPhone="+userPhone);
		//将请求参数封装成为一个User实体
		User user=new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setUserPhone(userPhone);
		if(userPhoto==null){
			user.setUserPhoto("http://47.103.6.223:8080/bingchuang-manager-web/static/images/userphoto/default.JPG");
		}
		//调用userService的AddUser方法
		boolean result=userService.AddUser(user);
		JSONObject json=new JSONObject();
		if(result==true){
			json.put("userId", user.getUserId());
		}else{
			json.put("userId", 0);
		}
		
		System.out.println("用户注册(无图片)成功.....返回结果"+json.toString());
		return json.toString();
	}
	
	
	//用户登录
	@RequestMapping("userlogin.action")
	@ResponseBody
	public String Login(@RequestParam("userName") String userName,
			@RequestParam("userPassword") String userPassword)
	{
		System.out.println("用户登录功能开启......请求信息：userName="+userName+"  userPassword="+userPassword);
		//调用userService的loginUser方法
		User user=userService.loginUser(userName, userPassword);
		JSONObject json=JSONObject.fromObject(user);
		System.out.println("用户登录成功.....返回结果"+json.toString());
		return json.toString();
	}
		
}
