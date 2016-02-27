package com.hanna.wx.db.dao;

import java.util.List;
import java.util.Map;

import com.hanna.wx.db.dto.SysSearchDto;
import com.hanna.wx.db.model.SysUserInfo;
import com.hanna.wx.db.model.SysMenuInfo;


public interface SysManagerDAO {
    /**
     * 根据账号和密码获取用户信息
     * 
     * @param sysUserInfo
     * @return
     */
    public SysUserInfo getSysUserByUsernameAndPwd(SysUserInfo sysUserInfo);

    

    /**
     * 插入管理员信息
     * 
     * @param sysUserInfo
     * @return
     */
    public int insertSysUser(SysUserInfo sysUserInfo);

    /**
     * 修改管理员信息
     * 
     * @param sysUserInfo
     * @return
     */
    public int updateSysUser(SysUserInfo sysUserInfo);

    /**
     * 根据ID获取管理员信息 
     * 
     * @param id
     * @return
     */
    public SysUserInfo getSysUserById(String id);

    /**
     * 查询管理员列表
     * 
     * @param searchDto
     * @return
     */
    public List<SysUserInfo> querySysUser(SysSearchDto searchDto);

    /**
     * 查询管理员列表数
     * 
     * @param searchDto
     * @return
     */
    public int countSysUser(SysSearchDto searchDto);

    /**
     * 获取菜单列表
     * 
     * @return
     */
    public List<SysMenuInfo> querySysMenu(Map<String, String> params);
}