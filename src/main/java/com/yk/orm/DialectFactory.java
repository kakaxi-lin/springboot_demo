package com.yk.orm;

import org.apache.ibatis.session.Configuration;

//import com.zehin.vpaas.common.util.PropertiesUtils;
//import com.zehin.vpaas.common.util.StringUtils;

/** 
 * @ClassName: DialectFactory 
 * @Description: 数据库方言工厂
 * @author: Administrator
 * @date: 2016年12月13日 上午10:33:10  
 */
public class DialectFactory {

    public static String dialectClass = null;

    /**
     * @Title: buildDialect
     * @Description: create dialect
     * @param @param configuration
     * @param @return  
     * @return Dialect 
     * @throws
     */
    public static Dialect buildDialect(Configuration configuration) {
    	String dialectClass =configuration.getVariables().getProperty("mysqlDialectClass");
//    	System.out.println("dialectClass..."+dialectClass);
    	/*String databaseType = PropertiesUtils.getProperties("databaseType");
    	
        if (dialectClass == null) {
            synchronized (DialectFactory.class) {
                if (dialectClass == null && (StringUtils.equals("mysql", databaseType))) {
                    dialectClass = configuration.getVariables().getProperty("mysqlDialectClass");
                }else if(dialectClass == null && (StringUtils.equals("oracle", databaseType))){
                	dialectClass = configuration.getVariables().getProperty("oracleDialectClass");
                }
            }
        }*/
        Dialect dialect = null;
        try {
            dialect = (Dialect) Class.forName(dialectClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("please check mybatis-config.xml  dialectClass settings.");
        }
        return dialect;
    }
}
