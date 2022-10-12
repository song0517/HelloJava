package co.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//20221012
public class EmpDAO {
	public static void main(String[] args) {
		delete();
	}

	public static void update() {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			// statement에 실행한 쿼리 넣어주기. sql쿼리
			stmt = conn.createStatement();
			// 입력, 삭제, 수정일 경우 등 업데이트 구문을 사용하고 싶을 경우 -> executeUpdate사용
			// 처리된 건수 리턴
			int r = stmt.executeUpdate("update empl set first_name = 'messi' where employee_id=500");
			System.out.println(r + "건 수정됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			// statement에 실행한 쿼리 넣어주기. sql쿼리
			stmt = conn.createStatement();
			// 입력, 삭제, 수정일 경우 등 업데이트 구문을 사용하고 싶을 경우 -> executeUpdate사용
			// 처리된 건수 리턴
			int r = stmt.executeUpdate("delete from empl where employee_id=550");
			System.out.println(r + "건 삭제됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
//				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void search() {
		// jdbc driver로드
		// finally안에 있는 내용을 실행하기 위해 try 밖에 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 오라클조성url, 사용자계정, pw
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			// 커넥션을 통해 실행쿼리문을 전송, 결과 받아오도록하는 객체.
			stmt = conn.createStatement();
			// 실행할 쿼리를 가져온 후 ResultSet이라고 하는 Set클래스에 담아두겠다., 조회(select) 할 경우에는 executeQuery
			// 사용
			rs = stmt.executeQuery("select * from empl order by employee_id");

			// Set 컬렉션
			while (rs.next()) {
				System.out.println("사원번호: " + rs.getInt("employee_id"));
				System.out.println("이름: " + rs.getString("first_name"));
				System.out.println("급여: " + rs.getInt("salary"));
				System.out.println("====================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외 발생, 정상처리가 되어도 반드시 실행
			// close를 하지 않을 경우 접속이 안될 수 있기 때문에 사용한 후 무조건 close해줘야되낟.
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}
}
