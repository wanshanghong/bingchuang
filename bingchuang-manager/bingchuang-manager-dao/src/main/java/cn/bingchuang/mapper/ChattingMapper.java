package cn.bingchuang.mapper;

import java.util.List;
import java.util.Map;

import cn.bingchuang.pojo.Chatting;

public interface ChattingMapper {
	//发送信息(sender_id,send_message,send_date,receiver_id)
	public boolean sendMassage(Chatting chatting);
	
	//查询自己相关的消息
	public List<Chatting> selectMassage(Integer id);
	
	//查询护士未读通知步骤1
	public List<Integer> findnotificationstep1(Map<String, String> map);
	
	//查询护士未读通知步骤2
	public List<Chatting> findnotificationstep2(List<Integer> chattingId);
	
	//查询护士未读通知步骤3
	public int findnotificationstep3(List<Integer> chattingId);
	
}
