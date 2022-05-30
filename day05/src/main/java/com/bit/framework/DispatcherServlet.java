package com.bit.framework;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.util.*;

public class DispatcherServlet extends HttpServlet {
	private BitViewResolver resolver;
	private BitHandlerMapping handler;
	
	@Override
	public void init() throws ServletException {
		String bit = getInitParameter("bit");
		if(bit==null) bit="/WEB-INF/bit.properties";
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(getServletContext().getRealPath(bit)));
			
			SimpleHandlerMapping handler = (SimpleHandlerMapping) Class.forName(prop.getProperty("handlerMapping")).newInstance();
			handler.setPath(getServletContext().getRealPath("./")+"WEB-INF\\classes\\mapping.properties");
			this.handler=handler;
			
			SimpleViewResolver resolver = (SimpleViewResolver) Class.forName(prop.getProperty("viewResolver")).newInstance();
			resolver.setPrefix("/WEB-INF/views/");
			resolver.setSuffix(".jsp");
			this.resolver=resolver;
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		String url=req.getRequestURI().substring(req.getContextPath().length());
		
		BitController controller = null;
		controller = handler.getMapping().get(url);
		
		String viewName="";
		try {
			viewName = controller.execute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resolver.viewResolver(viewName,req, resp);		
		
		
	}
	
	
}
