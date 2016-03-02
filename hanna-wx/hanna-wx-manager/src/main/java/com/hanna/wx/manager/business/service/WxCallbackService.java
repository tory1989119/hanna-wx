package com.hanna.wx.manager.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanna.wx.common.enums.MsgTypeEnum;
import com.hanna.wx.common.enums.WxConsts;
import com.hanna.wx.common.http.HttpClientUtils;
import com.hanna.wx.common.utils.GsonUtils;
import com.hanna.wx.db.dao.WxUserDao;
import com.hanna.wx.db.dto.AccessTokenDto;
import com.hanna.wx.db.dto.WxMessageDto;
import com.hanna.wx.db.model.WxUserInfo;
import com.thoughtworks.xstream.XStream;

@Service
public class WxCallbackService {
	@Autowired
	private WxUserDao wxUserDao;
	/**
	 * 用户关注
	 * @param wm
	 */
	public void subscribe(WxMessageDto wm){
		WxUserInfo wxUser = wxUserDao.getWxUserByOpenid(wm.getFromUserName());
		if(wxUser == null){
			String access_token = AccessTokenDto.getAccess_token();
			String url = String.format( WxConsts.USER_QUERY_INFO_URL, access_token,wm.getFromUserName(),"zh_CN");
			wxUser = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), WxUserInfo.class,true);
			if(wxUser.getErrcode() == null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String date = sdf.format(new Date(wxUser.getSubscribe_time()*1000));
				wxUser.setSubscribeTime(date);
				wxUserDao.insertWxUser(wxUser);
			}else{
				System.out.println(wxUser.getErrmsg());
			}
		}else{
			wxUser.setSubscribe("1");
			wxUserDao.subscribe(wxUser);
		}
	}
	
	/**
	 * 用户取消关注
	 * @param wm
	 */
	public void unsubscribe(WxMessageDto wm){
		WxUserInfo wxUser = wxUserDao.getWxUserByOpenid(wm.getFromUserName());
		if(wxUser != null){
			wxUser.setSubscribe("0");
			wxUserDao.subscribe(wxUser);
		}
	}
	
	/**
	 * 移交客服
	 * @param wm
	 * @return
	 */
	private String toKf(WxMessageDto wm){
		XStream xStream = new XStream();
		xStream.alias("xml", WxMessageDto.class);
		WxMessageDto wm1 = new WxMessageDto();
		wm1.setMsgType(WxConsts.DKF_TYPE);
		wm1.setToUserName(wm.getFromUserName());
		wm1.setFromUserName(wm.getToUserName());
		wm1.setCreateTime(wm.getCreateTime());
		return xStream.toXML(wm1);
	}
	
	/**
	 * 处理点击事件
	 * @param wm
	 * @return
	 */
	public String click(WxMessageDto wm){
		if("kefu1234".endsWith(wm.getEventKey())){
			XStream xStream = new XStream();
			xStream.alias("xml", WxMessageDto.class);
			WxMessageDto wm1 = new WxMessageDto();
			wm1.setMsgType(MsgTypeEnum.TEXT.getType());
			wm1.setToUserName(wm.getFromUserName());
			wm1.setFromUserName(wm.getToUserName());
			wm1.setCreateTime(wm.getCreateTime());
			wm1.setContent("请输入你要咨询的问题，稍后会有客服与你联系，谢谢！");
			return xStream.toXML(wm1);
		}
		return "";
	}
	
	/**
	 * 处理文本消息
	 * @param wm
	 * @return
	 */
	public String text(WxMessageDto wm){
		return toKf(wm);
	}
	
	/**
	 * 处理图片消息
	 * @param wm
	 * @return
	 */
	public String image(WxMessageDto wm){
		return toKf(wm);
	}
	
	/**
	 * 处理语音消息
	 * @param wm
	 * @return
	 */
	public String voice(WxMessageDto wm){
		return toKf(wm);
	}
	
	/**
	 * 处理小视频
	 * @param wm
	 * @return
	 */
	public String shortvideo(WxMessageDto wm){
		return toKf(wm);
	}
}
