package com.qiqi.demo.pager;

import com.qiqi.demo.pojo.BaseEntity;

/**
 * 排序字段
 * @author JOHN
 *
 */
public class SortField extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	private String field;
	private SortDirection direction;
	
	public SortField() {
	}

	public SortField(String field, SortDirection direction) {
		super();
		this.field = field;
		this.direction = direction;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public SortDirection getDirection() {
		return direction;
	}

	public void setDirection(SortDirection direction) {
		this.direction = direction;
	}
	
}
