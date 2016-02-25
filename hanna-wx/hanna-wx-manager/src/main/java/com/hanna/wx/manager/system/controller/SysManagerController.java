package com.hanna.wx.manager.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanna.wx.common.dto.BaseResponseDto;
import com.hanna.wx.common.enums.ErrorCode;
import com.hanna.wx.db.dto.SysSearchDto;
import com.hanna.wx.db.model.SysAdminInfo;
import com.hanna.wx.manager.system.service.SysManagerService;

/**
 * 物流后台管理员Controller类
 * 关于物流后台管理员操作
 * 
 * @author wuxiaojian
 * @version $Id: SysManagerController.java, v 0.1 2015年12月18日 上午10:26:11  Exp $
 */
@Controller
@RequestMapping("/sys")
public class SysManagerController {
    private Logger            logger     = LoggerFactory.getLogger(SysManagerController.class);

    private final String      ADMIN_PAGE = "sys/admin";						  //管理员管理页面
    private final String      ADMIN_INFO_PAGE = "sys/adminInfo";			  //管理员详情页面
    private final String      ADD_ADMIN_PAGE = "sys/addAdmin";                //新增管理员页面
    private final String      MODIFY_ADMIN_PAGE = "sys/modifyAdmin";             //修改管理员信息页面
    

    @Resource
    private SysManagerService sysManagerService;

    /**
     * 跳转到管理员管理界面
     * 
     * @return
     */
    @RequestMapping(value = "adminPage.do", method = RequestMethod.GET)
    public String adminInfoPage() {
        return ADMIN_PAGE;
    }
    
    /**
     * 跳转到新增管理员界面
     * 
     * @return
     */
    @RequestMapping(value = "addAdminPage.do", method = RequestMethod.GET)
    public String addAdminPage() {
    	return ADD_ADMIN_PAGE;
    }

    /**
     * 查询管理员列表
     * 
     * @param searchDto
     * @return
     */
    @RequestMapping(value = "queryAdmin.do", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public BaseResponseDto<Object> queryAdmin(SysSearchDto searchDto) {
        BaseResponseDto<Object> br = new BaseResponseDto<Object>();
        try {
            return sysManagerService.queryAdmin(searchDto);
        } catch (Exception e) {
            logger.error("SysManagerController.queryAdminInfo", e);
            br.setErrorCode(ErrorCode.sys_error.getCode());
            br.setContent(ErrorCode.sys_error.getDes());
        }
        return br;
    }

    /**
     * 跳转管理员详细信息页面
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "getAdminInfo.do", method = RequestMethod.GET)
    public String getAdminInfo(HttpServletRequest request,String id) {
        try {
            SysAdminInfo adminInfo = sysManagerService.getAdminInfoById(id);
            request.setAttribute("adminInfo", adminInfo);
        } catch (Exception e) {
            logger.error("SysManagerController.getAdminInfo", e);
        }
        return ADMIN_INFO_PAGE;
    }
    
    /**
     * 跳转修改管理员信息页面
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "modifyAdminInfo.do", method = RequestMethod.GET)
    public String modifyAdminInfo(HttpServletRequest request,String id) {
    	try {
    		SysAdminInfo adminInfo = sysManagerService.getAdminInfoById(id);
    		request.setAttribute("adminInfo", adminInfo);
    	} catch (Exception e) {
    		logger.error("SysManagerController.getAdminInfo", e);
    	}
    	return MODIFY_ADMIN_PAGE;
    }

    /**
     * 增加管理员
     * 
     * @param request
     * @param adminInfo
     * @return
     */
    @RequestMapping(value = "insertAdminInfo.do", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public BaseResponseDto<Object> insertAdminInfo(SysAdminInfo adminInfo) {
        BaseResponseDto<Object> br = new BaseResponseDto<Object>();
        try {
            sysManagerService.insertAdminInfo(adminInfo);
        } catch (Exception e) {
            logger.error("SysManagerController.insertAdminInfo", e);
            br.setErrorCode(ErrorCode.sys_error.getCode());
            br.setContent(ErrorCode.sys_error.getDes());
        }
        return br;
    }

    /**
     * 修改管理员
     * 
     * @param request
     * @param adminInfo
     * @return
     */
    @RequestMapping(value = "updateAdminInfo.do", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody BaseResponseDto<Object> updateAdminInfo(SysAdminInfo adminInfo) {
        BaseResponseDto<Object> br = new BaseResponseDto<Object>();
        try {
            sysManagerService.updateAdminInfo(adminInfo);
        } catch (Exception e) {
            logger.error("SysManagerController.updateAdminInfo", e);
            br.setErrorCode(ErrorCode.sys_error.getCode());
            br.setContent(ErrorCode.sys_error.getDes());
        }
        return br;
    }
}
