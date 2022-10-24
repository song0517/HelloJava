package co.edu.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//20221019
//DAO - 데이터베이스처리하는 클래스
public class EmpDAO extends DAO {

	// 입력
	// 방금 부여받은 시퀀스 받기
	public EmployeeVO insertEmp(EmployeeVO vo) {
		getConnect();

		String seq = "select employees_seq.nextval from dual";

		String sql = "insert into empl(employee_id, first_name, last_name, email, hire_date, job_id) values (?,?,?,?,?,?)";

		try {
			// seqence 가져오기 위한 쿼리 실행
			int seqInt = 0;
			psmt = conn.prepareStatement(seq);
			rs = psmt.executeQuery();
			if (rs.next()) {
				// 1번째 컬럼을 가지고 오겠다.
				seqInt = rs.getInt(1);
			}

			// insert작업.
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seqInt);
			psmt.setString(2, vo.getFirstName());
			psmt.setString(3, vo.getLastName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getHireDate());
			psmt.setString(6, vo.getJobId());

			// 쿼리 실행 -> 처리된 건수 리턴
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력 완료!");

			// 새롭게 입력하게된 사원번호 부여, 매개값으로 들어온 아이한테 부여
			vo.setEmployeeId(seqInt);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 까먹지 말자아아......반환
			disconnect();
		}
		return vo;
	}

	// 삭제
	public void deleteEmp(int employeeId) {
		getConnect();
		String sql = "delete from empl where employee_id = ?"; // id기준으로 한건 삭제
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, employeeId);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제 완료!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정
	public void updateEmp(EmployeeVO vo) {
		getConnect();
		String sql = "update empl set first_name = ?, last_name =?, email =?, hire_date = ?, job_id = ? where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			psmt.setInt(6, vo.getEmployeeId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정 완료!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 목록
//	public List<EmployeeVO> empList(EmployeeVO vo) {
//		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
//		getConnect();
//		String sql = "select * from empl " //
//				+ "where employee_id = decode(?, 0, employee_id, ?) " //
//				+ "and first_name like '%'||?||'%' " //
//				+ "and last_name like '%'||?||'%' " //
//				+ "and email like '%'||?||'%' " + "and to_char(hire_date, 'yyyy-mm-dd') like '%'||?||'%' " //
//				+ "and job_id = nvl(?, job_id) " //
//				+ "order by employee_id";
//
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, vo.getEmployeeId());
//			psmt.setInt(2, vo.getEmployeeId());
//			psmt.setString(3, vo.getFirstName());
//			psmt.setString(4, vo.getLastName());
//			psmt.setString(5, vo.getEmail());
//			psmt.setString(6, vo.getHireDate());
//			psmt.setString(7, vo.getJobId());
//
//			rs = psmt.executeQuery();
//
//			while (rs.next()) {
//				int empId = rs.getInt("employee_id");
//				String fName = rs.getString("first_name");
//				String lName = rs.getString("last_name");
//				String email = rs.getString("email");
//				String hDate = rs.getString("hire_date");
//				String jobId = rs.getString("job_id");
//				EmployeeVO emp = new EmployeeVO(empId, fName, lName, email, hDate, jobId);
//				empList.add(emp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return empList;
//	}
	
	public List<EmployeeVO> empList(EmployeeVO vo) {
		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		getConnect();
		String sql = "select * from empl " //
				+ "where nvl(employee_id, 0) = decode(?, 0, nvl(employee_id, 0), ?) " //
				+ "and first_name like '%'||?||'%' " //
				+ "and last_name like '%'||?||'%' " //
				+ "and email like '%'||?||'%' " + "and to_char(hire_date, 'yyyy-mm-dd') like '%'||?||'%' " //
				+ "and job_id = nvl(?, job_id) " //
				+ "order by employee_id";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getEmployeeId());
			psmt.setInt(2, vo.getEmployeeId());
			psmt.setString(3, vo.getFirstName());
			psmt.setString(4, vo.getLastName());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getHireDate());
			psmt.setString(7, vo.getJobId());

			rs = psmt.executeQuery();

			while (rs.next()) {
				int empId = rs.getInt("employee_id");
				String fName = rs.getString("first_name");
				String lName = rs.getString("last_name");
				String email = rs.getString("email");
				String hDate = rs.getString("hire_date");
				String jobId = rs.getString("job_id");
				EmployeeVO emp = new EmployeeVO(empId, fName, lName, email, hDate, jobId);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return empList;
	}
}
