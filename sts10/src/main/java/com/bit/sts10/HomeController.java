package com.bit.sts10;

import java.io.*;
import java.text.DateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class HomeController {
	String upPath = "C:/framework/sts10/src/upload/";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartFile file, HttpServletRequest req) throws IllegalStateException, IOException {
		String filename = System.currentTimeMillis()+"_"+file.getOriginalFilename();
		file.transferTo(new File(upPath+filename));
		req.setAttribute("origin", file.getOriginalFilename());
		req.setAttribute("filename", filename);
		return "down";
	}
	
//	<a href="down/origin">
	@RequestMapping(value = "/down/{filename:.+}", method = RequestMethod.GET)
	public void down1(HttpServletResponse res, @PathVariable String filename) {
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment; filename=\""+filename.substring(filename.indexOf('_')+1)+"\"");
		try(
			InputStream is = new FileInputStream(upPath+filename);
			OutputStream os = res.getOutputStream();
		){
			int su=-1;
			while((su=is.read())!=-1) {
				os.write(su);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
