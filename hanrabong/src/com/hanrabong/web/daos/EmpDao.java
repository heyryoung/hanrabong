package com.hanrabong.web.daos;

import java.util.List;

import com.hanrabong.web.domains.DeptBean;
import com.hanrabong.web.domains.EmpBean;


public interface EmpDao {

	public EmpBean login(EmpBean eb);
	public Boolean insetEmp(EmpBean eb);

	public List<DeptBean> selectDept();	
	public List<EmpBean> selectEmps();	
	public EmpBean selectEmp(EmpBean eb);	
	
	
	
}
