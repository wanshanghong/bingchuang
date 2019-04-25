package cn.bingchuang.service;

import cn.bingchuang.pojo.User;

public interface UserService {

	//用户注册
	public boolean AddUser(User user);
		
	//用户登录
	public User loginUser(String userName, String userPassword);
}
