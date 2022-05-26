package com.bit.dat02;

import javax.servlet.http.HttpServlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.startup.Tomcat;

import com.bit.controller.Ex01Controller;

public class MyTomcat {

	public static void main(String[] args) {
		Tomcat serve = new Tomcat();
		serve.setPort(8080);
		try {
			
			Context cont = serve.addContext("/","C:\\framework\\day02\\src\\main\\webapp");
//			serve.addWebapp("/","C:\\framework\\day02\\src\\main\\webapp" );
			serve.addServlet(cont, "/ex01", (HttpServlet)Class.forName("com.bit.controller.Ex01Controller").newInstance());
			cont.addServletMapping("/ex01", "/ex01");
			
			serve.start();
			Server server = serve.getServer();
			server.await();
			
		} catch(LifecycleException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
