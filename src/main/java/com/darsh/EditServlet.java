package com.darsh;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/EditEmployee")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//res.getWriter().append("Served at: ").append(req.getContextPath());
		res.setContentType("text/html");
		String userId=req.getParameter("empid");
		int id=Integer.parseInt(userId);
		empDAO emp=new empDAO();
		employee e=emp.getEmployee(id);  
		PrintWriter out=res.getWriter();
		
		out.write("<form action=\"EditEmployee2\" method=\"post\""
				+ "<table border='1' width='100%'>"
				+ "<tr><td>ID</td><td><input type=\"text\" name=\"id\" value=\""+e.getId()+"\"></td></tr>"
				+ "<tr><td>Name</td><td><input type=\"text\" name=\"name\" value=\""+e.getName()+"\"></td></tr>"
				+ "<tr><td>Password</td><td><input type=\"password\" name=\"pwd\" value=\""+e.getPassword()+"\"></td></tr>"
				+ "<tr><td>email</td><td><input type=\"email\" name=\"email\"  value=\""+e.getEmail()+"\"></td></tr>"
				+ "<tr><td>Country</td><td>"
				+ "<select name=\"country\" style=\"width:150px\">"
				+ "<option>India</option>"
				+ "<option>USA</option>"
				+ "<option>Australia</option>"
				+ "<option>Japan</option>"
				+ "</select>"
				+ "</td></tr>"
				+ "</table>"
				+ "<tr><td><input type=\"submit\" value=\"Edit and Save\"></td></tr>"
				+ "</form>");
		
		
		
	}

}
