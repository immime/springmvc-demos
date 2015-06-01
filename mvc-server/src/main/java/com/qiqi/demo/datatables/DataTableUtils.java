package com.qiqi.demo.datatables;

import com.qiqi.demo.pager.PagingCriteria;
import com.qiqi.demo.pager.PageResultSet;
import com.qiqi.demo.pager.WebResultSet;

/**
 * datatables工具类
 * @author JOHN
 *
 */
public class DataTableUtils {
	
	/**
	 * 可分页结果集转化为controller返回个客户端的结果集</br>
	 * 这里返回DataTablesResultSet
	 * @param pc
	 * @param rs
	 * @return
	 */
	public static <T> WebResultSet<T> getWebResultSet(
			PagingCriteria pc, PageResultSet<T> rs) {
		return new DataTablesResultSet<T>(pc, rs);
	}

	/**
	 * 将datatables查询参数转换为通用的分页查询参数
	 * @param table
	 * @return
	 */
	public static PagingCriteria parseReqParameter(DataTablesCriteria table) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
