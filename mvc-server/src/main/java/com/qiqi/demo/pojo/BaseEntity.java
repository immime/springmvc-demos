package com.qiqi.demo.pojo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// 统一的toString()方法
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public BaseEntity() {
		super();
	}
}
