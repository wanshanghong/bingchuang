package cn.bingchuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bingchuang.mapper.PressureMapper;
import cn.bingchuang.pojo.Pressure;
import cn.bingchuang.service.PressureService;

@Service
public class PressureServiceImpl implements PressureService{
	
	@Autowired
	private PressureMapper pressureMapper;
	
	//接收网络编程数据（压力）
	@Override
	public boolean insertpressure(Pressure pressure) {
		// TODO Auto-generated method stub
		return pressureMapper.insertpressure(pressure);
	}
		
	//查找病人全部压力信息(byId)
	@Override
	public List<Pressure> selectallpressurebyId(Integer patientId) {
		// TODO Auto-generated method stub
		return pressureMapper.selectallpressurebyId(patientId);
	}
	
	//查询最新的一条压力信息(byId)
	@Override
	public Pressure selectOnepressurebyId(Integer patientId) {
		// TODO Auto-generated method stub
		return pressureMapper.selectOnepressurebyId(patientId);
	}
}
