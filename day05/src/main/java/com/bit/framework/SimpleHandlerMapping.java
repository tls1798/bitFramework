package com.bit.framework;

import java.io.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SimpleHandlerMapping implements BitHandlerMapping {
	Map<String, BitController> cmap = new HashMap<>();
	
	String path;
	
	public Map<String, BitController> getMapping(){
		return cmap;
	}
	
	public void setPath(String path) {
		this.path = path;
		mapping();
	}
	
	public Map<String, BitController> mapping(){
		
		Map<String, String> handler = new HashMap<>();
		File file=new File(path);
		
		Properties prop=new Properties();
		InputStream is = null;
		
		try {
			is = new FileInputStream(file);
			prop.load(is);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
				try {
					if(is!=null) is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		Enumeration eles = prop.keys();
		while(eles.hasMoreElements()) {
			String key = (String)eles.nextElement();
			handler.put(key,prop.getProperty(key));
		}
				
		Set<String> keys = handler.keySet();
		try {
			for(String key : keys)
				cmap.put(key, (BitController)(Class.forName(handler.get(key)).newInstance()));
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cmap;
	}
	
}
