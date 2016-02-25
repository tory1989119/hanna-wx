package com.hanna.wx.manager.business.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanna.wx.manager.business.service.WxCallbackService;
import com.hanna.wx.common.enums.EventEnum;
import com.hanna.wx.common.enums.MsgTypeEnum;
import com.hanna.wx.db.model.WxMessageInfo;
import com.hanna.wx.common.utils.Configuration;
import com.hanna.wx.common.utils.ParseMessageXml;
import com.hanna.wx.common.utils.SHA1;

@Controller
@RequestMapping("/data")
public class WxCallbackController {
	
	@Autowired
	private WxCallbackService wxCallbackService;
	/**
	 * 微信验证
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/callback.do", method = RequestMethod.GET)  
    @ResponseBody
	public String importGet(HttpServletRequest request, HttpServletResponse response, Model model) {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		
		String token = Configuration.getGlobalMsg("token");
		String s = "";
		try {
			s = SHA1.gen(nonce,token,timestamp);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(signature.equals(s)){
			String echostr = request.getParameter("echostr");
			return echostr;
		}else{
			return "error";
		}
		
		
	}
	
	/**
	 * 微信时间回调
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "/callback.do", method = RequestMethod.POST)  
    @ResponseBody
	public void importPost(HttpServletRequest request, HttpServletResponse response, Model model) {
		WxMessageInfo wm = null;
		try {
			wm = ParseMessageXml.format2Object(request.getInputStream());
			
			if(wm.getMsgType().equals(MsgTypeEnum.TEXT.getType())){
				System.out.println("获取到文本消息");
			}else if(wm.getMsgType().equals(MsgTypeEnum.IMAGE.getType())){
				System.out.println("获取到图片消息");
			}else if(wm.getMsgType().equals(MsgTypeEnum.EVENT.getType())){
				if(wm.getEvent().equals(EventEnum.CLICK.getType())){
					System.out.println("点击菜单拉取消息时的事件推送");
				}else if(wm.getEvent().equals(EventEnum.LOCATION.getType())){
					System.out.println("上报地理位置事件");
				}else if(wm.getEvent().equals(EventEnum.SCAN.getType())){
					System.out.println("扫描二维码，用户已关注时的事件推送");
				}else if(wm.getEvent().equals(EventEnum.SUBSCRIBE.getType())){
					//关注事件
					wxCallbackService.subscribe(wm);
				}else if(wm.getEvent().equals(EventEnum.UNSUBSCRIBE.getType())){
					//取消关注事件
					wxCallbackService.unsubscribe(wm);
				}else if(wm.getEvent().equals(EventEnum.VIEW.getType())){
					System.out.println("点击菜单跳转链接时的事件推送 ");
				}
			}else if(wm.getMsgType().equals(MsgTypeEnum.LINK.getType())){
				System.out.println("获取到链接消息");
			}else if(wm.getMsgType().equals(MsgTypeEnum.LOCATION.getType())){
				System.out.println("获取到地址消息");
			}else if(wm.getMsgType().equals(MsgTypeEnum.VIDEO.getType())){
				System.out.println("获取到视频消息");
			}else if(wm.getMsgType().equals(MsgTypeEnum.VOICE.getType())){
				System.out.println("获取到语音消息");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
