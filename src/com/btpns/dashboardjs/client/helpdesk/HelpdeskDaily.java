package com.btpns.dashboardjs.client.helpdesk;

import java.io.Serializable;
import java.util.List;

import com.btpns.dashboardjs.server.helpdesk.HelpdeskDailyModel;

public class HelpdeskDaily implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalCount=0;
	private List<HelpdeskDailyModel> helpdesks=null;
	
	public HelpdeskDaily(){}

	public HelpdeskDaily(int totalCount, List<HelpdeskDailyModel> helpdesks) {
		super();
		this.totalCount = totalCount;
		this.helpdesks = helpdesks;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<HelpdeskDailyModel> getHelpdesks() {
		return helpdesks;
	}

	public void setHelpdesks(List<HelpdeskDailyModel> helpdesks) {
		this.helpdesks = helpdesks;
	}
}
