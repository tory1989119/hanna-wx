package com.hanna.wx.common.utils;

/**
 * 综合排名工具类
 * 
 * @author melodymao
 * @version $Id: ComplexRankingUtils.java, v 0.1 2015年6月21日 下午5:04:33  Exp $
 */
public class ComplexRankingUtils {

    /**
     * 通过评分和单量计算的综合分
     * 
     * @param rank
     * @param orderCount
     */
    public static int calc(float rank,int orderCount){
        return Math.round(rank*(orderCount*0.4f)*0.6f);
    }
}
