package com.qiqi.demo.pager;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 查询匹配类型，大小写不敏感
 * @author wenyong
 *
 */
public enum SearchType {
	
	/**
	 * 完全匹配
	 */
	EQUALS, 
	/**
	 * 模糊匹配
	 */
	LIKE;

	private static Map<String, SearchType> namesMap = new HashMap<String, SearchType>(
			2);

	static {
		namesMap.put("equals", EQUALS);
		namesMap.put("like", LIKE);
	}

	@JsonCreator
	public static SearchType forValue(String value) {
		return namesMap.get(StringUtils.lowerCase(value));
	}

	@JsonValue
	public String toValue() {
		for (Entry<String, SearchType> entry : namesMap.entrySet()) {
			if (entry.getValue() == this)
				return entry.getKey();
		}

		return null; // or fail
	}
}
