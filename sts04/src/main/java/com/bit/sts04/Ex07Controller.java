package com.bit.sts04;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex07Controller {
	@RequestMapping("/ex07")
	public String ex07(HttpSession session) {
		System.out.println(session.getId());
		return "ex01";
	}
}
