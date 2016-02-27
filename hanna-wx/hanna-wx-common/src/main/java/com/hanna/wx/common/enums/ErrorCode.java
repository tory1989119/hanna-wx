package com.hanna.wx.common.enums;

/**
 * 系统错误定义
 * @author wuxj
 *
 */
public enum ErrorCode {

    sucessed("10000","成功"),
    sys_error("10001","系统错误"),
    login_error("10002","登录失败"),
    no_this_function("10003","无此功能");
    
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
