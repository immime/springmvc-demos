package com.qiqi.demo.pager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * 结果集
 * @author JOHN
 *
 * @param <T>
 */
public final class EntityResultSet<T> {
	private List<T> rows;
	private Long totalDisplayRecords;
	private Long totalRecords;

	public EntityResultSet() {
	}
	
	public EntityResultSet(List<T> rows, Long totalRecords, Long totalDisplayRecords) {
		this.rows = rows;
		this.totalRecords = totalRecords;
		this.totalDisplayRecords = totalDisplayRecords;
	}

	public List<T> getRows() {
		if(CollectionUtils.isNotEmpty(rows)) {
			return Collections.unmodifiableList(rows);
		}
		return new ArrayList<T>();
	}

	public Long getTotalDisplayRecords() {
		return totalDisplayRecords != null ? totalDisplayRecords : 0;
	}

	public Long getTotalRecords() {
		return totalRecords != null ? totalRecords : 0;
	}
}
