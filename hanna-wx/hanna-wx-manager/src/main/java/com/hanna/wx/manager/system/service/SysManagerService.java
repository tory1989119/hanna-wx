package com.hanna.wx.manager.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hanna.wx.db.dto.BaseResponseDto;
import com.hanna.wx.db.dao.SysManagerDAO;
import com.hanna.wx.db.dto.SysSearchDto;
import com.hanna.wx.db.model.SysAdminInfo;

@Service
public class SysManagerService {
    @Resource
    private SysManagerDAO sysManagerDAO;

    /**
     * 插入管理员信息
     * 
     * @param adminInfo
     * @return
     */
    public int insertAdminInfo(SysAdminInfo adminInfo) {
        return sysManagerDAO.insertAdminInfo(adminInfo);
    }

    /**
     * 修改管理员信息
     * 
     * @param adminInfo
     * @return
     */
    public int updateAdminInfo(SysAdminInfo adminInfo) {
        return sysManagerDAO.updateAdminInfo(adminInfo);
    }

    /**
     * 根据ID获取管理员信息 
     * 
     * @param id
     * @return
     */
    public SysAdminInfo getAdminInfoById(String id) {
        return sysManagerDAO.getAdminInfoById(id);
    }

    /**
     * 查询管理员列表
     * 
     * @param searchDto
     * @return
     */
    public BaseResponseDto<Object> queryAdmin(SysSearchDto searchDto) {
        BaseResponseDto<Object> br = new BaseResponseDto<Object>();
        br.setContent(sysManagerDAO.queryAdmin(searchDto));
        br.setPageCount(sysManagerDAO.countAdmin(searchDto));
        return br;
    }
}
