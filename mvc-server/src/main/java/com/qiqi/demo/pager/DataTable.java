package com.qiqi.demo.pager;

import java.util.List;

/**
 * 封装dataTable
 * 
 * @author wenyong
 *
 */
public class DataTable<T> {
	/**
	 * 记录操作的次数 每次加1
	 */
	private int sEcho;
	/**
	 * 起始
	 */
	private int iDisplayStart;
	/**
	 * 搜索的关键字
	 */
	private String sSearch;
	/**
	 * 查询出来的数量
	 */
	private int iTotalDisplayRecords;
	/**
	 * 结果集
	 */
	private List<T> aaData;
	
	public DataTable() {
		super();
	}
	
	public DataTable(DataTableRequest dtReq) {
		super();
		sEcho = dtReq.getSEcho();
		iDisplayStart = dtReq.getIDisplayStart();
		iTotalDisplayRecords = dtReq.getITotalDisplayRecords();
	}

	public int getSEcho() {
		return sEcho;
	}

	public void setSEcho(int sEcho) {
		this.sEcho = sEcho;
	}

	public int getIDisplayStart() {
		return iDisplayStart;
	}

	public void setIDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public String getSSearch() {
		return sSearch;
	}

	public void setSSearch(String sSearch) {
		this.sSearch = sSearch;
	}

	public int getITotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setITotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public List<T> getAaData() {
		return aaData;
	}

	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}

}
