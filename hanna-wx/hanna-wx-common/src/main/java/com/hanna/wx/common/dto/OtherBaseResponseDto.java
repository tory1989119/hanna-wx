package com.hanna.wx.common.dto;

public class OtherBaseResponseDto<E> extends BaseResponseDto<E> {
	
	protected String averageRank; // 平均分

	protected String count; // 评价总数

	public String getAverageRank() {
		return averageRank;
	}

	public void setAverageRank(String averageRank) {
		this.averageRank = averageRank;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	
}
