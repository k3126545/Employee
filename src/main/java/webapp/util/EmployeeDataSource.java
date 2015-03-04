package webapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeDataSource extends AdapterDataSource{
	//AdapterDataSource 메소드 하나만 사용할건데 너무번잡하니까 익스텐즈해서 번잡함을 없애자
	
	String className;
	String url;
	String user;
	String password;
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return getConnection(user, password);
	}
	
	@Override
	public Connection getConnection(String user, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			Class.forName(className);
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException("connection fail",e);//좀더 견고하게 처리해준거임.
		}
		
		return con;
	}

}
