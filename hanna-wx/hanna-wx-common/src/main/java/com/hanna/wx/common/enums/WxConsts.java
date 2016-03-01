package com.hanna.wx.common.enums;

public interface WxConsts {

	/** 获取token的URL路径 */
	public static final String QUERY_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=%s&appid=%s&secret=%s";

	/** 用户管理-分组管理-新增分组URL */
	public static final String USER_GROUP_ADD_URL = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=%s";
	
	/** 用户管理-分组管理-删除分组URL */
	public static final String USER_GROUP_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=%s";

	/** 用户管理-分组管理-查询分组URL */
	public static final String USER_GROUP_QUERY_URL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=%s";

	/** 用户管理-分组管理-查询用户所在分组 */
	public static final String USER_GROUP_QUERY_USER_URL = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=%s";

	/** 用户管理-设置用户备注名 */
	public static final String USER_UPDATE_REMARK_URL = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=%s";

	/** 用户管理-获取用户基本信息 */
	public static final String USER_QUERY_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=%s";

	/** 用户管理-批量获取用户信息 */
	public static final String USER_QUERY_LIST_URL = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=%s";

	/** 用户管理-获取用户列表 */
	public static final String USER_QUERY_ALL_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=%s&next_openid=%s";

	/** 菜单管理 - 查询菜单 */
	public static final String MENU_QUERY_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=%s";

	/** 菜单管理 - 创建菜单 */
	public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
	
	/** 菜单管理 - 删除菜单 */
	public static final String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%s";


	// /////////////////////
	// oauth2网页授权的scope
	// /////////////////////
	/** 不弹出授权页面，直接跳转，只能获取用户openid */
	public static final String OAUTH2_SCOPE_BASE = "snsapi_base";
	/** 弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息 */
	public static final String OAUTH2_SCOPE_USER_INFO = "snsapi_userinfo";

}