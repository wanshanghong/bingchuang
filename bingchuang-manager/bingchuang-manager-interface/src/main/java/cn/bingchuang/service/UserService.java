package cn.bingchuang.service;

import cn.bingchuang.pojo.User;

//用户User模块的Service层接口
public interface UserService {

	//用户注册
	public boolean AddUser(User user);
		
	//用户登录
	public User loginUser(String userName, String userPassword);
}
