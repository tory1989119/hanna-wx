package com.hanna.wx.db.model;

/**
 * 用户基本信息响应对象
 * @author wuxj
 *
 */
public class WxUserInfo{
	/**
	 * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	 */
	private Integer subscribe;
	/**
	 * 用户的标识，对当前公众号唯一
	 */
	private String openid;
	/**
	 * 用户的昵称
	 */
	private String nickname;
	/**
	 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	 */
	private Integer sex;
	/**
	 * 用户的语言，简体中文为zh_CN, 繁体zh_TW, 英语en
	 */
	private String language;
	/**
	 * 用户所在城市
	 */
	private String city;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 头像
	 */
	private String headimgurl;
	/**
	 * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	 */
	private Long subscribe_time;
	/**
	 * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	 */
	private String unionid;
	/**
	 * 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	 */
	private String remark;
	/**
	 * 用户所在的分组ID
	 */
	private Integer groupid;


	/**
	 * getter method
	 * 
	 * @return subscribe
	 */
	public Integer getSubscribe() {

		return subscribe;
	}


	/**
	 * setter method
	 * 
	 * @param subscribe
	 */
	public void setSubscribe( Integer subscribe ) {

		this.subscribe = subscribe;
	}


	/**
	 * getter method
	 * 
	 * @return openid
	 */
	public String getOpenid() {

		return openid;
	}


	/**
	 * setter method
	 * 
	 * @param openid
	 */
	public void setOpenid( String openid ) {

		this.openid = openid;
	}


	/**
	 * getter method
	 * 
	 * @return nickname
	 */
	public String getNickname() {

		return nickname;
	}


	/**
	 * setter method
	 * 
	 * @param nickname
	 */
	public void setNickname( String nickname ) {

		this.nickname = nickname;
	}


	/**
	 * getter method
	 * 
	 * @return sex
	 */
	public Integer getSex() {

		return sex;
	}


	/**
	 * setter method
	 * 
	 * @param sex
	 */
	public void setSex( Integer sex ) {

		this.sex = sex;
	}


	/**
	 * getter method
	 * 
	 * @return language
	 */
	public String getLanguage() {

		return language;
	}


	/**
	 * setter method
	 * 
	 * @param language
	 */
	public void setLanguage( String language ) {

		this.language = language;
	}


	/**
	 * getter method
	 * 
	 * @return city
	 */
	public String getCity() {

		return city;
	}


	/**
	 * setter method
	 * 
	 * @param city
	 */
	public void setCity( String city ) {

		this.city = city;
	}


	/**
	 * getter method
	 * 
	 * @return province
	 */
	public String getProvince() {

		return province;
	}


	/**
	 * setter method
	 * 
	 * @param province
	 */
	public void setProvince( String province ) {

		this.province = province;
	}


	/**
	 * getter method
	 * 
	 * @return country
	 */
	public String getCountry() {

		return country;
	}


	/**
	 * setter method
	 * 
	 * @param country
	 */
	public void setCountry( String country ) {

		this.country = country;
	}


	/**
	 * getter method
	 * 
	 * @return headimgurl
	 */
	public String getHeadimgurl() {

		return headimgurl;
	}


	/**
	 * setter method
	 * 
	 * @param headimgurl
	 */
	public void setHeadimgurl( String headimgurl ) {

		this.headimgurl = headimgurl;
	}


	/**
	 * getter method
	 * 
	 * @return subscribe_time
	 */
	public Long getSubscribe_time() {

		return subscribe_time;
	}


	/**
	 * setter method
	 * 
	 * @param subscribe_time
	 */
	public void setSubscribe_time( Long subscribe_time ) {

		this.subscribe_time = subscribe_time;
	}


	/**
	 * getter method
	 * 
	 * @return unionid
	 */
	public String getUnionid() {

		return unionid;
	}


	/**
	 * setter method
	 * 
	 * @param unionid
	 */
	public void setUnionid( String unionid ) {

		this.unionid = unionid;
	}


	/**
	 * getter method
	 * 
	 * @return remark
	 */
	public String getRemark() {

		return remark;
	}


	/**
	 * setter method
	 * 
	 * @param remark
	 */
	public void setRemark( String remark ) {

		this.remark = remark;
	}


	/**
	 * getter method
	 * 
	 * @return groupid
	 */
	public Integer getGroupid() {

		return groupid;
	}


	/**
	 * setter method
	 * 
	 * @param groupid
	 */
	public void setGroupid( Integer groupid ) {

		this.groupid = groupid;
	}
}
