package com.hanna.wx.db.dao;

import com.hanna.wx.db.model.WxMessageInfo;
import com.hanna.wx.db.model.WxUserInfo;

public interface WxCallbackDao {
	/**
	 * 插入微信用户
	 * @param wxUser
	 */
	public void insertWxUser(WxUserInfo wxUser);
	/**
	 * 修改关注状态
	 * @param wm
	 */
	public void subscribe(WxUserInfo wxUser);
}
