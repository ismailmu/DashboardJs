package com.btpns.dashboardjs.client;

import java.io.Serializable;

public class Sorting implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String property;
	private String direction;
	
	
	public Sorting(String property, String direction) {
		super();
		this.property = property;
		this.direction = direction;
	}


	public String getProperty() {
		return property;
	}


	public void setProperty(String property) {
		this.property = property;
	}


	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}
}
