package com.btpns.dashboardjs.server.menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.btpns.dashboardjs.server.IModelPersistence;

@Entity
@Table(name="menu")
public class MenuModel implements IModelPersistence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	private String xtype;
	private String text;
	private String iconCls;
	@Column(name="parent_menu",nullable=true)
	private Integer parentMenu;
	@Column(name="ordinal_position")
	private int ordinalPosition;
	private String action;
	
	public MenuModel(){}

	public MenuModel(int id, String xtype, String text, String iconCls,
			int parentMenu, int ordinalPosition, String action) {
		super();
		this.id = id;
		this.xtype = xtype;
		this.text = text;
		this.iconCls = iconCls;
		this.parentMenu = parentMenu;
		this.ordinalPosition = ordinalPosition;
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

	public int getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(int parentMenu) {
		this.parentMenu = parentMenu;
	}

	public int getOrdinalPosition() {
		return ordinalPosition;
	}

	public void setOrdinalPosition(int ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}
