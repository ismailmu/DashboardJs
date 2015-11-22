package com.btpns.dashboardjs.server.menu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.btpns.dashboardjs.server.PersistenceService;

public class MenuPersistence extends PersistenceService {
	
	@SuppressWarnings("unchecked")
	public List<MenuModel> getMenuModel(String queryMenu) {
		EntityManager em = begin();

		Query query = em.createQuery(queryMenu, MenuModel.class);
		
		setSize(query.getResultList().size());
		
		List<MenuModel> menuModel = new ArrayList<MenuModel>();

		try {
			menuModel = query.getResultList();
			commit();
		}catch(Exception ex) {
			rollback();
			ex.printStackTrace();
		}finally {
			close();
		}
		
		return menuModel;
	}
}
