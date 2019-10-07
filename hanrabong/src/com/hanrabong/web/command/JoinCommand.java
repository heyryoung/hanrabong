package com.hanrabong.web.command;

import javax.servlet.http.HttpServletRequest;

import com.hanrabong.web.domains.EmpBean;
import com.hanrabong.web.seviceImpls.EmpServiceImpl;

public class JoinCommand extends Command {
	public JoinCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		execute();
	}
	
	@Override
	public void execute() {
		EmpBean param = new EmpBean();
		System.out.println(">>>>>>>>>>>>>>>JoinCommand");
		param.setEmpNo(request.getParameter("empNo"));
		param.setComm(request.getParameter("comm"));
		param.setDName(request.getParameter("dName"));
		param.setDeptNo(request.getParameter("deptNo"));
		param.setJob(request.getParameter("job"));
		param.setMgr(request.getParameter("mgr"));
		param.setHireDate(request.getParameter("hireDate"));
		param.setSal(request.getParameter("sal"));
		param.setEName(request.getParameter("eName"));
		EmpServiceImpl.getInstance().join(param);
		setPage("main");
		setDomain("facade");
		request.setAttribute("page", "login");
		super.execute();
	}
}
