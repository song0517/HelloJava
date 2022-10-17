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
		String sql = "select * from student where stu_id = ?, stu_pwd = ?";
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
}
