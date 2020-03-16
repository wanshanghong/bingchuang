package cn.bingchuang.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bingchuang.mapper.UserMapper;
import cn.bingchuang.pojo.User;
import cn.bingchuang.service.UserService;

//用户User模块的Service层实现类
@Service
public class UserServiceImpl implements UserService{
	//注解   获取UserMapper
	@Autowired
	private UserMapper userMapper;
	
	//用户注册
	@Override
	public boolean AddUser(User user){
		// TODO Auto-generated method stub
		return userMapper.AddUser(user);
	}
		
	//用户登录
	@Override
	public User loginUser(String userName, String userPassword)
	{
		// TODO Auto-generated method stub
		//将数据封装成为一个map
		Map<String,String> map = new HashMap<String, String>();		
		map.put("userName",userName);		
		map.put("userPassword", userPassword);	
		return userMapper.loginUser(map);
	}
	
	
}
