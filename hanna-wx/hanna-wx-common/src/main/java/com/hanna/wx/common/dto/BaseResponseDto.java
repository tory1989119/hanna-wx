package com.hanna.wx.common.dto;

import static com.hanna.wx.common.enums.ErrorCode.sucessed;
import static com.hanna.wx.common.enums.GlobConstants.REQUEST_RESULT_FLAG_SUCCESSED;


/**
 * 消息体
 * @author wuxj
 *
 * @param <E>
 */
public class BaseResponseDto<E>{

    protected int flag = REQUEST_RESULT_FLAG_SUCCESSED;//调用结果标志位 0:失败 1:成功
    
    protected String errorCode = sucessed.getCode();//错误编码
    
    protected int pageCount;//分页数据的总数
    
    protected E content;//返回的内容

    public int getFlag() {
    	if(!sucessed.getCode().equals(errorCode)){
    		flag = 0;
    	}
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
