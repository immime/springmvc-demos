package com.qiqi.demo.pager;

import java.util.Collections;
import java.util.List;

/**
 * 结果集
 * @author JOHN
 *
 * @param <T>
 */
public final class EntityResultSet<T> {
	private final List<T> rows;
	private final Long totalDisplayRecords;
	private final Long totalRecords;

	public EntityResultSet(List<T> rows, Long totalRecords, Long totalDisplayRecords) {
		this.rows = rows;
		this.totalRecords = totalRecords;
		this.totalDisplayRecords = totalDisplayRecords;
	}

	public List<T> getRows() {
		return Collections.unmodifiableList(rows);
	}

	public Long getTotalDisplayRecords() {
		return totalDisplayRecords;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}
}
