package util.wechat;


import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import message.wechat.News;
import message.wechat.NewsMessage;
import message.wechat.TextMessage;





public class ChangeXml {
	public static final String MESSAGE_TEXT="text";
	public static final String MESSAGE_VIDEO="video";
	public static final String MESSAGE_IMAGE="image";
	public static final String MESSAGE_LINK="link";
	public static final String MESSAGE_VOICE="voice";
	public static final String MESSAGE_LOCATION="location";
	public static final String MESSAGE_SUBSCRIBE="subscribe";
	public static final String MESSAGE_VIEW="view";
	public static final String MESSAGE_CLICK="click";
	public static final String MESSAGE_UNSUBSCRIBE="unsubscribe";
	public static final String MESSAGE_EVENT="event";
	public static final String MESSAGE_SCANCODE="scancode_push";
	public static final String MESSAGE_MUSIC="music";
	public static final String MESSAGE_NEWS="news";
	
	public static Map<String, String>  toMap(HttpServletRequest request) throws 

IOException, DocumentException {
		Map<String, String> map=new HashMap<String, String>();
		InputStream inputStream=request.getInputStream();
		SAXReader saxreader=new SAXReader();
		Document document=saxreader.read(inputStream);
		Element root=document.getRootElement();
		List<Element> list =root.elements();
		for(Element e:list){
			map.put(e.getName(), e.getText());
			
		}
		inputStream.close();
		return map; 
	}
	
	public static String objectMessageToXml(JAXBContext jaxbContext,Object object) throws JAXBException{
		 
		 Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		 StringWriter sw=new StringWriter();
		 jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
		 jaxbMarshaller.marshal(object,sw);
		
		 Document document=null;
		try {
			document=DocumentHelper.parseText(sw.toString());
			
		} catch (DocumentException e) {
		
			e.printStackTrace();
		}
		String s=document.getRootElement().asXML().toString();
		return s;		
		 
	}
	public static String initPictureMessage(String touserbame, String fromusername) throws JAXBException{
		NewsMessage newsMessage=new NewsMessage();
		ArrayList<News> articles=new ArrayList<News>();
		News news=new News();
		news.setDescription("这是我的照");
		news.setTitle("我的介绍");
		news.setPicUrl("http://zhouquanwei74110.55555.io/WeChat/image/5.png");
		news.setUrl("www.baidu.com");
		articles.add(news);
		
		newsMessage.setFromUserName(touserbame);
		newsMessage.setToUserName(fromusername);
		newsMessage.setAriticleCount(articles.size());
		newsMessage.setArticles(articles);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		JAXBContext jaxbContext=JAXBContext.newInstance(newsMessage.getClass());
		return objectMessageToXml(jaxbContext,newsMessage);
		
	}
	


	public static String initText(String touserbame, String fromusername, String content) throws JAXBException{
		TextMessage text = new TextMessage();
		text.setFromUserName(touserbame);
		text.setToUserName(fromusername);
		text.setMsgType("text");
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		text.setMsgId("12");
		JAXBContext jaxbContext=JAXBContext.newInstance(text.getClass());
		return objectMessageToXml(jaxbContext,text);
}
	public static String menuMessage(){
		StringBuffer sb=new StringBuffer();
		sb.append("欢迎您的关注，请按照菜单提示进行操作：\n\n");
		sb.append("1、课程介绍\n");
		sb.append("2、周权威介绍\n");
		sb.append("3、词组翻译\n\n");
		sb.append("回复？调出此菜单。");
		return sb.toString();
		
	}
	
	public static String firstMenu(){
		StringBuffer sb=new StringBuffer();
		sb.append("这是周权威的一个小作品");
		return sb.toString();
		
	}
	public static String secondMenu(){
		StringBuffer sb=new StringBuffer();
		sb.append("周权威是一个谜一样的男人！！！哈哈哈");
		return sb.toString();
		
	}
	public static String threeMenu(){
		StringBuffer sb=new StringBuffer();
		sb.append("词组翻译使用指南\n\n");
		sb.append("使用示例：\n");
		sb.append("翻译足球\n");
		sb.append("翻译中国足球\n");
		sb.append("翻译football\n\n");
		sb.append("回复？显示主菜单。");
		return sb.toString();
	}



		
	}
	

	
