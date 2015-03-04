package webapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import webapp.dao.DeptDao;
import webapp.model.Dept;
import webapp.model.Emp;

public class SpringjdbcDeptDao implements DeptDao{

	static Logger log = Logger.getLogger(SpringjdbcDeptDao.class);
	DataSource dataSource;
	
	@Override
	public Dept selectByDeptno(Integer deptno) {
		log.info("######SpringjdbcDeptDao#####");
		log.info("selectByDeptno( "+deptno+" )");
		log.info("############################");
		
		JdbcTemplate template = new JdbcTemplate(dataSource);

		Dept dept = template.queryForObject(SELECT_BY_DEPTNO, new BeanPropertyRowMapper<Dept>(Dept.class), deptno);
		log.info("$$$$$$dept selectbydeptno at springjdbc : "+dept);
		
		return dept;
	}

	class DeptResultSetExtractor implements ResultSetExtractor<Dept> {

		@Override
		public Dept extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			Dept dept = null;
			List<Emp> emps = null;
			Emp emp = null;
			while(rs.next()){
				if(dept == null){
					dept = new Dept();
					dept.setDeptno(rs.getInt("deptno"));
					dept.setDname(rs.getString("dname"));
					dept.setLoc(rs.getString("loc"));
					emps = new ArrayList<Emp>();
				}
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getFloat("sal"));
				emp.setComm(rs.getFloat("comm"));
				
				emps.add(emp);
			}
			if(dept != null)
				dept.setEmps(emps);
			
			return dept;
		}
		
	}
		
	@Override
	public Dept selectByDeptnoWithEmps(Integer deptno) {
		log.info("#########SpringjdbcDeptDao##########");
		log.info("selectByDeptnoWithEmps( "+deptno+" )");
		log.info("####################################");
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		DeptResultSetExtractor rse = new DeptResultSetExtractor();

		Dept dept = template.query(SELECT_BY_DEPTNO_WITH_EMPS, new Object[] {deptno}, rse);
		log.info("$$$$$$dept selectByDeptnoWithEmps at springjdbc : "+dept);
		
		return dept;
	}

	@Override
	public List<Dept> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> selectAllWithEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}


}
