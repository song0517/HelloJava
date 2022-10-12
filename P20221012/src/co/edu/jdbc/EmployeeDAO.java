package co.edu.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//20221012
public class EmployeeDAO extends DAO {
	//삭제
	public boolean delete(int empId) {
		String sql = "delete from empl where employee_id = ?";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			
			int r = psmt.executeUpdate();
			if(r > 0)
				return true;
			
//			System.out.println(r + "건 삭제됨.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
	// 수정
	public void update(Employee emp) {
		//\r\n이 없을 경우 공백이 하나있어야 된다.
		// ?는 지금 말고 나중에 값을 채워주겠다는 의미
		String sql = "update empl "
				+ "set email = ?, "
				+ "    hire_date = ?, "
				+ "    job_id = ? "
				+ "where employee_id = ?";
		conn = getConnect();
		try {
			//객체를 만들때 sql사용
			psmt = conn.prepareStatement(sql);
			// ? 위치에 따라 설정
			psmt.setString(1, emp.getEmail());
			psmt.setString(2, emp.getHireDate());
			psmt.setString(3, emp.getJobId());
			psmt.setInt(4, emp.getEmployeeId());
			
			int r = psmt.executeUpdate();
//			System.out.println(r + "건 변경됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 입력
	public void insert(Employee emp) {
//		System.out.println(emp);
		// String타입 get은 ' '표시
		String sql = "insert into empl (employee_id, last_name, email, hire_date, job_id)\r\n" + "values("
				+ emp.getEmployeeId() + ", '" + emp.getLastName() + "', '" + emp.getEmail() + "', '" + emp.getHireDate()
				+ "', '" + emp.getJobId() + "')";
		System.out.println(sql);
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 조회
	public List<Employee> search() {
		// 커넥션 객체에 연결
		conn = getConnect();
		// 반환하기 위한 값.
		List<Employee> list = new ArrayList<Employee>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from empl");
			//쿼리 결과를 rs에 담았다. -> next()는 읽어들일 값이 있는지 확인, 한줄 읽어들이기
			while (rs.next()) {
				// 값을 읽어와서 각각의 컬럼의 값을 읽어들어서 Employee 인스턴스에 저장
				list.add(new Employee(rs.getInt("employee_id"), rs.getString("last_name"), rs.getString("email"),
						rs.getString("hire_date"), rs.getString("job_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}
	
	public Employee getEmp(int empId) {
		//한건만 반환.
		String sql = "select * from empl where employee_id = ?";
		conn = getConnect();
		Employee emp = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				emp = new Employee(rs.getInt("employee_id"), rs.getString("last_name"), rs.getString("email"),
						rs.getString("hire_date"), rs.getString("job_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emp;
	}
}
