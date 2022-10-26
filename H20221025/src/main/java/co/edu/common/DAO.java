package co.edu.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//패키지가 다를 경우 public 선언
public class DAO {
	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
	public PreparedStatement psmt;

	
	public Connection getConnect() {
		try {
			//20221026(gitignore사용)
			Properties prop = new Properties();
			prop.load(new FileReader("src/main/java/co/edu/database.properties"));
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String id = prop.getProperty("user");
			String pass = prop.getProperty("passwd");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.10:1521:xe", "sje", "sje");
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pass);
			
			System.out.println("연결성공");
		} catch (Exception e) {
			System.out.println("연결실패");
		}

		return conn;
	}

	public void disconnect() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
