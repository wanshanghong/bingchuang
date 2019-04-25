package cn.bingchuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bingchuang.mapper.VibrationMapper;
import cn.bingchuang.pojo.Vibration;
import cn.bingchuang.service.VibrationService;

@Service
public class VibrationServiceImpl implements VibrationService{
	@Autowired
	private VibrationMapper vibrationMapper;
	
	//接收网络编程数据（震动）
	@Override
	public boolean insertvibration(Vibration vibration) {
		// TODO Auto-generated method stub
		return vibrationMapper.insertvibration(vibration);
	}
	
	//查找病人全部震动信息(byId)
	@Override
	public List<Vibration> selectallvibrationbyId(Integer patientId) {
		// TODO Auto-generated method stub
		return vibrationMapper.selectallvibrationbyId(patientId);
	}
	
	//查询最新的一条震动信息(byId)
	@Override
	public Vibration selectOnevibrationbyId(Integer patientId) {
		// TODO Auto-generated method stub
		return vibrationMapper.selectOnevibrationbyId(patientId);
	}
	
}
