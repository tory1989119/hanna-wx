package com.hanna.wx.db.dao;

import java.util.List;
import java.util.Map;

import com.hanna.wx.db.dto.SysSearchDto;
import com.hanna.wx.db.model.SysAdminInfo;
import com.hanna.wx.db.model.SysMenuInfo;


public interface SysManagerDAO {
    /**
     * 根据账号和密码获取用户信息
     * 
     * @param adminInfo
     * @return
     */
    public SysAdminInfo getAdminInfoByUsernameAndPwd(SysAdminInfo adminInfo);

    

    /**
     * 插入管理员信息
     * 
     * @param adminInfo
     * @return
     */
    public int insertAdminInfo(SysAdminInfo adminInfo);

    /**
     * 修改管理员信息
     * 
     * @param adminInfo
     * @return
     */
    public int updateAdminInfo(SysAdminInfo adminInfo);

    /**
     * 根据ID获取管理员信息 
     * 
     * @param id
     * @return
     */
    public SysAdminInfo getAdminInfoById(String id);

    /**
     * 查询管理员列表
     * 
     * @param searchDto
     * @return
     */
    public List<SysAdminInfo> queryAdmin(SysSearchDto searchDto);

    /**
     * 查询管理员列表数
     * 
     * @param searchDto
     * @return
     */
    public int countAdmin(SysSearchDto searchDto);

    /**
     * 获取菜单列表
     * 
     * @return
     */
    public List<SysMenuInfo> queryMenu(Map<String, String> params);
}