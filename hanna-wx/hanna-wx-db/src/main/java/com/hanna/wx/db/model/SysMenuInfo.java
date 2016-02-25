package com.hanna.wx.db.model;

import java.sql.Date;

/**
 * 系统后台菜单对象
 * @author wuxj
 *
 */
public class SysMenuInfo {
    /**
     * id
     */
    private long   id;
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
    private int    grade;
    /**
     * 排序
     */
    private int    sort;

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
         * 菜单编号
         */
    public String getMenuId() {
        return menuId;
    }

    /**
         * 菜单编号
         */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
         * 菜单名称
         */
    public String getMenuName() {
        return menuName;
    }

    /**
         * 菜单名称
         */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
         * 地址
         */
    public String getUrl() {
        return url;
    }

    /**
         * 地址
         */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
         * 上一级menuId
         */
    public String getFid() {
        return fid;
    }

    /**
         * 上一级menuId
         */
    public void setFid(String fid) {
        this.fid = fid;
    }

    /**
         * 菜单等级
         */
    public int getGrade() {
        return grade;
    }

    /**
         * 菜单等级
         */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
         * 排序
         */
    public int getSort() {
        return sort;
    }

    /**
         * 排序
         */
    public void setSort(int sort) {
        this.sort = sort;
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
