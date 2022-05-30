package com.bit.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.bit.emp.controller.*;
import java.util.*;

public class DispatcherServlet extends HttpServlet {
	
	Map<String, BitController> cmap = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		cmap.put("/index.bit", new IndexController());
		cmap.put("/emp/index.bit", new ListController());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);		
	}
	
	public void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dispatcher start");
		
		String url=req.getRequestURI().substring(req.getContextPath().length());
		
		BitController controller = null;
		controller = cmap.get(url);
		
		String viewName="";
		try {
			viewName = controller.execute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SimpleViewResolver resolver = new SimpleViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.viewResolver(viewName,req, resp);
	}
	
	
}
