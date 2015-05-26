package com.qiqi.demo.pager;

/**
 * 封装DataTable的查询参数
 * 
 * @author wenyong
 *
 */
public class DataTableRequest {
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

}
