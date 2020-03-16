package cn.bingchuang.service;

import cn.bingchuang.pojo.Administrator;

//管理员模块的Service层接口
public interface AdministratorService {
	//管理员注册
	public boolean addadministrator(Administrator administrator);
		
	//管理员登录
	public Administrator selectbyusernameandpassword(String administratorUsername, String administratorPassword);
}
