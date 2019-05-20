package com.yk.orm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;

/** 
 * @ClassName: PageVO 
 * @Description: page vo
 * @author: Administrator
 * @date: 2016年12月13日 上午10:25:26 
 * @param <T> 
 */
public class PageVO<T> extends RowBounds implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 页编号 : 第几页
	 */
	protected Integer page = 1;
	/**
	 * 页大小 : 每页的数量
	 */
	protected Integer rows = 5;

	private Integer total = 0;
	
	/**
	 * @fieldName: result
	 * @fieldType: List<T>
	 * @Description: the result data
	 */
	private List<T> result = new ArrayList<T>();
	
	private Map<String, Object> dataGrid = new HashMap<String, Object>();

	public PageVO() {
		super();
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public List<T> getResult() {
		return result;
	}


	/** 
	 * @Title: getDataGrid 
	 * @Description: get data grid
	 * @return
	 * @return: Map<String,Object>
	 */
	public Map<String, Object> getDataGrid() {
		return dataGrid;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
		dataGrid.put("total", total);
	}

	public void setResult(List<T> result) {
		this.result = result;
		dataGrid.put("rows", result);
	}
}
