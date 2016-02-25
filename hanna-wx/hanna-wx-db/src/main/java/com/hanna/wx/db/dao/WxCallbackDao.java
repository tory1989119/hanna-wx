package com.hanna.wx.db.dao;

import com.hanna.wx.db.model.WxMessageInfo;

public interface WxCallbackDao {
	/**
	 * 用户关注
	 * @param wm
	 */
	public void subscribe(WxMessageInfo wm);
	
	/**
	 * 用户取消关注
	 * @param wm
	 */
	public void unsubscribe(WxMessageInfo wm);
}
