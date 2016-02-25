package com.hanna.wx.common.enums;
/**
 * 消息类型枚举
 * @author wuxj
 *
 */
public enum MsgTypeEnum {
	TEXT("text"),
	IMAGE("image"),
	VOICE("voice"),
	VIDEO("video"),
	LOCATION("location"),
	LINK("link"),
	EVENT("event");
	
	private String type;
	
	private MsgTypeEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
