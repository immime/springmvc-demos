package com.qiqi.demo.pojo;


public class Role extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * uuid
	 */
	private String id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 描述
	 */
	private String desc;
	/**
	 * 图标
	 */
	private String icon;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
