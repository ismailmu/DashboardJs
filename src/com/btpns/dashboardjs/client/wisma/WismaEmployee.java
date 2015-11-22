package com.btpns.dashboardjs.client.wisma;

import java.io.Serializable;
import java.util.List;

import com.btpns.dashboardjs.server.wisma.WismaEmployeeModel;

public class WismaEmployee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String totalCount="";
	private List<WismaEmployeeModel> wismaEmployees=null;
	
	public WismaEmployee(){}

	public WismaEmployee(String totalCount,
			List<WismaEmployeeModel> wismaEmployees) {
		super();
		this.totalCount = totalCount;
		this.wismaEmployees = wismaEmployees;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public List<WismaEmployeeModel> getWismaEmployees() {
		return wismaEmployees;
	}

	public void setWismaEmployees(List<WismaEmployeeModel> wismaEmployees) {
		this.wismaEmployees = wismaEmployees;
	}
}
