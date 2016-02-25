package com.hanna.wx.manager.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hanna.wx.db.dao.SysManagerDAO;
import com.hanna.wx.db.model.SysAdminInfo;
import com.hanna.wx.db.model.SysMenuInfo;

@Service
public class LoginService {
    @Resource
    private SysManagerDAO sysManagerDAO;

    /**
     * 登录操作
     * 
     * @param adminInfo
     * @return
     */
    public SysAdminInfo doLogin(SysAdminInfo adminInfo) {
        adminInfo = sysManagerDAO.getAdminInfoByUsernameAndPwd(adminInfo);
        return adminInfo;
    }

    /**
     * 获取菜单列表
     * 
     * @return
     */
    public String getMenuStr() {
        StringBuffer menuStr = new StringBuffer();
        //查询父节点所有菜单
        Map<String, String> fparams = new HashMap<String, String>();
        fparams.put("grade", "0");
        List<SysMenuInfo> flist = sysManagerDAO.queryMenu(fparams);
        //查询没个父节点下所有菜单
        for (SysMenuInfo fmenuInfo : flist) {
            Map<String, String> lparams = new HashMap<String, String>();
            lparams.put("grade", "1");
            lparams.put("fid", fmenuInfo.getMenuId());
            List<SysMenuInfo> llist = sysManagerDAO.queryMenu(lparams);
            if (llist != null && llist.size() > 0) {
                menuStr.append("<dl><dt>").append(fmenuInfo.getMenuName())
                    .append("</dt><dd class=\"leftListName\"><ul class=\"leftList\">");
                for (SysMenuInfo lmenuInfo : llist) {
                    menuStr.append("<li style=\"cursor:pointer;\" onclick=\"getMenu(this,'");
                    menuStr.append(lmenuInfo.getUrl());
                    menuStr.append("')\">");
                    menuStr.append(lmenuInfo.getMenuName());
                    menuStr.append("</li>");
                }
                menuStr.append("</ul></dd></dl>");
            }
        }
        return menuStr.toString();
    }
}