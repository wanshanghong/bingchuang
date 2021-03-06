package cn.bingchuang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bingchuang.mapper.ChattingMapper;
import cn.bingchuang.pojo.Chatting;

//通知模块的Service层实现类
@Service
public class ChattingServiceImpl implements cn.bingchuang.service.ChattingService {
	
	@Autowired
	private ChattingMapper chattingMapper;
	
	//发送信息(sender_id,send_message,send_date,receiver_id)
	@Override
	public boolean sendMassage(Chatting chatting) {
		// TODO Auto-generated method stub
		return chattingMapper.sendMassage(chatting);
	}

	//查询自己相关的消息
	@Override
	public List<Chatting> selectMassage(Integer id) {
		// TODO Auto-generated method stub
		return chattingMapper.selectMassage(id);
	}
	
	//查询护士未读通知
	@Override
	public List<Chatting> findnotification(String senderId, String receiverId){
		Map<String,String> map = new HashMap<String, String>();		
		map.put("senderId",senderId);		
		map.put("receiverId", receiverId);	
		List<Integer> chattingId=chattingMapper.findnotificationstep1(map);
		
		System.out.println("chattingId="+chattingId.size()+"  "+chattingId);
		if(chattingId.size()>0){
			List<Chatting> chattings=chattingMapper.findnotificationstep2(chattingId);
			int  len=chattingMapper.findnotificationstep3(chattingId);
			return chattings;
		}else{
			return null;
		}
	}

	// 查询护士的通知信息(不排除已读）
	@Override
	public List<Chatting> findnotificationignoreread(String senderId, String receiverId) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String, String>();		
		map.put("senderId",senderId);		
		map.put("receiverId", receiverId);	
		return chattingMapper.findnotificationignoreread(map);
	}
}
