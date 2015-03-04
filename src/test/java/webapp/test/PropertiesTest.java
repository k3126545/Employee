package webapp.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties dbprop = new Properties();//파일리더를직접쓰지않고 얘를써줌
		
//		FileInputStream inStream = new FileInputStream("db.properties");
		//테스트니까 그냥 쓰로우
		
		InputStream inStream = PropertiesTest.class.getResourceAsStream("/webapp/resource/db.properties");//getResourceAsStream:클래스패스상에있는 properties가져오는방법중 하나
		
		dbprop.load(inStream);
		
		String className = dbprop.getProperty("oracle.className");
		String url = dbprop.getProperty("oracle.url");
		String user = dbprop.getProperty("oracle.user");
		String password = dbprop.getProperty("oracle.password");
		
		System.out.println("clasName = "+className);
		System.out.println("url = "+url);
		System.out.println("user = "+user);
		System.out.println("password = "+password);

	}

}
