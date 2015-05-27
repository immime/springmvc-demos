package com.qiqi.demo.pager;

/**
 * 排序方式
 * @author JOHN
 *
 */
public enum SortDirection {
	ASC("asc"), DESC("desc");

	private String direction;

	private SortDirection(String direction) {
		this.direction = direction.toUpperCase();
	}

	public String getDirection() {
		return this.direction;
	}
}
