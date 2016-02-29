package com.hanna.wx.manager.business.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanna.wx.db.dao.WxMenuDao;
import com.hanna.wx.db.dto.BaseResponseDto;
import com.hanna.wx.db.model.WxMenuInfo;

@Service
public class WxMenuService {
	@Autowired
	private WxMenuDao wxMenuDao;

	/**
	 * 插入微信菜单
	 * 
	 * @param wxMenuInfo
	 */
	public void insertWxUser(WxMenuInfo wxMenuInfo) {
		wxMenuDao.insertWxUser(wxMenuInfo);
	}

	/**
	 * 根据ID获取微信菜单信息
	 * 
	 * @param id
	 * @return
	 */
	public WxMenuInfo getWxMenuInfoById(String id) {
		return wxMenuDao.getWxMenuInfoById(id);
	}

	/**
	 * 查询微信一级菜单
	 * 
	 * @return
	 */
	public BaseResponseDto<Object> queryOneLevelWxMenu() {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		br.setContent(wxMenuDao.queryOneLevelWxMenu());
		br.setPageCount(wxMenuDao.countOneLevelWxMenu());
		return br;
	}

	/**
	 * 查询微信二级菜单
	 * 
	 * @param fid
	 * @return
	 */
	public BaseResponseDto<Object> querySecondLevelWxMenu(String fid) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		br.setContent(wxMenuDao.querySecondLevelWxMenu(fid));
		br.setPageCount(wxMenuDao.countSecondLevelWxMenu(fid));
		return br;
	}

	/**
	 * 删除菜单
	 * 
	 * @param id
	 */
	public void deleteWxMenu(String id) {
		wxMenuDao.deleteWxMenu(id);
	}

}
