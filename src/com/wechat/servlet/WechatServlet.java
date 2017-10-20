
package com.wechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.dom4j.DocumentException;



import util.wechat.ChangeXml;



@SuppressWarnings("serial")
public class WechatServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws 

ServletException, IOException {
		
		 boolean isGet = request.getMethod().toLowerCase().equals("get");
	  
		 PrintWriter print;
	        if (isGet) {
	            // 微信加密签名
	            String signature = request.getParameter("signature");
	            // 时间戳
	            String timestamp = request.getParameter("timestamp");
	            // 随机数
	            String nonce = request.getParameter("nonce");
	            // 随机字符串
	            String echostr = request.getParameter("echostr");
	            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
	            if (signature != null && CheckoutUtil.checkSignature(signature, timestamp, nonce)) {
	                try {
	                    print = resp.getWriter();
	                    print.write(echostr);
	                    print.flush();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	    }	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws 

ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out=resp.getWriter();
	
		try {
			Map<String, String> map=ChangeXml.toMap(req);
			String fromusername=map.get("FromUserName");
			String tousername=map.get("ToUserName");
			String content=map.get("Content");
			String msgtype=map.get("MsgType");
			
			String message=null;
			if(ChangeXml.MESSAGE_TEXT.equals(msgtype)){
				
				if ("1".equals(content)) {
					message=ChangeXml.initText(tousername, fromusername, ChangeXml.firstMenu());
					
				}else if ("2".equals(content)) {
					message=ChangeXml.initPictureMessage(tousername, fromusername);
				}else if ("?".equals(content)||"？".equals(content)){
					message=ChangeXml.initText(tousername, fromusername, ChangeXml.threeMenu());
				}else {
					message=ChangeXml.initText(tousername, fromusername,"看不懂\n"+ChangeXml.menuMessage());
				}
			
		
			}
			else if (ChangeXml.MESSAGE_EVENT.equals(msgtype)) {
				String eventType=map.get("Event");
				if (ChangeXml.MESSAGE_SUBSCRIBE.equals(eventType)) {
					message=ChangeXml.initText(tousername, fromusername, ChangeXml.menuMessage());
				}else if(ChangeXml.MESSAGE_CLICK.equals(eventType)){
					
				}else if(ChangeXml.MESSAGE_VIEW.equals(eventType)){
					
				}
				
			}
			System.out.println(message);
			out.print(message);
			
		} catch (DocumentException e) {
		
			e.printStackTrace();
		} catch (JAXBException e) {
			
			e.printStackTrace();
		} 
		finally {
			out.close();
			
		}
	
	}

}
