package com.tmf.sms.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Validate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
			throws ServletException, IOException {
			String uname = req.getParameter("emailId");
			String pwd = req.getParameter("pass");
			//Create a request Dispatcher object...
			RequestDispatcher dispatcher = null;
			PrintWriter out = resp.getWriter();
			if(uname.equals("admin@sms.com") && pwd.equals("admin@sms123")) {
				//resp.getWriter().print("Admin is validated");
				dispatcher = req.getRequestDispatcher("allCourses");
				dispatcher.forward(req, resp);
			}
			else {
				dispatcher = req.getRequestDispatcher("index.html");
				dispatcher.include(req, resp);
				String para = "<p style='font-size:120%;padding:10px;color:red;'>"
						+ "Sorry!... Inavlid Credentials";
				para = para + "</p>";
				out.println(para);
				
			}
		
	}
}
