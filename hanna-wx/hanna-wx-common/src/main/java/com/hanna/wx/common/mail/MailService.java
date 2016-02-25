package com.hanna.wx.common.mail;

import static com.hanna.wx.common.enums.MailType.modify_passWord;
import static com.hanna.wx.common.enums.MailType.register_web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hanna.wx.common.enums.MailType;

@Component
public class MailService {

    @Value("${mail.server}")
    private String mailServer;     //发送邮件的主机	
    @Value("${mail.port}")
    private String mailPort;       //端口
    @Value("${mail.fromaddress}")
    private String mailFromAddress; //发送者地址
    @Value("${mail.validate}")
    private boolean isValidate;     //是否需要认证
    @Value("${mail.username}")
    private String userName;       //用户名
    @Value("${mail.password}")
    private String passWord;       //密码

    /**
     * 发送邮件
     * @param type
     * @param toAddress
     * @param copyToMails
     * @return
     */
    public boolean sendMail(MailType type, String[] toMails, String content) {
        SimpleMailSender sender = new SimpleMailSender();
        MailSenderInfo info = new MailSenderInfo();
        info.setMailServerHost(mailServer);
        info.setFromAddress(mailFromAddress);
        info.setMails(toMails);
        info.setUserName(userName);
        info.setPassword(passWord);
        info.setValidate(isValidate);
        switch (type) {
            case register_web://web版用户注册
                info.setSubject(register_web.getSubject());
                info.setContent(content);
                break;
            case modify_passWord://修改密码
                info.setSubject(modify_passWord.getSubject());
                info.setContent(content);
                break;

        }
        return sender.sendTextMail(info);
    }

}
