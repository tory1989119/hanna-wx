package com.hanna.wx.db.model;

/**
 * 
 * @ClassName: WxInMessage
 * @Package com.wx.plat.core.model.msg
 * @Description: 微信消息响应对象
 * @author rockyLee
 * @date 2015-7-9 下午12:49:57
 * 
 */
public class WxInMessage{
	
	private String URL;//请求url路劲

	/** 开发者微信号 */
	private String ToUserName;
	/** 发送方帐号（一个OpenID） */
	private String FromUserName;
	/** 消息创建时间(整形) */
	private Long CreateTime;
	/**
	 * 消息类型
	 * 
	 * @link com.com.wx.plat.core.WxConsts.MSG_*
	 */
	private String MsgType;
	/** 消息id, 消息排重 */
	private Long MsgId;

	/** 文本消息内容 */
	private String Content;

	/** 图片链接 */
	private String PicUrl;

	/** 消息媒体id，可以调用多媒体文件下载接口拉取数据 */
	private String MediaId;

	/** 语音格式，如amr，speex等 */
	private String Format;

	/** 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据 */
	private String ThumbMediaId;

	/** 地理位置维度 */
	private Double Location_X;
	/** 地理位置经度 */
	private Double Location_Y;
	/** 地图缩放大小 */
	private Double Scale;
	/** 地理位置信息 */
	private String Label;
	/** 消息标题 */
	private String Title;
	/** 消息描述 */
	private String Description;
	/** 链接URL */
	private String Url;
	/** 事件类型, 有ENTER(进入会话)和LOCATION(地理位置) */
	private String Event;
	/** 地理位置维度，事件类型为LOCATION的时存在 */
	private Double Latitude;
	/** 地理位置经度，事件类型为LOCATION的时存在 */
	private Double Longitude;
	/** 地理位置精度，事件类型为LOCATION的时存在 */
	private Double Precision;
	/** 事件KEY值 */
	private String EventKey;
	/** 二维码的ticket，可用来换取二维码图片 */
	private String Ticket;


	public String getURL() {
		return URL;
	}


	public void setURL(String uRL) {
		URL = uRL;
	}


	/**
	 * getter method
	 * 
	 * @return toUserName
	 */
	public String getToUserName() {

		return ToUserName;
	}


	/**
	 * setter method
	 * 
	 * @param toUserName
	 */
	public void setToUserName( String toUserName ) {

		ToUserName = toUserName;
	}


	/**
	 * getter method
	 * 
	 * @return fromUserName
	 */
	public String getFromUserName() {

		return FromUserName;
	}


	/**
	 * setter method
	 * 
	 * @param fromUserName
	 */
	public void setFromUserName( String fromUserName ) {

		FromUserName = fromUserName;
	}


	/**
	 * getter method
	 * 
	 * @return createTime
	 */
	public Long getCreateTime() {

		return CreateTime;
	}


	/**
	 * setter method
	 * 
	 * @param createTime
	 */
	public void setCreateTime( Long createTime ) {

		CreateTime = createTime;
	}


	/**
	 * getter method
	 * 
	 * @return msgType
	 */
	public String getMsgType() {

		return MsgType;
	}


	/**
	 * setter method
	 * 
	 * @param msgType
	 */
	public void setMsgType( String msgType ) {

		MsgType = msgType;
	}


	/**
	 * getter method
	 * 
	 * @return msgId
	 */
	public Long getMsgId() {

		return MsgId;
	}


	/**
	 * setter method
	 * 
	 * @param msgId
	 */
	public void setMsgId( Long msgId ) {

		MsgId = msgId;
	}


	/**
	 * getter method
	 * 
	 * @return content
	 */
	public String getContent() {

		return Content;
	}


	/**
	 * setter method
	 * 
	 * @param content
	 */
	public void setContent( String content ) {

		Content = content;
	}


	/**
	 * getter method
	 * 
	 * @return picUrl
	 */
	public String getPicUrl() {

		return PicUrl;
	}


	/**
	 * setter method
	 * 
	 * @param picUrl
	 */
	public void setPicUrl( String picUrl ) {

		PicUrl = picUrl;
	}


	/**
	 * getter method
	 * 
	 * @return mediaId
	 */
	public String getMediaId() {

		return MediaId;
	}


