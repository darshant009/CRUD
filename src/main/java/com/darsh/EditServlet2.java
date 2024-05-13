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
@WebServlet("/EditEmployee2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		employee e= new employee(req.getParameter("name"),req.getParameter("pwd"),req.getParameter("email"),req.getParameter("country"));
		String userId=req.getParameter("id");
		int id=Integer.parseInt(userId);
		e.setId(id);
		empDAO emp=new empDAO();
		int status = emp.updateData(e);
		if(status>0)
		{
			res.getWriter().append("Record updated sucessfully");
			req.getRequestDispatcher("index.html").include(req, res);
		}
		else
		{
			res.getWriter().append("Sorry! Unable to update the record");
		}
		
	}

}
