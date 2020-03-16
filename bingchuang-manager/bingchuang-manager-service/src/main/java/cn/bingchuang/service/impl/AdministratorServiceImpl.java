package cn.bingchuang.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bingchuang.mapper.AdministratorMapper;
import cn.bingchuang.pojo.Administrator;
import cn.bingchuang.service.AdministratorService;

//管理员模块的Service层实现类
@Service
public class AdministratorServiceImpl implements AdministratorService {
	
	@Autowired
	private AdministratorMapper administratorMapper;
	
	//管理员注册
	@Override
	public boolean addadministrator(Administrator administrator) {
		// TODO Auto-generated method stub
		return administratorMapper.addadministrator(administrator);
	}

	//管理员登录
	@Override
	public Administrator selectbyusernameandpassword(String administratorUsername, String administratorPassword) {
		// TODO Auto-generated method stub
		
		Map<String,String> map = new HashMap<String, String>();		
		map.put("administratorUsername",administratorUsername);		
		map.put("administratorPassword", administratorPassword);	
		return administratorMapper.selectbyusernameandpassword(map);
	}

}
