package com.hanrabong.web.command;

import javax.servlet.http.HttpServletRequest;

import com.hanrabong.web.domains.EmpBean;
import com.hanrabong.web.seviceImpls.EmpServiceImpl;


public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		execute();
	}

	@Override
	public void execute() {
		EmpBean param = new EmpBean();
		param.setEmpNo(request.getParameter("empNo"));
		param.setEName(request.getParameter("eName"));
		param.setDeptNo(request.getParameter("deptNo"));
		String domain = "";
		if(EmpServiceImpl.getInstance().login(param)!=null) {
			domain = request
					.getServletPath()
					.substring(1, request.getServletPath()
							.indexOf("."));
			request.setAttribute("emp", EmpServiceImpl.getInstance().login(param));
			request.setAttribute("dept", EmpServiceImpl.getInstance().findDept());
			request.setAttribute("page", "myPage");
		}else {
			domain = "facade";
			request.setAttribute("page", "login");
		}
		setPage("main");
		setDomain(domain);	
		super.execute();
	}
}