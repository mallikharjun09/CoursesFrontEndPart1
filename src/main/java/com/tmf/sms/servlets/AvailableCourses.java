package com.tmf.sms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.tmf.SMS.course.model.Course;
import com.tmf.SMS.course.services.CourseServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AvailableCourses extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<head>");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		String para = "<p style='font-size:120%;padding:10px;color:white;background-color:red;text-align:right;'>"
				+ "Welcome Admin";
		para = para + "<a href='index.html' style='margin-left:10px;padding:5px;color:white;text-decoration:none;border:2px solid white;'>Logout</a>";
		para = para + "</p>";
		out.println(para);
		out.print("<h3 style='text-align:center;background-color:black;"
				+ "color:white'>Available Courses</h3>");
		
		CourseServiceImpl service = new CourseServiceImpl();
		List<Course> courses = service.displayCourse();
		
		out.println("<table class='table table-hover table-bordered table-striped'>");
		out.println("<thead class='bg-primary text-white'>");
		out.println("<tr>");
		out.println("<th>Course Id</th>");
		out.println("<th>Course Name</th>");
		//out.println("<th>Modules to be Covered</th>");
		//out.println("<th>Required Qualification</th>");
		out.println("<th>Course Duration</th>");
		out.println("<th></th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody class='table-primary'>");
		for(Course cs : courses) {
			out.println("<tr>");
			out.println("<td class='text-center'>"+cs.getCourseId()+"</td>");
			out.println("<td>"+cs.getCourseName()+"</td>");
			//out.println("<td>"+cs.getModulesToBeCovered()+"</td>");
			//out.println("<td>"+cs.getQualification()+"</td>");
			out.println("<td class='text-center'>"+cs.getDuration()+" Months</td>");
			//out.println("<td class='text-center'>"+cs.getFee()+"</td>");
			out.println("<td><a href='#' class='btn btn-info'>View</a> "
					+ "<a href='#' class='btn btn-warning'>Edit</a> "
					+ "<a href='#' class='btn btn-danger'>Delete</a>");
			out.println("</tr>");
		}
		out.println("<tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
	}
}








