package com.qiqi.demo.pager;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 查询条件逻辑操作符，大小写不敏感</br>
 * AND: 逻辑与</br>
 * OR: 逻辑或
 * @author wenyong
 *
 */
public enum SearchOperator {
	AND, OR;
	
	private static Map<String, SearchOperator> namesMap = new HashMap<String, SearchOperator>(2);

    static {
        namesMap.put("and", AND);
        namesMap.put("or", OR);
    }

    @JsonCreator
    public static SearchOperator forValue(String value) {
        return namesMap.get(StringUtils.lowerCase(value));
    }

    @JsonValue
    public String toValue() {
        for (Entry<String, SearchOperator> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }

        return null; // or fail
    }
}
