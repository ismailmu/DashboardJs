package com.btpns.dashboardjs.client.menu;

import java.io.Serializable;
import java.util.List;

public class GroupMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String xtype;
	private String text;
	private String iconCls;
	private String action;
	
	private List<Menu> menu;
	
	public GroupMenu(){}

	public GroupMenu(String xtype, String text, String iconCls,
			String action) {
		super();
		this.xtype = xtype;
		this.text = text;
		this.iconCls = iconCls;
		this.action = action;
	}
	
	public GroupMenu(String xtype, String text, String iconCls,
			String action, List<Menu> menu) {
		super();
		this.xtype = xtype;
		this.text = text;
		this.iconCls = iconCls;
		this.action = action;
		this.menu = menu;
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

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
}
