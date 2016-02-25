package com.hanna.wx.common.enums;

//邮件类型
public enum MailType {

	register_web("1","web版注册邮件","欢迎注册易货物流用户"),
	modify_passWord("2","web版修改密码","易货物流用户修改密码");
	
	private String type;
	
	private String desc;
	
	private String subject;
	
	private MailType(String type,String desc,String subject){
		this.type = type;
		this.desc = desc;
		this.subject = subject;
	}
	
	public String getType(){
		return type;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public String getSubject(){
		return subject;
	}
}
