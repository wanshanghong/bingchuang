package cn.bingchuang.mapper;

import java.util.Map;

import cn.bingchuang.pojo.User;

public interface UserMapper {

	//用户注册
	public boolean AddUser(User user);
		
	//用户登录
	public User loginUser(Map<String, String> map);
	
}
