package com.hanna.wx.manager.business.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hanna.wx.common.enums.ErrorCode;
import com.hanna.wx.common.enums.GlobConstants;
import com.hanna.wx.common.enums.WxConsts;
import com.hanna.wx.common.http.HttpClientUtils;
import com.hanna.wx.common.utils.GsonUtils;
import com.hanna.wx.db.dao.WxGroupDao;
import com.hanna.wx.db.dto.AccessTokenDto;
import com.hanna.wx.db.dto.BaseResponseDto;
import com.hanna.wx.db.dto.SysSearchDto;
import com.hanna.wx.db.model.WxGroupInfo;

@Service
public class WxGroupService {
	@Autowired
	private WxGroupDao wxGroupDao;
	
	/**
	 *新增用户组
	 * 
	 * @param searchDto
	 * @return
	 */
	public BaseResponseDto<Object> insertWxGroup(WxGroupInfo wxGroupInfo) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.USER_GROUP_ADD_URL, access_token);
		JsonObject jb = GsonUtils.fromJson(HttpClientUtils.post(url, "{\"group\":{\"name\":\"" + wxGroupInfo.getName() + "\"}}", "UTF-8"), JsonObject.class,true);
		if(jb.get("errcode") == null){
			wxGroupInfo.setGroupId(jb.get("group").getAsJsonObject().get("id").getAsLong());
			wxGroupInfo.setCount(0);
			wxGroupDao.insertWxGroup(wxGroupInfo);
		}else{
			br.setErrorCode(ErrorCode.wx_error.getCode());
			br.setContent(jb.get("errcode").getAsString() + "--" + jb.get("errmsg").getAsString());
		}
		
		return br;
	}

	/**
	 * 查询微信用户组列表
	 * 
	 * @param searchDto
	 * @return
	 */
	public BaseResponseDto<Object> queryWxGroup(SysSearchDto searchDto) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		br.setContent(wxGroupDao.queryWxGroup(searchDto));
		br.setPageCount(wxGroupDao.countWxGroup(searchDto));
		return br;
	}
	
	/**
	 * 同步微信用户数据
	 */
	public BaseResponseDto<Object> syncWxGroup(){
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.USER_GROUP_QUERY_URL, access_token);
		JsonObject jb = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), JsonObject.class,true);
		if(jb.get("errcode") == null){
			wxGroupDao.truncateWxGroup();//清空微信用户组表
			JsonArray ja = jb.get("groups").getAsJsonObject().getAsJsonArray();
			for (int i = 0; i < ja.size(); i++) {
				WxGroupInfo wxGroupInfo = new WxGroupInfo();
				wxGroupInfo.setGroupId(ja.get(i).getAsJsonObject().get("id").getAsLong());
				wxGroupInfo.setName(ja.get(i).getAsJsonObject().get("name").getAsString());
				wxGroupInfo.setCount(ja.get(i).getAsJsonObject().get("count").getAsInt());
				wxGroupDao.insertWxGroup(wxGroupInfo);
			}
		}else{
			br.setErrorCode(ErrorCode.wx_error.getCode());
			br.setContent(jb.get("errcode").getAsString() + "--" + jb.get("errmsg").getAsString());
		}
		return br;
	}
	
	/**
	 *删除用户组
	 * 
	 * @param searchDto
	 * @return
	 */
	public BaseResponseDto<Object> deleteWxGroup(WxGroupInfo wxGroupInfo) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.USER_GROUP_DELETE_URL, access_token);
		JsonObject jb = GsonUtils.fromJson(HttpClientUtils.post(url, "{\"group\":{\"id\":" + wxGroupInfo.getGroupId() + "}}", "UTF-8"), JsonObject.class,true);
		if(jb.get("errcode").getAsInt() == GlobConstants.WX_RESULT_FLAG_SUCCESSED){
			wxGroupDao.deleteWxGroup(wxGroupInfo.getId());
		}else{
			br.setErrorCode(ErrorCode.wx_error.getCode());
			br.setContent(jb.get("errcode").getAsString() + "--" + jb.get("errmsg").getAsString());
		}
		
		return br;
	}
}
