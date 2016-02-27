package com.hanna.wx.manager.business.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.hanna.wx.common.enums.WxConsts;
import com.hanna.wx.common.http.HttpClientUtils;
import com.hanna.wx.common.utils.GsonUtils;
import com.hanna.wx.db.dao.WxUserDao;
import com.hanna.wx.db.dto.AccessTokenDto;
import com.hanna.wx.db.dto.BaseResponseDto;
import com.hanna.wx.db.dto.SysSearchDto;
import com.hanna.wx.db.model.WxUserInfo;

@Service
public class WxUserManagerService {
	@Autowired
	private WxUserDao wxUserManagerDao;

	/**
	 * 根据ID获取微信用户信息
	 * 
	 * @param id
	 * @return
	 */
	public WxUserInfo getWxUserById(String id) {
		return wxUserManagerDao.getWxUserById(id);
	}

	/**
	 * 查询微信用户列表
	 * 
	 * @param searchDto
	 * @return
	 */
	public BaseResponseDto<Object> queryWxUser(SysSearchDto searchDto) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		br.setContent(wxUserManagerDao.queryWxUser(searchDto));
		br.setPageCount(wxUserManagerDao.countWxUser(searchDto));
		return br;
	}
	
	public void syncWxUser(){
		String access_token = AccessTokenDto.access_token;
		String url = String.format( WxConsts.USER_QUERY_ALL_URL, access_token, "");
		GsonUtils.fromJson(HttpClientUtils.get(url), JsonObject.class);
		//HttpClientUtils.get(url)
	}
}
