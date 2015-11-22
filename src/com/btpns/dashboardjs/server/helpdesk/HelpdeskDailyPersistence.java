package com.btpns.dashboardjs.server.helpdesk;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.btpns.dashboardjs.client.Filtering;
import com.btpns.dashboardjs.client.Sorting;
import com.btpns.dashboardjs.server.PersistenceService;

public class HelpdeskDailyPersistence extends PersistenceService {
	
	
	@SuppressWarnings("unchecked")
	public List<HelpdeskDailyModel> getHelpdeskDailyModel(int offset,
			int limit, Date dateFilter,List<Sorting> sortings,List<Filtering> filterings) {
		EntityManager em = begin();

		StringBuilder sbQuery = new StringBuilder();
		sbQuery.append("from HelpdeskDailyModel e where e.tgl = :dateFilter");

		StringBuilder sbOrder = new StringBuilder();
		if (sortings!=null) {
			sbOrder.append(getOrders(sortings));
		}
		sbOrder.trimToSize();
		
		StringBuilder sbFilter = new StringBuilder();
		if (filterings!=null) {
			sbFilter.append(getFilters(filterings,false));
		}
		sbFilter.trimToSize();
		
		sbQuery.append(sbFilter.toString() + sbOrder.toString());
		
		Query query = null;
		
		query = em.createQuery(sbQuery.toString(), HelpdeskDailyModel.class);
		// filter date
		query.setParameter("dateFilter", dateFilter);
		
		
		setSize(query.getResultList().size());
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		List<HelpdeskDailyModel> helpdeskDailyModel = new ArrayList<HelpdeskDailyModel>();

		try {
			helpdeskDailyModel = query.getResultList();
			commit();
		}catch(Exception ex) {
			rollback();
			ex.printStackTrace();
		}finally {
			close();
		}
		
		return helpdeskDailyModel;
	}
}
