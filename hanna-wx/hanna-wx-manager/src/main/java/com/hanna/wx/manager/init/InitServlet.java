package com.hanna.wx.manager.init;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;
import com.hanna.wx.common.enums.WxConsts;
import com.hanna.wx.common.http.HttpClientUtils;
import com.hanna.wx.common.utils.Configuration;
import com.hanna.wx.common.utils.GsonUtils;
import com.hanna.wx.db.dto.AccessTokenDto;
  
public class InitServlet extends HttpServlet {  
	private static Logger logger = Logger.getLogger(InitServlet.class);
      
    private static final long serialVersionUID = -7718302829857998640L;
    private static String contextPath;
    private static String classPath;
              
    @Override  
    public void init(ServletConfig config) throws ServletException {  
        super.init(config);
          
        String prefix = config.getServletContext().getRealPath("/");
        InitServlet.contextPath = prefix;
        InitServlet.classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        
        String grant_type = Configuration.getGlobalMsg("grant_type");
		String appid = Configuration.getGlobalMsg("appid");
		String secret = Configuration.getGlobalMsg("secret");
		String url = String.format( WxConsts.QUERY_TOKEN_URL, grant_type, appid, secret );
		JsonObject jb = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), JsonObject.class,true);
		AccessTokenDto.setAccess_token(jb.get("access_token").getAsString());
		AccessTokenDto.setExpires_in(jb.get("expires_in").getAsInt());
		logger.info("access_token = " + jb.get("access_token").getAsString());
    }
      
    @Override  
    public void destroy() {  
    }  
      
    public static final String getContextPath() {  
        return InitServlet.contextPath;
    }  
      
    public static final String getClassPath() {  
        return classPath;
    }  
      
}
