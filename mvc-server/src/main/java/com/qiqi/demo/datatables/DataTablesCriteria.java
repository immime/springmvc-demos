package com.qiqi.demo.datatables;

import java.io.Serializable;

/**
 * 封装request中datatables参数
 * 
 * @author wenyong
 */
public class DataTablesCriteria implements Serializable {
	private static final long serialVersionUID = -5302335145705816098L;

	/**
	 * 请求次数
	 */
	private Integer draw;
	/**
	 * 分页开始记录
	 */
	private Integer start;
	/**
	 * 分页大小
	 */
	private Integer length;
	/**
	 * 查询框输入的值
	 */
	private String searchValue;
	/**
	 * 查询正则表达式
	 */
	private String searchRegex;
	/**
	 * 排序规则ASC DESC
	 */
	private String orderValue;
	/**
	 * 排序字段值
	 */
	private String orderField;
	/**
	 * 排序字段列
	 */
	private String orderColumn;
	
	public DataTablesCriteria() {
		super();
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getSearchRegex() {
		return searchRegex;
	}

	public void setSearchRegex(String searchRegex) {
		this.searchRegex = searchRegex;
	}

	public String getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(String orderValue) {
		this.orderValue = orderValue;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

}
