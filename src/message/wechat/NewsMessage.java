package message.wechat;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="xml")
public class NewsMessage {
	private String ToUserName;
	private String fromUserName;
	private Long CreateTime;
	private String MsgType;
	private int AriticleCount;
	private List<News> articles;
	@XmlElementWrapper(name="Articles")
	@XmlElement(name="item")
	public List<News> getArticles() {
		return articles;
	}
	public void setArticles(List<News> articles) {
		this.articles = articles;
	}
	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	@XmlElement(name="FromUserName")
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	@XmlElement(name="CreateTime")
	public Long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
	@XmlElement(name="MsgType")
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	@XmlElement(name="ArticleCount")
	public int getAriticleCount() {
		return AriticleCount;
	}
	public void setAriticleCount(int ariticleCount) {
		AriticleCount = ariticleCount;
	}
	
	

}
