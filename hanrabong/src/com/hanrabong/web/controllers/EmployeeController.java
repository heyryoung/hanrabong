package com.hanrabong.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanrabong.web.command.Receiver;
import com.hanrabong.web.command.Sender;

@WebServlet("/emp.do")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

		
		Receiver.init(request);
		System.out.println(request.getParameter("page"));

		Sender.forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	 

}
