package com.hanna.wx.db.dao;

import java.util.List;

import com.hanna.wx.db.dto.SysSearchDto;
import com.hanna.wx.db.model.WxUserInfo;

public interface WxMenuDao {

	/**
	 * 插入微信用户
	 * 
	 * @param wxUser
	 */
	public void insertWxUser(WxUserInfo wxUser);

	/**
	 * 修改关注状态
	 * 
	 * @param wm
	 */
	public void subscribe(WxUserInfo wxUser);
	
	/**
	 * 根据OPENID获取微信用户信息
	 * 
	 * @param openid
	 * @return
	 */
	public WxUserInfo getWxUserInfoByOpenid(String openid);

	/**
	 * 根据ID获取微信用户信息
	 * 
	 * @param id
	 * @return
	 */
	public WxUserInfo getWxUserInfoById(String id);

	/**
	 * 查询微信用户列表
	 * 
	 * @param searchDto
	 * @return
	 */
	public List<WxUserInfo> queryWxUser(SysSearchDto searchDto);

	/**
	 * 查询微信用户列表数
	 * 
	 * @param searchDto
	 * @return
	 */
	public int countWxUser(SysSearchDto searchDto);
}
