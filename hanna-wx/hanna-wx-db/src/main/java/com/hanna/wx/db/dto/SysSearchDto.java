package com.hanna.wx.db.dto;

public class SysSearchDto {
    /**
     * 1:创建时间 2：订单开始时间 3：订单结束时间
     */
    private String  dateType;
    /**
     * 开始日期
     */
    private String  startDate;
    /**
     * 结束日期
     */
    private String  endDate;
    /**
     * 姓名
     */
    private String nickName;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 统计类型 1:车辆数 2：司机数 3:注册资金
     */
    private String  totalType;
    /**
     * 开始统计数
     */
    private Integer startTotal;
    /**
     * 结束统计数
     */
    private Integer endTotal;
    /**
     * 页数
     */
    private Integer begin;

    /**
     * 每页记录数
     */
    private Integer rows;

    /**
     * 状态
     */
    private String  status;

    /**
     * 1:创建时间 2：订单开始时间 3：订单结束时间
     */
    public String getDateType() {
        return dateType;
    }

    /**
     * 1:创建时间 2：订单开始时间 3：订单结束时间
     */
    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    /**
     * 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 开始日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 开始日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * 结束日期
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 结束日期
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 统计类型 1:车辆数 2：司机数
     */
    public String getTotalType() {
        return totalType;
    }

    /**
     * 统计类型 1:车辆数 2：司机数
     */
    public void setTotalType(String totalType) {
        this.totalType = totalType;
    }

    /**
     * 开始统计数
     */
    public Integer getStartTotal() {
        return startTotal;
    }

    /**
     * 开始统计数
     */
    public void setStartTotal(Integer startTotal) {
        this.startTotal = startTotal;
    }

    /**
     * 结束统计数
     */
    public Integer getEndTotal() {
        return endTotal;
    }

    /**
     * 结束统计数
     */
    public void setEndTotal(Integer endTotal) {
        this.endTotal = endTotal;
    }

    /**
     * 每页记录数
     */
    public Integer getRows() {
        return rows;
    }

    /**
     * 每页记录数
     */
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * 页数
     */
    public Integer getBegin() {
        return begin;
    }

    /**
     * 页数
     */
    public void setBegin(Integer begin) {
        this.begin = begin;
    }

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
    
}
