package com.hanna.wx.manager.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanna.wx.common.enums.ErrorCode;
import com.hanna.wx.db.dto.BaseResponseDto;
import com.hanna.wx.db.dto.SysSearchDto;
import com.hanna.wx.db.model.WxKfInfo;
import com.hanna.wx.manager.business.service.WxKfService;

@Controller
@RequestMapping("/bus/kr")
public class WxKfController {
	@Autowired
	WxKfService wxKfService;

	private Logger logger = LoggerFactory.getLogger(WxKfController.class);

	private final String WX_KF_MANA_PAGE = "bus/kr/wxKfMana"; // 微信用户组管理界面
	private final String ADD_WX_KF_PAGE = "bus/kr/addWxKf"; // 增加微信用户组
	private final String MODIFY_WX_KF_PAGE = "bus/kr/modifyWxKf"; // 修改微信用户组

	/**
	 * 跳转到微信用户组管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "wxKfManaPage.do", method = RequestMethod.GET)
	public String wxKfManaPage() {
		return WX_KF_MANA_PAGE;
	}

	/**
	 * 跳转到增加客服页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "addWxKfPage.do", method = RequestMethod.GET)
	public String addWxKfPage() {
		return ADD_WX_KF_PAGE;
	}
	
	/**
	 * 跳转到修改客服页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "modifyWxKfPage.do", method = RequestMethod.GET)
	public String modifyWxKfPage(HttpServletRequest request, String id) {
		try{
			WxKfInfo wxKfInfo = wxKfService.getWxKfInfo(id);
			request.setAttribute("wxKfInfo", wxKfInfo);
		} catch (Exception e) {
			logger.error("WxKfController.modifyWxKfPage", e);
		}
		return MODIFY_WX_KF_PAGE;
	}

	/**
	 * 查询客服列表
	 * 
	 * @param searchDto
	 * @return
	 */
	@RequestMapping(value = "queryWxKf.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> queryWxKf(SysSearchDto searchDto) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxKfService.queryWxKf(searchDto);
		} catch (Exception e) {
			logger.error("WxKfController.queryWxKf", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}

	/**
	 * 同步客服
	 * 
	 * @return
	 */
	@RequestMapping(value = "syncWxKf.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> syncWxKf() {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxKfService.syncWxKf();
		} catch (Exception e) {
			logger.error("WxKfController.syncWxKf", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}

	/**
	 * 新增客服
	 * 
	 * @return
	 */
	@RequestMapping(value = "insertWxKf.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> insertWxKf(WxKfInfo wxKfInfo) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxKfService.insertWxKf(wxKfInfo);
		} catch (Exception e) {
			logger.error("WxKfController.insertWxKf", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}

	/**
	 * 删除客服
	 * 
	 * @return
	 */
	@RequestMapping(value = "deleteWxKf.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> deleteWxKf(WxKfInfo wxKfInfo) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxKfService.deleteWxKf(wxKfInfo);
		} catch (Exception e) {
			logger.error("WxKfController.deleteWxKf", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}
	
	/**
	 * 更新客服
	 * 
	 * @return
	 */
	@RequestMapping(value = "updateWxKf.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> updateWxKf(WxKfInfo wxKfInfo) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxKfService.updateWxKf(wxKfInfo);
		} catch (Exception e) {
			logger.error("WxKfController.updateWxKf", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}
}
