package com.darsh;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ViewServlet
 */
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//res.getWriter().append("Served at: ").append(req.getContextPath());
		res.setContentType("text/html");
		employee e= new employee(req.getParameter("name"),req.getParameter("pwd"),req.getParameter("email"),req.getParameter("country"));
		empDAO emp=new empDAO();
		int status = emp.writeData(e);
		if(status>0)
		{
			res.getWriter().append("Record created sucessfully");
			req.getRequestDispatcher("index.html").include(req, res);
		}
		else
		{
			res.getWriter().append("Sorry! Unable to save the record");
		}
		
	}

}
