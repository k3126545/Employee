package webapp.test;

import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

import webapp.escape.Screen;

public class CalendarTest {

	public static void printCalendar(int year, int month) {
		Date date = new Date(year-1900, month-1, 1);

		System.out.println(year+"年 "+(date.getMonth()+1)+"月 달력");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int month1=date.getMonth();
		date.setDate(date.getDate());
		
		while(true){
			if(date.getDate() == 1){
				for(int i=0;i<date.getDay();i++)
					System.out.print("\t");
			}
			
			System.out.print(date.getDate());
			
			date.setDate(date.getDate()+1);
			System.out.print("\t");
			
			if(month1 != date.getMonth())
				break;
			if(date.getDay()==0)
				System.out.println();
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		while(true){
			
			boolean flag=true;
			String param="";
			do{
				if(flag==false) System.out.println("[yyyy/MM]형으로 다시 입력하세요");
				flag = true;
				System.out.print("[yyyy/MM] : ");
				param = scan.nextLine();
				System.out.println(param);
				
//				flag = param.matches("[1-9][0-9][0-9][0-9]/[0-9][0-9]");
				flag = param.matches("[1-9][0-9]{3}/[0-9]{2}");
				
			} while(!flag);
			
			StringTokenizer tokens = new StringTokenizer(param, "/");
			
			printCalendar(Integer.parseInt((String)tokens.nextElement()),Integer.parseInt((String)tokens.nextElement()));
		}
		
	}

}
