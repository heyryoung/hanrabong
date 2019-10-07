package com.hanrabong.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hanrabong.web.pool.Constants;


@WebServlet("/facade.do")
public class FacadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	enum Resources{
		CTX, CSS, JS, IMG
		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		for(Resources r : Resources.values()) {
			
			request.getSession().setAttribute(r.toString().toLowerCase(), 
					request.getContextPath() +
					(r.toString().toLowerCase().equals("ctx")?  
						 "" : "/resources/" + r.toString().toLowerCase())) ;
		}
		request.setAttribute("page",  
				(request.getParameter("action")!= null )? request.getParameter("page") : 
						"login");
		System.out.println(request.getAttribute("page"));
		request.getRequestDispatcher(String.format(Constants.DOUBLE_PATH,
				request.getServletPath().substring(1, 
						request.getServletPath().indexOf(".")), "main"))
				.forward(request, response);
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}


}