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
@WebServlet("/DeleteEmployee")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String userId=req.getParameter("id");
		int id=Integer.parseInt(userId);
		empDAO emp=new empDAO();
		int status = emp.deleteData(id);
		if(status>0)
		{
			res.getWriter().append("Record deleted sucessfully");
			req.getRequestDispatcher("ViewEmployee").include(req, res);
		}
		else
		{
			res.getWriter().append("Sorry! Unable to delete the record");
		}
		
	}

}
