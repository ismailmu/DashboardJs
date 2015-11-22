package com.btpns.dashboardjs.server.helpdesk;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btpns.dashboardjs.client.Filtering;
import com.btpns.dashboardjs.client.Sorting;
import com.btpns.dashboardjs.client.helpdesk.HelpdeskDaily;
import com.btpns.dashboardjs.shared.DateTimeUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class HelpdeskServlet
 */
public class HelpdeskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelpdeskServlet() {
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
		
    	HelpdeskDailyPersistence persistence = new HelpdeskDailyPersistence();
    	//String type=request.getParameter("type");
    	//String strDateFilter=request.getParameter("dateFilter");
    	
    	Date dateFilter=DateTimeUtil.getInstance().getDate(request.getParameter("dateFilter"));
		List<HelpdeskDailyModel> helpdesks = persistence.getHelpdeskDailyModel(offset, limit
				,dateFilter,sortings,filterings);
		HelpdeskDaily helpdeskDailyClient = new HelpdeskDaily(persistence.getSize(),helpdesks);
		out.write(gson.toJson(helpdeskDailyClient));
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
