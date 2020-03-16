package cn.bingchuang.service;

import java.util.List;

import cn.bingchuang.pojo.Chatting;

//通知模块的Service层的接口
public interface ChattingService {
	
	//发送信息(sender_id,send_message,send_date,receiver_id)
	public boolean sendMassage(Chatting chatting);
		
	//查询自己相关的消息
	public List<Chatting> selectMassage(Integer id);
	
	// 查询护士的通知信息(不排除已读）
	public List<Chatting> findnotificationignoreread(String senderId, String receiverId);
	
	//查询护士未读通知
	public List<Chatting> findnotification(String senderId, String receiverId);
}