	/**
	 * setter method
	 * 
	 * @param mediaId
	 */
	public void setMediaId( String mediaId ) {

		MediaId = mediaId;
	}


	/**
	 * getter method
	 * 
	 * @return format
	 */
	public String getFormat() {

		return Format;
	}


	/**
	 * setter method
	 * 
	 * @param format
	 */
	public void setFormat( String format ) {

		Format = format;
	}


	/**
	 * getter method
	 * 
	 * @return thumbMediaId
	 */
	public String getThumbMediaId() {

		return ThumbMediaId;
	}


	/**
	 * setter method
	 * 
	 * @param thumbMediaId
	 */
	public void setThumbMediaId( String thumbMediaId ) {

		ThumbMediaId = thumbMediaId;
	}


	/**
	 * getter method
	 * 
	 * @return location_X
	 */
	public Double getLocation_X() {

		return Location_X;
	}


	/**
	 * setter method
	 * 
	 * @param location_X
	 */
	public void setLocation_X( Double location_X ) {

		Location_X = location_X;
	}


	/**
	 * getter method
	 * 
	 * @return location_Y
	 */
	public Double getLocation_Y() {

		return Location_Y;
	}


	/**
	 * setter method
	 * 
	 * @param location_Y
	 */
	public void setLocation_Y( Double location_Y ) {

		Location_Y = location_Y;
	}


	/**
	 * getter method
	 * 
	 * @return scale
	 */
	public Double getScale() {

		return Scale;
	}


	/**
	 * setter method
	 * 
	 * @param scale
	 */
	public void setScale( Double scale ) {

		Scale = scale;
	}


	/**
	 * getter method
	 * 
	 * @return label
	 */
	public String getLabel() {

		return Label;
	}


	/**
	 * setter method
	 * 
	 * @param label
	 */
	public void setLabel( String label ) {

		Label = label;
	}


	/**
	 * getter method
	 * 
	 * @return title
	 */
	public String getTitle() {

		return Title;
	}


	/**
	 * setter method
	 * 
	 * @param title
	 */
	public void setTitle( String title ) {

		Title = title;
	}


	/**
	 * getter method
	 * 
	 * @return description
	 */
	public String getDescription() {

		return Description;
	}


	/**
	 * setter method
	 * 
	 * @param description
	 */
	public void setDescription( String description ) {

		Description = description;
	}


	/**
	 * getter method
	 * 
	 * @return url
	 */
	public String getUrl() {

		return Url;
	}


	/**
	 * setter method
	 * 
	 * @param url
	 */
	public void setUrl( String url ) {

		Url = url;
	}


	/**
	 * getter method
	 * 
	 * @return event
	 */
	public String getEvent() {

		return Event;
	}


	/**
	 * setter method
	 * 
	 * @param event
	 */
	public void setEvent( String event ) {

		Event = event;
	}


	/**
	 * getter method
	 * 
	 * @return latitude
	 */
	public Double getLatitude() {

		return Latitude;
	}


	/**
	 * setter method
	 * 
	 * @param latitude
	 */
	public void setLatitude( Double latitude ) {

		Latitude = latitude;
	}


	/**
	 * getter method
	 * 
	 * @return longitude
	 */
	public Double getLongitude() {

		return Longitude;
	}


	/**
	 * setter method
	 * 
	 * @param longitude
	 */
	public void setLongitude( Double longitude ) {

		Longitude = longitude;
	}


	/**
	 * getter method
	 * 
	 * @return precision
	 */
	public Double getPrecision() {

		return Precision;
	}


	/**
	 * setter method
	 * 
	 * @param precision
	 */
	public void setPrecision( Double precision ) {

		Precision = precision;
	}


	/**
	 * getter method
	 * 
	 * @return eventKey
	 */
	public String getEventKey() {

		return EventKey;
	}


	/**
	 * setter method
	 * 
	 * @param eventKey
	 */
	public void setEventKey( String eventKey ) {

		EventKey = eventKey;
	}


	/**
	 * getter method
	 * 
	 * @return ticket
	 */
	public String getTicket() {

		return Ticket;
	}


	/**
	 * setter method
	 * 
	 * @param ticket
	 */
	public void setTicket( String ticket ) {

		Ticket = ticket;
	}

}
