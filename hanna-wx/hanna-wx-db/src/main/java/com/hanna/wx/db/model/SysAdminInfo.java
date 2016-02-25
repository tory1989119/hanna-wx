package com.hanna.wx.db.model;

import java.sql.Date;

/**
 * 管理端系统管理员
 * 
 * @author wuxiaojian
 * @version $Id: SysAdminInfo.java, v 0.1 2015年12月17日 下午1:51:05  Exp $
 */
public class SysAdminInfo {
    /**
     * id
     */
    private long   id;
    /**
     * 姓名
     */
    private String nickName;
    /**
     * 性别
     */
    private int    sex;
    /**
     * 年龄
     */
    private int    age;
    /**
     * 地址
     */
    private String address;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 是否已删除  '0'未删除 '1'已删除
     */
    private String isDeleted;
    /**
     * 创建时间
     */
    private Date   createTime;

    /**
         * id
         */
    public long getId() {
        return id;
    }

    /**
         * id
         */
    public void setId(long id) {
        this.id = id;
    }

    /**
         * 姓名
         */
    public String getNickName() {
        return nickName;
    }

    /**
         * 姓名
         */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 性别
     */
    public int getSex() {
        return sex;
    }

    /**
     * 性别
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * 年龄
     */
    public int getAge() {
        return age;
    }

    /**
     * 年龄
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 手机号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 手机号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
         * 账号
         */
    public String getUsername() {
        return username;
    }

    /**
         * 账号
         */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 是否已删除  '0'未删除 '1'已删除
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否已删除  '0'未删除 '1'已删除
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
