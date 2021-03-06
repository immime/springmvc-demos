package com.qiqi.demo.pager;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 排序方式，大小写不敏感</br>
 * ASC: 升序</br>
 * DESC: 降序
 * 
 * @author JOHN
 *
 */
public enum SortDirection {
	ASC, DESC;
	
	private static Map<String, SortDirection> namesMap = new HashMap<String, SortDirection>(2);

    static {
        namesMap.put("asc", ASC);
        namesMap.put("desc", DESC);
    }

    @JsonCreator
    public static SortDirection forValue(String value) {
        return namesMap.get(StringUtils.lowerCase(value));
    }

    @JsonValue
    public String toValue() {
        for (Entry<String, SortDirection> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }

        return null; // or fail
    }
}
