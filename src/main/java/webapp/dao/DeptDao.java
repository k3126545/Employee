package webapp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import webapp.model.Dept;

public interface DeptDao {
	
	final static String SELECT_BY_DEPTNO = "select * from dept where deptno = ?";
	final static String SELECT_BY_DEPTNO_WITH_EMPS = 
			"select * from dept d left join emp e on d.deptno=e.deptno where d.deptno=?";
	final static String SELECT_ALL = "select * from dept";
	
//	final static String SELECT_ALL_WITH_EMPS = "select * from dept d left join emp e on d.deptno=e.deptno";
	final static String SELECT_ALL_WITH_EMPS = 
			"select  d.deptno as deptno, "+
			"d.dname  as dname, "+
			"d.loc    as loc, "+
			"e.empno  as empno, "+
			"e.ename  as ename, "+
			"e.job    as job, "+
			"e.mgr    as mgr, "+
			"e.hiredate as hiredate, "+
			"e.sal    as sal, "+
			"e.comm   as comm "+
			"from dept d left join emp e "+
			"on d.deptno=e.deptno "+
			"order by d.deptno asc";
	
	public void setDataSource(DataSource ds);
	/*
	 * Single row by primary key
	 */
	public Dept selectByDeptno(Integer deptno);//deptno를 갖고 dept를가져오는놈
	public Dept selectByDeptnoWithEmps(Integer deptno);

	/*
	 * Multiple row
	 */
	public List<Dept> selectAll();//dept전체를조회하는//emp가없는놈
	public List<Dept> selectAllWithEmps();//emp를가지고있는 전체를조회하는//emp까지몽땅다 담고있는놈
	
	//이것들을 구현해야하겟지 클래스를 만들자

}
