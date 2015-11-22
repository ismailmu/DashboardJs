package com.btpns.dashboardjs.server.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btpns.dashboardjs.client.menu.GroupMenu;
import com.btpns.dashboardjs.client.menu.Menu;
import com.google.gson.Gson;

/**
 * Servlet implementation class MenuServlet
 */
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
    }
    
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.setContentType("application/json");
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	
    	MenuPersistence persistence = new MenuPersistence();
    	
    	String query = "from MenuModel e WHERE e.parentMenu is null ORDER BY e.ordinalPosition";
    	List<MenuModel> parentMenus = persistence.getMenuModel(query);
    	//String output="";
    	
    	if (parentMenus !=null) {
    		List<GroupMenu> groupMenus = new ArrayList<GroupMenu>();
    		
    		for (MenuModel parentMenuModel : parentMenus) {
    			GroupMenu groupMenu = new GroupMenu(parentMenuModel.getXtype()
    					,parentMenuModel.getText(),parentMenuModel.getIconCls(),parentMenuModel.getAction());
    			
        		query = "from MenuModel e WHERE e.parentMenu = " + parentMenuModel.getId() + " ORDER BY e.ordinalPosition";
        		List<MenuModel> childMenus = persistence.getMenuModel(query);
        		
        		List<Menu> menus = new ArrayList<Menu>();
        		if (childMenus.size()>0) {
	    			for (MenuModel childMenuModel : childMenus) {
	    				menus.add(new Menu(childMenuModel.getId(),childMenuModel.getXtype(),childMenuModel.getText()
	        					,childMenuModel.getIconCls(),childMenuModel.getAction()));
	    			}
	    			groupMenu.setMenu(menus);
        		}else {
        			menus=null;
        		}
        		groupMenus.add(groupMenu);
    		}
    		out.write(gson.toJson(groupMenus));    		
    	}else {
    		out.write("null");
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

}
