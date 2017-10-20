package message.wechat;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
public class TextMessage {

	private String ToUserName;
	
	private String FromUserName;

	private long CreateTime;

	private String MsgType;

	private String Content;

	private String MsgId;
	@javax.xml.bind.annotation.XmlElement(name="ToUserName")
	public String getToUserName() {
		return ToUserName;
	}
	
	public void setToUserName(String ToUserName) {
		this.ToUserName = ToUserName;
	}
	@javax.xml.bind.annotation.XmlElement(name="FromUserName")
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String FromUserName) {
		this.FromUserName = FromUserName;
	}
	@javax.xml.bind.annotation.XmlElement(name="CreateTime")
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long CreateTime) {
		this.CreateTime = CreateTime;
	}
	@javax.xml.bind.annotation.XmlElement(name="MsgType")
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String MsgType) {
		this.MsgType = MsgType;
	}
	@javax.xml.bind.annotation.XmlElement(name="Content")
	public String getContent() {
		return Content;
	}
	public void setContent(String Content) {
		this.Content = Content;
	}
	@javax.xml.bind.annotation.XmlElement(name="MsgId")
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String MsgId) {
		this.MsgId = MsgId;
	}
	

}
