package com.hanna.wx.common.enums;

/**
 * 接口调用返回的ErrorCode
 * 
 * @author melodymao
 * @version $Id: ErrorCodeEnum.java, v 0.1 2015年6月17日 下午12:56:42  Exp $
 */
public enum ErrorCode {

    sucessed("10000","成功"),
    sys_error("10001","系统错误"),
    login_error("10002","登录失败");
    
    private String code;
    
    private String des;
    
    private ErrorCode(String code,String des){
        this.code = code;
        this.des = des;
    }
    
    public String getCode(){
        return code;
    }
    
    public String getDes(){
        return des;
    }
}
