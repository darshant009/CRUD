package com.darsh;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewEmployee")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//res.getWriter().append("Served at: ").append(req.getContextPath());
		res.setContentType("text/html");  
		PrintWriter out=res.getWriter();
		empDAO emp = new empDAO();
		List<employee> emp1=emp.getAllEmployees();
		
		out.write("<a href=\"index.html\"> Add a Employee </a><br>"
				+ "<h1>Employee Details</h1><br>"
				+ "<table border='1' width='100%'>"
				+ "<tr><th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
				for(employee e1:emp1) {
				out.write(
				"<tr><td>"+e1.getId()+"</td>"
				+ "<td>"+e1.getName()+"</td>"
				+ "<td>"+e1.getPassword()+"</td>"
				+ "<td>"+e1.getEmail()+"</td>"
				+ "<td>"+e1.getCountry()+"</td>"
				+ "<td><a href=\"EditEmployee?empid="+e1.getId()+"\">Edit</a></td>"
				+ "<td><a href=\"DeleteEmployee?id="+e1.getId()+"\">Delete</a></td></tr>");
				}
				out.write("</table>");
	
	}
}
