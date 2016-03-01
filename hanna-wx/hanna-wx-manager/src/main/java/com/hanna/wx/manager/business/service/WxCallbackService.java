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
		WxUserInfo wxUser = wxUserDao.getWxUserByOpenid(wm.getFromUserName());
		if(wxUser == null){
			String access_token = AccessTokenDto.getAccess_token();
			String url = String.format( WxConsts.USER_QUERY_INFO_URL, access_token,wm.getFromUserName(),"zh_CN");
			wxUser = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), WxUserInfo.class,true);
			if(wxUser.getErrcode() == null){
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
}
