package com.yk.orm;

/** 
 * @ClassName: MySqlDialect 
 * @Description: TODO
 * @author: JiaDawei
 * @date: 2016年12月13日 下午3:04:09  
 */
public class MySqlDialect extends Dialect {

	protected static final String SQL_END_DELIMITER = ";";

	private String trim(String sql) {
		sql = sql.trim();
		if (sql.endsWith(SQL_END_DELIMITER)) {
			sql = sql.substring(0, sql.length() - 1 - SQL_END_DELIMITER.length());
		}
		return sql;
	}

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		sql = trim(sql);
		StringBuffer sb = new StringBuffer(sql.length() + 20);
		sb.append(sql);
		if (offset > 0) {
			sb.append(" limit ").append(offset).append(',').append(limit).append(SQL_END_DELIMITER);
		} else {
			sb.append(" limit ").append(limit).append(SQL_END_DELIMITER);
		}
		return sb.toString();
	}

	@Override
	public String getCountString(String sql) {
		return new StringBuffer().append("select count(1) count from ( ").append(sql).append(" ) t").toString();
	}

}
