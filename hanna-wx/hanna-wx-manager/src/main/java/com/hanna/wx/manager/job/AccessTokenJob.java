package com.hanna.wx.manager.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;

import com.google.gson.JsonObject;
import com.hanna.wx.common.enums.WxConsts;
import com.hanna.wx.common.http.HttpClientUtils;
import com.hanna.wx.common.utils.Configuration;
import com.hanna.wx.common.utils.GsonUtils;
import com.hanna.wx.db.dto.AccessTokenDto;
/**
 * 获取access_Token
 * @author Administrator
 *
 */
@Configurable
public class AccessTokenJob {

	private Logger logger = LoggerFactory.getLogger(AccessTokenJob.class);
	
	//轮询过期的订单
	public void execute() {
		String grant_type = Configuration.getGlobalMsg("grant_type");
		String appid = Configuration.getGlobalMsg("appid");
		String secret = Configuration.getGlobalMsg("secret");
		String url = String.format( WxConsts.QUERY_TOKEN_URL, grant_type, appid, secret );
		JsonObject jb = GsonUtils.fromJson(HttpClientUtils.get(url), JsonObject.class);
		AccessTokenDto.access_token = jb.get("access_token").getAsString();
		AccessTokenDto.expires_in = jb.get("expires_in").getAsInt();
		logger.info("access_token = " + jb.get("access_token").getAsString());
	}
}
