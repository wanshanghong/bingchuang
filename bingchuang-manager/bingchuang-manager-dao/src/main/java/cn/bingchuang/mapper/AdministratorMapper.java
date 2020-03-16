package cn.bingchuang.mapper;

import java.util.Map;

import cn.bingchuang.pojo.Administrator;


//管理员模块的Dao层
public interface AdministratorMapper {
	//管理员注册
	public boolean addadministrator(Administrator administrator);
	
	//管理员登录
	public Administrator selectbyusernameandpassword(Map<String, String> map);
}
