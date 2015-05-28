package com.qiqi.demo.datatables;

import java.util.Collections;
import java.util.List;

import com.qiqi.demo.pager.PagingCriteria;
import com.qiqi.demo.pager.EntityResultSet;
import com.qiqi.demo.pager.WebResultSet;

/**
 * 返回适应datatable的结果集
 * @author JOHN
 *
 * @param <T>
 */
public class DataTablesResultSet<T> implements WebResultSet<T> {
	private final Integer draw;
	private final Long recordsTotal;
	private final Long recordsFiltered;
	private final List<T> data;

	public DataTablesResultSet(PagingCriteria pc, EntityResultSet<T> rs) {
		this.draw = 0; // TODO draw from client ?....
		this.data = rs.getRows();
		this.recordsTotal = rs.getTotalRecords();
		this.recordsFiltered = rs.getTotalDisplayRecords();
	}

	public Integer getsEcho() {
		return draw;
	}

	public Long getiTotalRecords() {
		return recordsTotal;
	}

	public Long getiTotalDisplayRecords() {
		return recordsFiltered;
	}

	public List<T> getAaData() {
		return Collections.unmodifiableList(data);
	}
}
