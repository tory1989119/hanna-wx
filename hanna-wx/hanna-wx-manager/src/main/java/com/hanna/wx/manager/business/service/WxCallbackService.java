package com.hanna.wx.manager.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanna.wx.db.dao.WxCallbackDao;
import com.hanna.wx.db.model.WxInMessage;

@Service
public class WxCallbackService {
	@Autowired
	private WxCallbackDao WxCallbackDao;
	/**
	 * 用户关注
	 * @param wm
	 */
	public void subscribe(WxInMessage wm){
		WxCallbackDao.subscribe(wm);
	}
	
	/**
	 * 用户取消关注
	 * @param wm
	 */
	public void unsubscribe(WxInMessage wm){
		WxCallbackDao.unsubscribe(wm);
	}
}
