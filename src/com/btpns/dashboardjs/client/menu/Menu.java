package com.btpns.dashboardjs.client.menu;

import java.io.Serializable;


public class Menu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String xtype;
	private String text;
	private String iconCls;
	private String action;
	
	public Menu(){}
	
	
	public Menu(int id, String xtype, String text, String iconCls, String action) {
		super();
		this.id = id;
		this.xtype = xtype;
		this.text = text;
		this.iconCls = iconCls;
		this.action = action;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getXtype() {
		return xtype;
	}
	public void setXtype(String xtype) {
		this.xtype = xtype;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
}
