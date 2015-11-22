package com.btpns.dashboardjs.server;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import com.btpns.dashboardjs.client.Filtering;
import com.btpns.dashboardjs.client.Sorting;

public abstract class PersistenceService {
	public static final ThreadLocal<EntityManager> MANAGERS = new ThreadLocal<EntityManager>();

	private ReentrantLock lock = new ReentrantLock();
	private Integer size = 0;
	//private Date dateFilter;

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

//	public Date getDateFilter() {
//		return dateFilter;
//	}
//
//	public void setDateFilter(Date dateFilter) {
//		this.dateFilter = dateFilter;
//	}

	public static EntityManager getEntityManager() {
		EntityManager mgr = MANAGERS.get();
		// if manager is null assume we are not running in a web context
		if (mgr == null) {
			mgr = EMF.get().createEntityManager();
			MANAGERS.set(mgr);
			return mgr;
		}
		return MANAGERS.get();
	}

	public static CriteriaBuilder getCriteriaBuilder() {
		return EMF.get().getCriteriaBuilder();
	}

	protected EntityManager begin() {
		try {
			lock.lock();
			EntityManager em = getEntityManager();
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			return em;
		} finally {
			lock.unlock();
		}
	}

	protected void commit() {
		try {
			lock.lock();
			EntityManager em = getEntityManager();
			em.getTransaction().commit();
		} finally {
			lock.unlock();
		}
	}

	protected void rollback() {
		try {
			lock.lock();
			EntityManager em = getEntityManager();
			em.getTransaction().rollback();
		} finally {
			lock.unlock();
		}
	}

	protected void close() {
		try {
			EntityManager em = MANAGERS.get();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				em.close();
			}
			//jikalau di 10.2.72.34 masih keluar JDBC failed
			//coba buka remark MANAGERS.set(null)
			//dibuka tgl 1-03-2013
			MANAGERS.set(null);
		} finally {
		}
	}
	
	protected String getOrders(List<Sorting> sortings) {
		StringBuilder sbOrder = new StringBuilder();
		for (int i=0;i<sortings.size();i++) {
			Sorting sorting = sortings.get(i);
			if (i==0) {
				sbOrder.append(" ORDER BY");
			}else {
				sbOrder.append(",");
			}
			sbOrder.append(" e." + sorting.getProperty() + " " + sorting.getDirection());
		}
		return sbOrder.toString();
	}
	
	protected String getFilters(List<Filtering> filterings,boolean isFirst) {
		StringBuilder sbFilter = new StringBuilder();
		for(int i=0;i<filterings.size();i++) {
			Filtering filtering = filterings.get(i);
			if (i==0 && isFirst) {
				sbFilter.append(" WHERE");
			}else {
				sbFilter.append(" AND");
			}
			sbFilter.append(" e." + filtering.getField() + " LIKE '%" + filtering.getValue() + "%'");
		}
		return sbFilter.toString();
	}

//	public void closeEmf() {
//		try {
//			close();
//			MANAGERS.set(null);
//			if (EMF.get() != null) EMF.get().close();
//		} finally {
//
//		}
//
//	}
}