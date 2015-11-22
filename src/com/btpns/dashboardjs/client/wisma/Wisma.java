package com.btpns.dashboardjs.client.wisma;

import java.io.Serializable;
import java.util.List;

import com.btpns.dashboardjs.server.wisma.WismaModel;

public class Wisma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalCount=0;
	private List<WismaModel> wismas=null;
	
	public Wisma(){}

	public Wisma(int totalCount, List<WismaModel> wismas) {
		super();
		this.totalCount = totalCount;
		this.wismas = wismas;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<WismaModel> getWismas() {
		return wismas;
	}

	public void setWismas(List<WismaModel> wismas) {
		this.wismas = wismas;
	}
}
