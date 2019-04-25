package cn.bingchuang.service;

import cn.bingchuang.pojo.Administrator;

public interface AdministratorService {
	//管理员注册
	public boolean addadministrator(Administrator administrator);
		
	//管理员登录
	public Administrator selectbyusernameandpassword(String administratorUsername, String administratorPassword);
}
