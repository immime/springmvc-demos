package com.qiqi.demo.pager;

import java.io.Serializable;
import java.util.List;

/**
 * 分页参数封装
 * 
 * @author JOHN
 *
 */
public class PagingCriteria implements Serializable {
	
	/**
	 * default serial version ID
	 */
	private static final long serialVersionUID = 1L;
	private Integer displayStart;
	private Integer displaySize;
	private List<SortField> sortFields;
	private SearchCondition searchCondition;
	private Integer pageNumber;
	
	public Integer getDisplayStart() {
		return displayStart;
	}
	public void setDisplayStart(Integer displayStart) {
		this.displayStart = displayStart;
	}
	public Integer getDisplaySize() {
		return displaySize;
	}
	public void setDisplaySize(Integer displaySize) {
		this.displaySize = displaySize;
	}
	public List<SortField> getSortFields() {
		return sortFields;
	}
	public void setSortFields(List<SortField> sortFields) {
		this.sortFields = sortFields;
	}
	public SearchCondition getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(SearchCondition searchCondition) {
		this.searchCondition = searchCondition;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

}
