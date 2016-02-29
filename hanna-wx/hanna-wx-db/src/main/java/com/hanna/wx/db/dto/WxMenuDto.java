package com.hanna.wx.db.dto;

import java.util.List;

public class WxMenuDto {
	/**
	 * 菜单标题
	 */
	private String name;
	/**
	 * 菜单类型
	 */
	private String type;
	/**
	 * 菜单KEY值
	 */
	private String key;
	/**
	 * 网页链接
	 */
	private String url;
	/**
	 * 调用新增永久素材接口返回的合法media_id
	 */
	private String mediaId;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public List<WxMenuDto> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<WxMenuDto> sub_button) {
		this.sub_button = sub_button;
	}

	private List<WxMenuDto> sub_button;
}
