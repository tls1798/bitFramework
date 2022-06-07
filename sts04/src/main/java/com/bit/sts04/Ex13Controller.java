package com.bit.sts04;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

@Controller
public class Ex13Controller {

   @RequestMapping("/ex13")
   public void ex13(HttpServletResponse res) {}

   @RequestMapping("/ex14")
   public View ex() {
      View view = new View() {

         @Override
         public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
               throws Exception {
            response.setContentType(getContentType());
            PrintWriter out = response.getWriter();
            out.print("<html>");
            out.print("<head><meta charset=\"utf-8\"></head>");
            out.print("<h1>�䰴ü�� ���� ������</h1>");
            out.print("</html>");
            out.close();
         }

         @Override
         public String getContentType() {
            return "text/html; charset=UTF-8";
         }

      };

      return view;
   }

   @RequestMapping("/ex15")
   public String ex15(Model model) {
      model.addAttribute("msg", "�𵨰�ü�� ������ �޽���");
      return "ex01";
   }
}