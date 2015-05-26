package com.qiqi.demo.datatables;

import com.qiqi.demo.pager.PagingCriteria;
import com.qiqi.demo.pager.EntityResultSet;
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
			PagingCriteria pc, EntityResultSet<T> rs) {
		return new DataTablesResultSet<T>(pc, rs);
	}
	
}
