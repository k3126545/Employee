package webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.DataSourceUtils;

import webapp.dao.DeptDao;
import webapp.model.Dept;
import webapp.model.Emp;
import webapp.util.GlobalVars;

public class MyDeptDao implements DeptDao{

//	static Logger log = Logger.getLogger(jdbcDeptDao.class);
	static Log log = LogFactory.getLog(MyDeptDao.class);
	
	DataSource dataSource;
	
	@Override
	public Dept selectByDeptno(Integer deptno) {
		log.info("########jdbcDeptDao#########");
		log.info("selectByDeptno( "+deptno+" )");
		log.info("############################");
//		Connection con = GlobalVars.con.get();
		
		Connection con = DataSourceUtils.getConnection(dataSource);
		
		Dept dept=null;
		try {
			PreparedStatement pstmt = con.prepareStatement(SELECT_BY_DEPTNO);
			pstmt.setInt(1, deptno);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			}
		} catch (SQLException e) {
			throw new DataRetrievalFailureException("fail", e);
		}
		if(dept == null)
			throw new EmptyResultDataAccessException("dept empty row", 1);
		
		return dept;
	}

	@Override
	public Dept selectByDeptnoWithEmps(Integer deptno) {
		log.info("###########jdbcDeptDao##############");
		log.info("selectByDeptnoWithEmps( "+deptno+" )");
		log.info("####################################");
		Connection con = DataSourceUtils.getConnection(dataSource);
		
		Dept dept=null;
		List<Emp> emps=null;
		try {
			PreparedStatement pstmt = con.prepareStatement(SELECT_BY_DEPTNO_WITH_EMPS);
			pstmt.setInt(1, deptno);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				if(dept==null){
					dept = new Dept();
					dept.setDeptno(rs.getInt("deptno"));
					dept.setDname(rs.getString("dname"));
					dept.setLoc(rs.getString("loc"));
					emps = new ArrayList<Emp>();
				}
				
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getFloat("sal"));
				emp.setComm(rs.getFloat("comm"));
				
				emps.add(emp);
			}
		} catch (SQLException e) {
			throw new DataRetrievalFailureException("fail...", e);
		}
		
		if(dept != null)
			dept.setEmps(emps);
		
		return dept;
	}

	@Override
	public List<Dept> selectAll() {
		log.info("###########");
		log.info("selectAll()");
		log.info("###########");
		
		Connection con = DataSourceUtils.getConnection(dataSource);
		
		Dept dept=null;
		List<Dept> list=null;
		try {
			PreparedStatement psmt = con.prepareStatement(SELECT_ALL);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()){
				if(list==null)
					list = new ArrayList<Dept>();
				
				dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(dept);
			}
			
		} catch (SQLException e) {
			throw new DataRetrievalFailureException("selectAll() fail", e);
		}
		
		return list;
	}

	@Override
	public List<Dept> selectAllWithEmps() {
		log.info("###################");
		log.info("selectAllWithEmps()");
		log.info("###################");
		
		Connection con = DataSourceUtils.getConnection(dataSource);
		List<Dept> list=null;
		List<Emp> emps=null;
		Dept dept = null;
		int index=0;
		try {
			PreparedStatement psmt = con.prepareStatement(SELECT_ALL_WITH_EMPS);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()){
				if(dept==null){
					dept = new Dept();
					dept.setDeptno(rs.getInt("deptno"));
					index = dept.getDeptno();
					dept.setDname(rs.getString("dname"));
					dept.setLoc(rs.getString("loc"));
					
					list = new ArrayList<Dept>();
					emps = new ArrayList<Emp>();
				}
				dept.setDeptno(rs.getInt("deptno"));
				
				if(index != dept.getDeptno().intValue())
				{
					dept.setDeptno(index);
					dept.setEmps(emps);
					list.add(dept);
					
					emps = new ArrayList<Emp>();
					
					dept = new Dept();
					dept.setDeptno(rs.getInt("deptno"));
					index = dept.getDeptno();
					dept.setDname(rs.getString("dname"));
					dept.setLoc(rs.getString("loc"));
				}
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getFloat("sal"));
				emp.setComm(rs.getFloat("comm"));
				
				emps.add(emp);
			}
			dept.setEmps(emps);
			list.add(dept);
			
		} catch (SQLException e) {
			throw new DataRetrievalFailureException("selectAllWithEmps() fail", e);
		}
		
		return list;
	}

	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}
	

}
