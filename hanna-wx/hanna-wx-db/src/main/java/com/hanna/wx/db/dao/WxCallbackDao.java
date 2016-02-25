package com.hanna.wx.db.dao;

import com.hanna.wx.db.model.WxInMessage;

public interface WxCallbackDao {
	/**
	 * 用户关注
	 * @param wm
	 */
	public void subscribe(WxInMessage wm);
	
	/**
	 * 用户取消关注
	 * @param wm
	 */
	public void unsubscribe(WxInMessage wm);
}
