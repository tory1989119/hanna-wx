package com.hanna.wx.manager.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanna.wx.db.dao.WxCallbackDao;
import com.hanna.wx.db.model.WxMessageInfo;

@Service
public class WxCallbackService {
	@Autowired
	private WxCallbackDao WxCallbackDao;
	/**
	 * 用户关注
	 * @param wm
	 */
	public void subscribe(WxMessageInfo wm){
		WxCallbackDao.subscribe(wm);
	}
	
	/**
	 * 用户取消关注
	 * @param wm
	 */
	public void unsubscribe(WxMessageInfo wm){
		WxCallbackDao.unsubscribe(wm);
	}
}
