package com.hanna.wx.db.model;

import java.sql.Date;

/**
 * 系统后台菜单对象
 * 
 * @author wuxj
 *
 */
public class SysMenuInfo {
	/**
	 * id
	 */
	private long id;
	/**
	 * 菜单编号
	 */
	private String menuId;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 地址
	 */
	private String url;
	/**
	 * 上一级menuId
	 */
	private String fid;
	/**
	 * 菜单等级
	 */
	private int grade;
	/**
	 * 排序
	 */
	private int sort;

	/**
	 * 是否已删除 '0'未删除 '1'已删除
	 */
	private String isDeleted;
	/**
	 * 创建时间
	 */
	private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
