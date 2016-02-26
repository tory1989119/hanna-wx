package com.hanna.wx.db.dao;

import java.util.List;

import com.hanna.wx.db.dto.SysSearchDto;
import com.hanna.wx.db.model.WxUserInfo;

public interface WxUserManagerDao {
	/**
	 * 根据ID获取微信用户信息
	 * @param id
	 * @return
	 */
	public WxUserInfo getWxUserInfoById(String id);

	/**
	 * 查询微信用户列表
	 * @param searchDto
	 * @return
	 */
	public List<WxUserInfo> queryWxUser(SysSearchDto searchDto);

	/**
	 * 查询微信用户列表数
	 * @param searchDto
	 * @return
	 */
	public int countWxUser(SysSearchDto searchDto);
}
