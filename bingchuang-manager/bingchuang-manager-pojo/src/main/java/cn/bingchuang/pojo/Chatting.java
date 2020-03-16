package cn.bingchuang.pojo;

import java.util.Date;

//通知的javabean
public class Chatting {
	private int senderId;    //发送者id
	private String senderName;    //发送者名字
	private String sendMessage;		//发送信息
	private Date sendDate;		//发送时间
	private int receiverId;	//接收人id
	private String receiverName;	//接收人信息
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSendMessage() {
		return sendMessage;
	}
	public void setSendMessage(String sendMessage) {
		this.sendMessage = sendMessage;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	@Override
	public String toString() {
		return "Chatting [senderId=" + senderId + ", senderName=" + senderName + ", sendMessage=" + sendMessage
				+ ", sendDate=" + sendDate + ", receiverId=" + receiverId + ", receiverName=" + receiverName + "]";
	}
	
}
