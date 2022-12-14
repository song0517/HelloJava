package co.edu.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//20221012
//DB연결 Connection 생성. -> DAO 부모클래스 상속해서 실행.
public class DAO {
	// 객체 생성
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;

	// Connection 객체 반환해주는 getConnect메소드 생성
	public Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			System.out.println("연결성공");
		} catch (Exception e) {
			System.out.println("연결실패");
		}

		return conn;
	}

	// Resource를 해지하는 disconnect 메소드 생성
	public void disconnect() {
		try {
			//값이 할당된 경우에만 close 실행
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
