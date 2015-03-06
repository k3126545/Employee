package webapp.model;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptTest {

	static Log log = LogFactory.getLog(DeptTest.class);
	
	@Test
	public void test1_String() {
		String s1 = new String("aa");
		String s2 = new String("aa");
		String s3 = "aa";
		String s4 = "aa";
		
		log.info("s1 == s2 : "+(s1==s2));
		log.info("s1.equals(s2) : "+s1.equals(s2));
		
		log.info("s3 == s4 : "+(s3==s4));
		log.info("s3.equals(s4) : "+s3.equals(s4));
		
		log.info("s1 == s3 : "+(s1==s3));
		log.info("s1.equals(s3) : "+s1.equals(s3));
	}
	
	@Test
	public void test2_Dept() {
		Dept d1 = new Dept(100, "xxx", null);
		Dept d2 = new Dept(100, "xxx", null);
		
		log.info("d1 == d2 : "+(d1==d2));
		log.info("d1.equals(d2) : "+d1.equals(d2));
	}
	
	@Test
	public void test3_Dept() {
		Dept d1 = new Dept(100, "xxx", null);
		Dept d2 = new Dept(100, "xxx", null);
		
		assertEquals(d1, d2);
	}
	
	@Test
	public void test4_Dept() {
		Dept d1 = new Dept(100, null, null);
		Dept d2 = new Dept(100, "xxx", null);
		
		assertNotEquals(d1, d2);
	}

}
