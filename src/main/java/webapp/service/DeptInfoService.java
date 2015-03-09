package webapp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import webapp.dao.DeptDao;
import webapp.exception.ConnectionFailException;
import webapp.exception.DeptAccessException;
import webapp.exception.DeptNotFoundException;
import webapp.model.Dept;
import webapp.util.EmployeeDataSource;
import webapp.util.GlobalVars;

public class DeptInfoService {
	DeptDao deptdao;
//	Properties prop;
	DataSource dataSource;
	
	public void setDeptDao(DeptDao dao) {
		deptdao = dao;
	}
	
//	public void setProperties(Properties prop) {
//		this.prop = prop;
//	}
	
	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}
	
	public Dept getDeptInfo(Integer deptno) {
		
		// All or Nothing 
//		DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource);
//		TransactionStatus status=null;
//		try {
//			status = tm.getTransaction(null);
//		} catch (TransactionException e) {
//			throw new ConnectionFailException("Transaction begin fail",e);
//		}	
		
		Dept dept = deptdao.selectByDeptno(deptno);
//			tm.rollback(status);
		
//			tm.rollback(status);
		
//			tm.commit(status);
		
		return dept;
	}
	
	public Dept getDeptInfoWithEmps(Integer deptno) {
		
//		DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource);
//		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
//		definition.setReadOnly(true);
//		
//		TransactionStatus status = tm.getTransaction(definition);
		
		Dept dept = deptdao.selectByDeptnoWithEmps(deptno);
		
//		tm.commit(status);
		
		return dept;
	}
	
	public List<Dept> getDeptInfoAll() {
		
		List<Dept> list = deptdao.selectAll();
		
		return list;
	}
	
	public List<Dept> getDeptInfoAllWithEmps() {
		
		List<Dept> list = deptdao.selectAllWithEmps();
		
		return list;		
	}
	
}
