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
import com.hanna.wx.db.dao.WxMetarialDao;
import com.hanna.wx.db.dto.AccessTokenDto;
import com.hanna.wx.db.dto.BaseResponseDto;
import com.hanna.wx.db.dto.SysSearchDto;
import com.hanna.wx.db.model.WxMetarialInfo;

@Service
public class WxMetarialService {
	@Autowired
	private WxMetarialDao wxMetarialDao;

	/**
	 * 查询素材列表
	 * 
	 * @param searchDto
	 * @return
	 */
	public BaseResponseDto<Object> queryWxMetarial(SysSearchDto searchDto) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		br.setContent(wxMetarialDao.queryWxMetarial(searchDto));
		br.setPageCount(wxMetarialDao.countWxMetarial(searchDto));
		return br;
	}
	/**
	 * 同步素材
	 * @return
	 */
	public BaseResponseDto<Object> syncWxMetarial(){
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		Integer begin = 0;
		boolean flag = true;
		String url = String.format(WxConsts.METARIAL_QUERY_URL, AccessTokenDto.getAccess_token());
		wxMetarialDao.truncateWxMetarial();
		while (flag) {
			JsonObject jo = GsonUtils.fromJson(HttpClientUtils.post(url,"{\"type\":\"news\",\"offset\":" + begin + ",\"count\":20}", "UTF-8"),JsonObject.class, true);
			if(jo.get("errcode") == null){
				begin = begin +20;
				Integer item_count = jo.get("item_count").getAsInt();
				if(item_count > 0){
					JsonArray ja = jo.get("item").getAsJsonArray();
					for (int i = 0; i < ja.size(); i++) {
						JsonObject metarialJo = ja.get(i).getAsJsonObject();
						String media_id = metarialJo.get("media_id").getAsString();
						Long update_time = metarialJo.get("update_time").getAsLong();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						String date = sdf.format(new Date(update_time*1000));
						JsonArray metarualJa = metarialJo.get("content").getAsJsonObject().get("news_item").getAsJsonArray();
						for (int j = 0; j < metarualJa.size(); j++) {
							JsonObject mediaJo = metarualJa.get(j).getAsJsonObject();
							WxMetarialInfo wxMetarial = new WxMetarialInfo();
							wxMetarial.setMediaId(media_id);
							wxMetarial.setUpdateTime(date);
							wxMetarial.setTitle(mediaJo.get("title").getAsString());
							wxMetarial.setThumbMediaId(mediaJo.get("thumb_media_id").getAsString());
							wxMetarial.setThumbUrl(mediaJo.get("thumb_url").getAsString());
							wxMetarial.setShowCoverPic(mediaJo.get("show_cover_pic").getAsString());
							wxMetarial.setAuthor(mediaJo.get("author").getAsString());
							wxMetarial.setDigest(mediaJo.get("digest").getAsString());
							wxMetarial.setContent(mediaJo.get("content").getAsString());
							wxMetarial.setUrl(mediaJo.get("url").getAsString());
							wxMetarial.setContentSourceUrl(mediaJo.get("content_source_url").getAsString());
							wxMetarialDao.insertWxMetarial(wxMetarial);
						}
					}
				}else{
					flag = false;
				}
			}else{
				br.setErrorCode(ErrorCode.wx_error.getCode());
				br.setContent(jo.get("errcode").getAsString() + "--" + jo.get("errmsg").getAsString());
			}
		}
		return br;
	}
}
