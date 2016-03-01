package com.hanna.wx.manager.business.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hanna.wx.common.enums.ErrorCode;
import com.hanna.wx.common.enums.WxConsts;
import com.hanna.wx.common.http.HttpClientUtils;
import com.hanna.wx.common.utils.GsonUtils;
import com.hanna.wx.db.dao.WxUserDao;
import com.hanna.wx.db.dto.AccessTokenDto;
import com.hanna.wx.db.dto.BaseResponseDto;
import com.hanna.wx.db.dto.SysSearchDto;
import com.hanna.wx.db.model.WxUserInfo;

@Service
public class WxUserService {
	@Autowired
	private WxUserDao wxUserDao;

	/**
	 * 根据ID获取微信用户信息
	 * 
	 * @param id
	 * @return
	 */
	public WxUserInfo getWxUserById(String id) {
		return wxUserDao.getWxUserById(id);
	}

	/**
	 * 查询微信用户列表
	 * 
	 * @param searchDto
	 * @return
	 */
	public BaseResponseDto<Object> queryWxUser(SysSearchDto searchDto) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		br.setContent(wxUserDao.queryWxUser(searchDto));
		br.setPageCount(wxUserDao.countWxUser(searchDto));
		return br;
	}
	
	/**
	 * 同步微信用户数据
	 */
	public BaseResponseDto<Object> syncWxUser(){
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		String access_token = AccessTokenDto.getAccess_token();
		String next_openid = "";
		String url = String.format( WxConsts.USER_QUERY_ALL_URL, access_token, next_openid);
		boolean flag = true;
		wxUserDao.truncateWxUser();//清空微信用户表
		while (flag) {
			JsonObject jb = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), JsonObject.class,true);
			if(jb.get("errcode") == null){
				if(jb.get("count").getAsInt() > 0){
					JsonArray ja = jb.get("data").getAsJsonObject().get("openid").getAsJsonArray();
					br = syncInsertWxUser(access_token, ja);
					if(!br.getErrorCode().equals(ErrorCode.sucessed.getCode())){
						flag = false;
					}else{
						next_openid = jb.get("next_openid").getAsString();
						url = String.format( WxConsts.USER_QUERY_ALL_URL, access_token, next_openid);
					}
				}else{
					flag = false;
				}
			}else{
				br.setErrorCode(ErrorCode.wx_error.getCode());
				br.setContent(jb.get("errcode").getAsString() + "--" + jb.get("errmsg").getAsString());
				flag = false;
			}
		}
		return br;
	}
	
	/**
	 * 同步插入数据
	 * @param access_token
	 * @param ja
	 */
	private BaseResponseDto<Object> syncInsertWxUser(String access_token,JsonArray ja){
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		for (int i = 0; i < ja.size(); i++) {
			String openid = ja.get(i).getAsString();
			String url = String.format( WxConsts.USER_QUERY_INFO_URL, access_token,openid,"zh_CN");
			WxUserInfo wxUserInfo = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), WxUserInfo.class,true);
			if(wxUserInfo.getErrcode() == null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String date = sdf.format(new Date(wxUserInfo.getSubscribe_time()*1000));
				wxUserInfo.setSubscribeTime(date);
				wxUserDao.insertWxUser(wxUserInfo);
			}else{
				br.setErrorCode(ErrorCode.wx_error.getCode());
				br.setContent(wxUserInfo.getErrcode() + "--" + wxUserInfo.getErrmsg());
				break;
			}
		}
		return br;
	}
}
