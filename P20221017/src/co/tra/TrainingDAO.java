package co.tra;

import java.sql.SQLException;

public class TrainingDAO extends DAO {

	// 관리자 계정 추가
	public void magInsert(Manager mag) {
		String sql = "insert into manager values (?, ?, ?)";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mag.getMagId());
			psmt.setString(2, mag.getMagPw());
			psmt.setString(3, mag.getMagName());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 회원 계정 추가
	public void stuInsert(Student stu) {
		String sql = "insert into student(stu_id, stu_pwd, stu_name, stu_Phone, stu_Bir) values (?, ?, ?, ?, ?)";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stu.getStuId());
			psmt.setString(2, stu.getStuPw());
			psmt.setString(3, stu.getStuName());
			psmt.setString(4, stu.getStuPhone());
			psmt.setString(5, stu.getStuBir());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 관리자 계정 로그인 확인
	public int magCheck(String id, String pw) {
		String sql = "select * from manager where mag_id = ? and mag_pwd = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {
//				rs.getString("id");
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}

	// 회원 계정 로그인 확인
	public int stuCheck(String id, String pw) {
		String sql = "select * from student where stu_id = ? and stu_pwd = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {
//				rs.getString("id");
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}
	
	//과목 추가
	public void tarInsert(Training tra) {
		String sql = "insert into training(tra_id, tra_name, t_name, tra_time, tra_day, tra_stCo)  values (?, ?, ?, ?, ?, ?)";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, tra.getTraId());
			psmt.setString(2, tra.getTraName());
			psmt.setString(3, tra.gettName());
			psmt.setString(4, tra.getTraTime());
			psmt.setString(5, tra.getTraDay());
			psmt.setInt(6, tra.getStCo());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//과목이름 찾기
	public String traNameCheck(int traId) {
		String sql = "select * from training where tra_id = ?";
		conn = getConnect();
		String name = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, traId);

			rs = psmt.executeQuery();

			if (rs.next()) {
				name = rs.getString("tra_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return name;
	}
	
	//회원수 증가
	public int pluCount(int traId) {
		String sql = "update training set tra_checkCo = tra_checkCo +1 where tra_id = ? and tra_stCo>tra_checkCo";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, traId);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 완료");
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}
	
	//회원수 감소
	public int delCount(int traId1) {
		String sql = "update training set tra_checkCo = tra_checkCo - 1 where tra_id = ? and tra_checkCo>0";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, traId1);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 회원 삭제완료");
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}
	
	
	//회원 수강 등록 & 변경
	public void stuUpdate(Student stu) {
		String sql = "update student set tar_id = ?, tar_name = ? where stu_id = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, stu.getTraId());
			psmt.setString(2, stu.getTraName());
			psmt.setString(3, stu.getStuId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 학생 수강 등록 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//강사 이름 변경
	public void tNameUpdate(Training tra) {
		String sql = "update training set t_name = ? where tra_id = ?";
		conn = getConnect();
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, tra.gettName());
			psmt.setInt(2, tra.getTraId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 강사 변경 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//회원 조회
	public Student getStu(String stuId) {
		String sql = "select * from student where stu_id = ?";
		conn = getConnect();
		Student stu = new Student("", "", "", "", "", 0, "");

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stuId);

			rs = psmt.executeQuery();

			if (rs.next()) {
				stu = new Student(rs.getString("stu_id"), rs.getString("stu_pwd"), rs.getString("stu_name"),
						rs.getString("stu_Phone"), rs.getString("stu_Bir"), rs.getInt("tar_id"), rs.getString("tar_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return stu;
	}
}
