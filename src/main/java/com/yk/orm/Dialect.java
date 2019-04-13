package com.yk.orm;

/** 
 * @ClassName: Dialect 
 * @Description: 数据库方言抽象类
 * @author: Administrator
 * @date: 2016年12月13日 上午10:31:24  
 */
public abstract class Dialect {

    /**
     * @Title: getLimitString 
     * @Description: 获取分页sql
     * @param sql
     * @param offset
     * @param limit
     * @return
     */
    public abstract String getLimitString(String sql, int offset, int limit);

    /**
     * @Title: getCountString 
     * @Description: 获取总数量
     * @param sql
     * @return
     */
    public abstract String getCountString(String sql);

}
