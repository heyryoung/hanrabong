package com.hanrabong.web.daoImpls;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hanrabong.web.daos.EmpDao;
import com.hanrabong.web.domains.DeptBean;
import com.hanrabong.web.domains.EmpBean;
import com.hanrabong.web.factory.DatabaseFactory;
import com.hanrabong.web.pool.Constants;

public class EmpDaoImpl implements EmpDao{
	
	private static EmpDaoImpl instance = new EmpDaoImpl();
	private  EmpDaoImpl() {}
	public static EmpDaoImpl getInstance() {return instance;}
	

	@Override
	public EmpBean login(EmpBean eb) {
		
		EmpBean result = new EmpBean();
		
		try {
			String sql = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO ,(select Dname from dept where deptno  like e.deptno) dName  FROM EMP E WHERE DEPTNO LIKE '"+eb.getDeptNo()+"' AND EMPNO LIKE '"+eb.getEmpNo()+"' AND ENAME LIKE '"+eb.getEName()+"' ";
			System.out.println(eb.getDeptNo()+ "<<<<<<<<<<<<<<<<<<<<<");
			ResultSet rs =  DatabaseFactory
					.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql)
					.executeQuery();
			System.out.println(sql +">>>>>>>login _ sql");
			
			while (rs.next()) {
				result.setEmpNo(rs.getString(1));
				result.setEName(rs.getString(2));
				result.setJob(rs.getString(3));
				result.setMgr(rs.getString(4));
				result.setHireDate(rs.getString(5));
				result.setSal(rs.getString(6));
				result.setComm(rs.getString(7));
				result.setDeptNo(rs.getString(8));
				result.setDName(rs.getString(9));
				System.out.println(result.toString());
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
		
	}

	@Override
	public Boolean insetEmp(EmpBean eb) {
		Boolean rs =false;
		String sql = "INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)\r\n" + 
				"VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = DatabaseFactory
					.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql);
			pstmt.setString(1, eb.getEmpNo());
			pstmt.setString(2, eb.getEName());
			pstmt.setString(3, eb.getJob());
			pstmt.setString(4, eb.getMgr());
			pstmt.setString(5, eb.getHireDate());
			pstmt.setString(6, eb.getSal());
			pstmt.setString(7, eb.getComm());
			pstmt.setString(8, eb.getDeptNo());
			int rsCnt = pstmt.executeUpdate();
			System.out.println(sql +">>>>>>>insetEmp _ sql");
			if (rsCnt == 1) {
				rs = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<DeptBean> selectDept() {
		
		List<DeptBean> result = new ArrayList<DeptBean>();
		
		try {
			String sql = "SELECT DEPTNO, DNAME, LOC FROM DEPT";
			ResultSet rs =  DatabaseFactory
					.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql)
					.executeQuery();
			System.out.println(sql +">>>>>>>login _ sql");
			
			while (rs.next()) {
				DeptBean temp = new DeptBean();
				temp.setDeptNo(rs.getString(1));
				temp.setDName(rs.getString(2));
				temp.setLoc(rs.getString(3));
				System.out.println(temp.toString());
				result.add(temp);

				
				
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
		
	}

	@Override
	public List<EmpBean> selectEmps() {
		return null;
	}

	@Override
	public EmpBean selectEmp(EmpBean eb) {
		return null;
	}

}
