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
	private final Integer sEcho;
	private final Long iTotalRecords;
	private final Long iTotalDisplayRecords;
	private final List<T> aaData;

	public DataTablesResultSet(PagingCriteria pc, EntityResultSet<T> rs) {
		this.sEcho = pc.getPageNumber();
		this.aaData = rs.getRows();
		this.iTotalRecords = rs.getTotalRecords();
		this.iTotalDisplayRecords = rs.getTotalRecords();
	}

	public Integer getsEcho() {
		return sEcho;
	}

	public Long getiTotalRecords() {
		return iTotalRecords;
	}

	public Long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public List<T> getAaData() {
		return Collections.unmodifiableList(aaData);
	}
}
