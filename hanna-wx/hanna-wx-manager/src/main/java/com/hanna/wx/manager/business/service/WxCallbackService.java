package com.hanna.wx.manager.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanna.wx.db.dao.WxCallbackDao;
import com.hanna.wx.db.model.WxMessageInfo;
import com.hanna.wx.db.model.WxUserInfo;

@Service
public class WxCallbackService {
	@Autowired
	private WxCallbackDao WxCallbackDao;
	/**
	 * 用户关注
	 * @param wm
	 */
	public void subscribe(WxMessageInfo wm){
		WxUserInfo wxUser = new WxUserInfo();
		WxCallbackDao.subscribe(wxUser);
	}
	
	/**
	 * 用户取消关注
	 * @param wm
	 */
	public void unsubscribe(WxMessageInfo wm){
		WxUserInfo wxUser = new WxUserInfo();
		WxCallbackDao.subscribe(wxUser);
	}
}
