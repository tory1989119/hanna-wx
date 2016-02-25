package com.hanna.wx.common.dto;

/**
 * 前台分页需要的参数
 * 
 * @author melodymao
 * 
 */
public class Pagination4BackModel {

    /**
     * 当前页数
     */
    private int page;

    /**
     * 每页记录数
     */
    private int rows = 10;

    public int getBegin() {
        return page * rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

}
