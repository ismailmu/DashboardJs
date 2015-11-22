package com.btpns.dashboardjs.client;

import java.io.Serializable;

public class Filtering implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String value;
	private String field;
	
	public Filtering(String type, String value, String field) {
		super();
		this.type = type;
		this.value = value;
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}
