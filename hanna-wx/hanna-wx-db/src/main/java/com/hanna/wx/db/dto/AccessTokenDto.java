package com.hanna.wx.db.dto;

/**
 * 获取token的响应结果对象
 * 
 * @author wuxj
 *
 */
public class AccessTokenDto{

	/**
	 * 获取到的凭证
	 */
	public static String access_token;

	/**
	 * 凭证有效时间，单位：秒
	 */
	public static Integer expires_in;

	/**
	 * 
	 */
	private AccessTokenDto() {
	}
}
