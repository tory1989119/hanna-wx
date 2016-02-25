package com.hanna.wx.common.utils;

import static com.hanna.wx.common.enums.GlobConstants.SYMBOL_VERTICAL;

import java.io.UnsupportedEncodingException;

/**
 * 签名工具类
 * 
 * @author melodymao
 * @version $Id: SignUtils.java, v 0.1 2015年6月18日 上午9:49:15  Exp $
 */
public class SignUtils {

    private static final String SECRET_KEY = "ac11d8b0-70bp33dt-215nut51-69gic4l8-ut150duu-sx1loo9";

    /**
     * 签名验证
     * 
     * @param sign
     * @param keys
     * @return
     */
    public static boolean verifySign(String token, String... keys) {
        boolean result = false;
        if (null == keys || keys.length == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.length; i++) {
            sb.append(keys[i]).append(SYMBOL_VERTICAL);
            if (i == keys.length - 1) {
                sb.append(SECRET_KEY);
                break;
            }
        }
        String md5 = null;
        try {
            md5 = MD5Utils.getMD5String(sb.toString());
            if (md5.equals(token)) {
                result = true;
            }

        } catch (UnsupportedEncodingException e) {
        }
        return result;
    }

}
