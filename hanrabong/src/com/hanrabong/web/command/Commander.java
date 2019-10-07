package com.hanrabong.web.command;


import javax.servlet.http.HttpServletRequest;

import com.hanrabong.web.enums.Action;

public class Commander {
	
	public static Command direct(HttpServletRequest request) {
		Command c = new Command();
		System.out.println(request.getParameter("action>>>>>>>>>>>Command"));
		switch (Action.valueOf(request
				.getParameter("action")
				.toUpperCase())) {
		case LOGIN: c = new LoginCommand(request);break;
		case JOIN: c = new JoinCommand(request);break;
		default:
			break;
		}
		return c;
	}
}
