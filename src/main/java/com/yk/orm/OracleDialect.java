package com.yk.orm;

/**
 * @ClassName: OracleDialect
 * @Description: (oracle方言处理)
 * @author kunka kong0609@163.com
 * @date 2015年12月21日 下午1:17:36
 */
public class OracleDialect extends Dialect {

	@Override
	public String getLimitString(String sql, int offset, int limit) {

		sql = sql.trim();
		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" for update")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}

		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);

		pagingSelect
				.append("select * from ( select row_.*, rownum rownum_ from ( ");

		pagingSelect.append(sql);

		pagingSelect.append(" ) row_ ) where rownum_ > " + offset
				+ " and rownum_ <= " + (offset + limit));

		if (isForUpdate) {
			pagingSelect.append(" for update");
		}

		return pagingSelect.toString();
	}

	@Override
	public String getCountString(String sql) {
		return new StringBuffer().append("select count(1) count from (")
				.append(sql).append(" ) t").toString();
	}
}
