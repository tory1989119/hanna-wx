package com.hanna.wx.common.dto;
/**
 * 推送消息dto
 * 
 * @author melodymao
 * @version $Id: BaseMessageDto.java, v 0.1 2015年7月12日 下午4:11:08  Exp $
 */
public class BaseMessageDto<E> {

    protected int messageType;//消息头
    
    protected  E content;//消息体 

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }
    
    
}
