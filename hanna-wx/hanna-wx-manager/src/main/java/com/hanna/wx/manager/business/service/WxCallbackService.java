package com.hanna.wx.manager.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanna.wx.common.enums.WxConsts;
import com.hanna.wx.common.http.HttpClientUtils;
import com.hanna.wx.common.utils.GsonUtils;
import com.hanna.wx.db.dao.WxUserDao;
import com.hanna.wx.db.dto.AccessTokenDto;
import com.hanna.wx.db.dto.WxMessageDto;
import com.hanna.wx.db.model.WxUserInfo;

@Service
public class WxCallbackService {
	@Autowired
	private WxUserDao wxUserDao;
	/**
	 * 用户关注
	 * @param wm
	 */
	public void subscribe(WxMessageDto wm){
		WxUserInfo wxUserInfo = wxUserDao.getWxUserByOpenid(wm.getFromUserName());
		if(wxUserInfo == null){
			String access_token = AccessTokenDto.access_token;
			String url = String.format( WxConsts.USER_QUERY_INFO_URL, access_token,wm.getFromUserName(),"zh_CN");
			wxUserInfo = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), WxUserInfo.class,true);
			if(wxUserInfo.getErrcode() == null){
				wxUserDao.insertWxUser(wxUserInfo);
			}else{
				System.out.println(wxUserInfo.getErrmsg());
			}
		}else{
			wxUserInfo.setSubscribe("1");
			wxUserDao.subscribe(wxUserInfo);
		}
	}
	
	/**
	 * 用户取消关注
	 * @param wm
	 */
	public void unsubscribe(WxMessageDto wm){
		WxUserInfo wxUserInfo = wxUserDao.getWxUserByOpenid(wm.getFromUserName());
		if(wxUserInfo != null){
			wxUserInfo.setSubscribe("0");
			wxUserDao.subscribe(wxUserInfo);
		}
	}
}
