package cn.bingchuang.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bingchuang.pojo.Chatting;
import cn.bingchuang.service.ChattingService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class ChattingController {
	@Autowired
	private ChattingService chattingService;
	
	//发送信息(sender_id,send_message,send_date,receiver_id)
	@RequestMapping("sendmassage.action")
	@ResponseBody
	public String sendMassage(@RequestParam( value = "senderId", required = false) Integer senderId,
			@RequestParam(value = "sendMessage", required = false) String sendMessage,
			@RequestParam(value = "receiverId", required = false) Integer receiverId)
	{
		System.out.println("发送信息功能开始： 请求信息：senderId："+(senderId.intValue())+"  sendMessage="+sendMessage+"   receiverId="+receiverId.intValue());
		Chatting chatting=new Chatting();
		Date date=new Date();
		chatting.setReceiverId(receiverId);
		chatting.setSendMessage(sendMessage);
		chatting.setSendDate(date);
		chatting.setSenderId(senderId);
		boolean send=chattingService.sendMassage(chatting);
		JSONObject json =new JSONObject();
		json.put("send", send);
		System.out.println("发送信息功能结束........返回内容："+json.toString());
		return json.toString();
	}
	
	//查询自己相关的消息
	@RequestMapping("selectmassage.action")
	@ResponseBody
	public String selectMassage(@RequestParam( value = "id", required = false) Integer id)
	{
		System.out.println("查询自己相关的消息(byId)： 请求信息：id="+id);
		if(id==null){
			id=32501;
		}
		System.out.println("patientId="+id.intValue());
		List<Chatting> lists=chattingService.selectMassage(id);
		JSONArray json =JSONArray.fromObject(lists);
		System.out.println("查询自己相关的消息(byId)结束........返回内容："+json.toString());
		return json.toString();
	}	
	
	//查询护士未读通知
	@RequestMapping("findnotification.action")
	@ResponseBody
	public String FindNotification(@RequestParam( value = "senderId", required = false) String senderId,
		@RequestParam( value = "receiverId", required = false) String receiverId){
		System.out.println("查询护士未读通知： 请求信息：senderId="+senderId+"   receiverId="+receiverId);
		List<Chatting> lists=chattingService.findnotification(senderId,receiverId);
		JSONArray json =JSONArray.fromObject(lists);
		System.out.println("查询护士未读通知结束........返回内容："+json.toString());
		return json.toString();
	}
}
