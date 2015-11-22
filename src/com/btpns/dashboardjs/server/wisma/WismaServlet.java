package com.btpns.dashboardjs.server.wisma;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btpns.dashboardjs.client.Filtering;
import com.btpns.dashboardjs.client.Sorting;
import com.btpns.dashboardjs.client.wisma.Wisma;
import com.btpns.dashboardjs.client.wisma.WismaEmployee;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class WismaServlet
 */
public class WismaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WismaServlet() {
        super();
    }
    
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

    	response.setContentType("application/json");
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	
    	Type filterType = new TypeToken<List<Filtering>>(){}.getType();
    	List<Filtering> filterings = gson.fromJson(request.getParameter("filter"),filterType);
    	
    	Type sortingType = new TypeToken<List<Sorting>>(){}.getType();
    	List<Sorting> sortings = gson.fromJson(request.getParameter("sort"),sortingType);
    	
    	int offset=Integer.parseInt(request.getParameter("start"));
		int limit=Integer.parseInt(request.getParameter("limit"));
		
    	WismaPersistence persistence = new WismaPersistence();
    	String type=request.getParameter("type");
    	if (type.equalsIgnoreCase("list")) {
    		
    		List<WismaModel> wismas = persistence.getWismaModel(offset, limit, sortings,filterings);
    		Wisma wismaClient = new Wisma(persistence.getSize(),wismas);
    		out.write(gson.toJson(wismaClient));
    	}
    	
    	if (type.equalsIgnoreCase("employee")) {
//    		java.util.Enumeration enumeration = request.getParameterNames();
//    		while (enumeration.hasMoreElements()) {
//    		    String parameterName = (String) enumeration.nextElement();
//    		    System.out.println("Parameter name = " + parameterName + ", value = " 
//    		    + request.getParameter(parameterName));
//    		}
    		String wismaFilter = request.getParameter("wisma");
    		List<WismaEmployeeModel> employees=persistence.getWismaEmployeeModel(offset, limit
    				, ((wismaFilter==null)?"undefined":wismaFilter), sortings, filterings);
    		WismaEmployee employeeClient = new WismaEmployee(persistence.getSize().toString(), employees);
    		out.write(gson.toJson(employeeClient));
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
