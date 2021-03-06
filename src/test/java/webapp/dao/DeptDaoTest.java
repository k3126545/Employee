package webapp.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webapp.dao.DeptDao;
import webapp.model.Dept;
import webapp.model.Emp;

@RunWith(SpringJUnit4ClassRunner.class)		//factory를 만들어줌
@ContextConfiguration("classpath:/webapp/spring/beans.xml")
public class DeptDaoTest {
	
	static Logger log = Logger.getLogger(DeptDaoTest.class);
	
	@Autowired
	ApplicationContext factory;

	@Test
	public void test1_SelectByDeptno() throws SQLException {
		log.info("Start selectByDeptno");
		DeptDao dao = factory.getBean(DeptDao.class);
		
		Dept dept = dao.selectByDeptno(10);
		assertNotNull(dept);
		
		log.info("##### "+dept.getDeptno()+ " "+dept.getDname()+" "+dept.getLoc());
		
	}
	
	@Test
	public void test2_SelectByDeptnoWithEmps() throws SQLException {
		log.info("Start selectByDeptnoWithEmps");
		DeptDao dao = factory.getBean(DeptDao.class);
		
		Dept dept = dao.selectByDeptnoWithEmps(10);
		assertNotNull(dept);
		
		log.info("##### "+dept.getDeptno()+ " "+dept.getDname()+" "+dept.getLoc());
		
	}
	
	@Test
	public void test3_SelectAll() {
		log.info("Start SelectAll");
		DeptDao dao = factory.getBean(DeptDao.class);
		
		List<Dept> list = dao.selectAll();
		assertNotNull(list);
		
		for(Dept d : list){
			log.info("deptno : "+d.getDeptno());
			log.info("dname : "+d.getDname());
			log.info("loc : "+d.getLoc());
		}
	}
	
	@Test
	public void test4_selectAllWithEmps() {
		log.info("Start selectAllWithEmps");
		DeptDao dao = factory.getBean(DeptDao.class);
		
		List<Dept> list = dao.selectAllWithEmps();
		assertNotNull(list);
		for(Dept d : list){
			
			log.info(d.getDeptno()+" "+d.getDname()+" "+d.getLoc());
			
			for(Emp e :d.getEmps())
				log.info(e.getEmpno()+" "+e.getEname()+" "+e.getJob());
		}
		
	}

}
