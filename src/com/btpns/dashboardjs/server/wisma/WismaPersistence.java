package com.btpns.dashboardjs.server.wisma;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.btpns.dashboardjs.client.Filtering;
import com.btpns.dashboardjs.client.Sorting;
import com.btpns.dashboardjs.server.PersistenceService;

public class WismaPersistence extends PersistenceService {
	
	@SuppressWarnings("unchecked")
	public List<WismaModel> getWismaModel(int offset,
			int limit, List<Sorting> sortings,List<Filtering> filterings) {
		EntityManager em = begin();

		StringBuilder sbQuery = new StringBuilder();
		sbQuery.append("from WismaModel e");

		StringBuilder sbFilter = new StringBuilder();
		if (filterings!=null) {
			sbFilter.append(getFilters(filterings,true));
		}
		sbFilter.trimToSize();
		
		StringBuilder sbOrder = new StringBuilder();
		if (sortings!=null) {
			sbOrder.append(getOrders(sortings));
		}
		sbOrder.trimToSize();
		
		sbQuery.append(sbFilter.toString() + sbOrder.toString());
		Query query = null;
		

		query = em.createQuery(sbQuery.toString(), WismaModel.class);
		
		setSize(query.getResultList().size());
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		List<WismaModel> wismaModel = new ArrayList<WismaModel>();
		wismaModel = query.getResultList();

		try {
			wismaModel = query.getResultList();
			commit();
		}catch(Exception ex) {
			rollback();
			ex.printStackTrace();
		}finally {
			close();
		}
		
		return wismaModel;
	}
	
	@SuppressWarnings("unchecked")
	public List<WismaEmployeeModel> getWismaEmployeeModel(int offset,
			int limit, String wismaFilter,List<Sorting> sortings,List<Filtering> filterings) {
		EntityManager em = begin();

		StringBuilder sbQuery = new StringBuilder();
		sbQuery.append("from WismaEmployeeModel e where e.wisma = '"+wismaFilter +"'");

		StringBuilder sbFilter = new StringBuilder();
		if (filterings !=null) {
			sbFilter.append(getFilters(filterings, false));
		}
		
		sbFilter.trimToSize();

		StringBuilder sbOrder = new StringBuilder();
		if (sortings == null) {
			sbOrder.append(" ORDER BY e.ordinalPosition");
		}else {
			sbOrder.append(getOrders(sortings));
		}
		
		Query query = null;
		sbQuery.append(sbFilter);
		sbQuery.append(sbOrder);
		
		query = em.createQuery(sbQuery.toString(), WismaEmployeeModel.class);
		
		setSize(query.getResultList().size());
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		List<WismaEmployeeModel> wismaEmployeeModel = new ArrayList<WismaEmployeeModel>();
		wismaEmployeeModel = query.getResultList();

		try {
			wismaEmployeeModel = query.getResultList();
			commit();
		}catch(Exception ex) {
			rollback();
			ex.printStackTrace();
		}finally {
			close();
		}
		
		return wismaEmployeeModel;
	}
}
