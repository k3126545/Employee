package webapp.test;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import webapp.escape.Background;
import webapp.escape.Forground;
import webapp.escape.Screen;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DateTest {
	static Log log = LogFactory.getLog(DateTest.class);

	@Test
	public void test() {
		Date current = new Date();
		log.info(current.toLocaleString());
	}
	
	@Test
	public void test2() {
		Calendar current = Calendar.getInstance();
		log.info(current.getTime().toLocaleString());
	}

	@Test
	public void test3() {
		Date current = new Date();
		
		current.setDate(current.getDate()+80);
		log.info("year = "+(current.getYear()+1900));
		log.info("month = "+(current.getMonth()+1));
		log.info("date = "+current.getDate());
		log.info("week = "+current.getDay());
	}
	
	@Test
	public void test4() {
		Date date = new Date(2015-1900, 2-1, 1);
		log.info("start week = "+date.getDay());
		
		int month=date.getMonth();
		while(true){
			date.setDate(date.getDate()+1);
			if(month != date.getMonth())
				break;				
		}
		date.setDate(date.getDate()-1);
		log.info(date.toLocaleString());
	}
	
	@Test
	public void test5() {
		Date date = new Date(2015-1900, 5-1, 1);

		System.out.println(date.getMonth()+" 달력");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int month=date.getMonth();
		date.setDate(date.getDate());
		
		while(true){
			if(date.getDate() == 1){
				for(int i=0;i<date.getDay();i++)
					System.out.print("\t");
			}
			
			System.out.print(date.getDate());
			
			date.setDate(date.getDate()+1);
			System.out.print("\t");
			
			if(month != date.getMonth())
				break;
			if(date.getDay()==0)
				System.out.println();
			
		}
	}
	
	@Test
	public void test6() {
		Screen.clear();
		
		Scanner scan = new Scanner(System.in);
		
		while(true){
			Screen.cursorposition(5, 1);
			System.out.print("[yyyy/MM] : ");
			String param = scan.next();
			System.out.println(param);
			if(param.equals("."))
				break;
			
		}
		
		
		
		
		
		Screen.reset();
		
	}
}
