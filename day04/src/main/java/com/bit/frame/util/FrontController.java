package com.bit.frame.util;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.bit.frame.controller.*;

public class FrontController extends HttpServlet{
	
	String prefix, suffix;
	
	Map<String, MyController> handlerMapping = new HashMap<>();

	@Override
	public void init() throws ServletException {
		prefix="/WEB-INF/views/";
		suffix=".jsp";
		
		Map<String, String> mapping = new HashMap<>();
//		Enumeration<String> names = getInitParameterNames();
//		while(names.hasMoreElements()) {
//			String url=names.nextElement();
//			mapping.put(url,getInitParameter(url));
//		}
		mapping.put("/index.bit","com.bit.frame.controller.IndexController");
		mapping.put("/list.bit","com.bit.frame.controller.ListController");
		mapping.put("/login.bit","com.bit.frame.controller.LoginController");
		mapping.put("/add.bit","com.bit.frame.controller.AddController");
		mapping.put("/delete.bit","com.bit.frame.controller.DeleteController");
		mapping.put("/detail.bit","com.bit.frame.controller.DetailController");
		
		Set<String> keys = mapping.keySet();
		
		try {
			for(String key: keys)
				handlerMapping.put(key,(MyController)(Class.forName(mapping.get(key))).newInstance());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	
	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().substring(req.getContextPath().length());
		String path="";
		
		MyController controller =handlerMapping.get(url);;
		if(controller==null) {
			resp.sendError(404);
			return;
		}
		
		path=controller.execute(req, resp);
		if(path.startsWith("redirect:")) resp.sendRedirect(path.substring("redirect:".length()));
		else {
			path=prefix+path+suffix;
			
			RequestDispatcher rd = req.getRequestDispatcher(path);
			rd.forward(req, resp);			
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
	
}
