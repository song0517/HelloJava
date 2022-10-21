package co.tra;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainingDAO extends DAO {

	// 1. 관리자 테이블
	//id, pw 비교
	public List<Manager> magList(Manager mag) {
		List<Manager> magList = new ArrayList<Manager>();
		getConnect();
		String sql = "select * from manager where mag_id like ? and mag_pwd like ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mag.getMagId());
			psmt.setString(2, mag.getMagPw());

			rs = psmt.executeQuery();

			while (rs.next()) {
				magList.add(new Manager(rs.getString("mag_id"), rs.getString("mag_pwd"), rs.getString("mag_name")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return magList;
	}
	
	//전체조회
	public List<Manager> magSearch() {
		String sql = "select * from manager";
		conn = getConnect();
		List<Manager> list = new ArrayList<Manager>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				list.add(new Manager(rs.getString("mag_id"), rs.getString("mag_pwd"), rs.getString("mag_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 강사조회
	public Manager getMag(String magId) {
		String sql = "select * from manager where mag_id = ?";
		conn = getConnect();
		Manager mag = new Manager("", "", "");

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, magId);

			rs = psmt.executeQuery();

			if (rs.next()) {
				mag = new Manager(rs.getString("mag_id"), rs.getString("mag_pwd"), rs.getString("mag_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return mag;
	}

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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void magUpdate(String magId, String magId2) {
		String sql = "update manager set mag_id = ? where mag_id = ?";
		conn = getConnect();
		System.out.println(magId + " " + magId2);
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, magId2);
			psmt.setString(2, magId);

			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 관리자계정 삭제
	public int magDelete(String magId) {
		String sql = "delete from manager where mag_id = ?";
		conn = getConnect();

		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, magId);

			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return r;
	}

	// id변경
	public void idUpdate(Manager mag) {
		String sql = "update manager set mag_name = ? where mag_id = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mag.getMagName());
			psmt.setString(2, mag.getMagId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 강사 변경 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 2. 회원테이블
	// 전체학생 조회
	public List<Student> stuSearch(PagingVO pag) {
		conn = getConnect();
		List<Student> list = new ArrayList<Student>();
		String sql = "SELECT * \r\n" + "FROM (\r\n" + "SELECT ROWNUM RN, A.* \r\n" + "FROM (\r\n" + "SELECT * \r\n"
				+ "FROM student \r\n" + "ORDER BY stu_id \r\n" + ") A\r\n" + ")\r\n" + "WHERE RN BETWEEN ? AND ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pag.getStart());
			psmt.setInt(2, pag.getEnd());

			rs = psmt.executeQuery();

			while (rs.next()) {
				list.add(new Student(rs.getString("stu_id"), rs.getString("stu_pwd"), rs.getString("stu_name"),
						rs.getString("stu_Phone"), rs.getString("stu_Bir"), rs.getInt("tar_id"),
						rs.getString("tar_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 학생 수 가져오기
	public int countStu() {
		conn = getConnect();
		int cnt = 0;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) as cnt FROM student");

			while (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;

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
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}

	// 회원 조회
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
						rs.getString("stu_Phone"), rs.getString("stu_Bir"), rs.getInt("tar_id"),
						rs.getString("tar_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return stu;
	}

	// 과목별 수강생 조회
	public List<Student> traStu(int traId) {
		String sql = "select * from student where tar_id = ?";
		conn = getConnect();
		List<Student> list = new ArrayList<Student>();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, traId);

			rs = psmt.executeQuery();

			while (rs.next()) {
				list.add(new Student(rs.getString("stu_id"), rs.getString("stu_pwd"), rs.getString("stu_name"),
						rs.getString("stu_Phone"), rs.getString("stu_Bir"), rs.getInt("tar_id"),
						rs.getString("tar_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 회원수 증가
	public int pluCount(int traId) {
		String sql = "update training set tra_checkCo = tra_checkCo +1 where tra_id = ? and tra_stCo>tra_checkCo";
		conn = getConnect();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, traId);

			r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return r;
	}

	// 회원수 감소
	public int delCount(int traId1) {
		String sql = "update training set tra_checkCo = tra_checkCo - 1 where tra_id = ? and tra_checkCo>0";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, traId1);

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}

	// 회원 수강 등록 & 변경
	public int stuUpdate(Student stu) {
		String sql = "update student set tar_id = ?, tar_name = ? where stu_id = ?";
		conn = getConnect();
		int r = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, stu.getTraId());
			psmt.setString(2, stu.getTraName());
			psmt.setString(3, stu.getStuId());

			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return r;
	}

	// 회원 연락처 변경
	public void phoneUpdate(Student stu) {
		String sql = "update student set stu_Phone = ? where stu_id = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stu.getStuPhone());
			psmt.setString(2, stu.getStuId());

			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 회원 비밀번호 변경
	public void pwdUpdate(Student stu) {
		String sql = "update student set stu_pwd = ? where stu_id = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stu.getStuPw());
			psmt.setString(2, stu.getStuId());

			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 회원과목삭제
	public void stuDelete(int traId) {
		String sql = "update student set tar_id = null, tar_name = null where tar_id = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, traId);

			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 3. 과목 테이블
	// 전체 과목 조회
	public List<Training> traSearch() {
		conn = getConnect();
		List<Training> list = new ArrayList<Training>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from training order by tra_id");

			while (rs.next()) {
				list.add(new Training(rs.getInt("tra_id"), rs.getString("tra_name"), rs.getString("t_name"),
						rs.getString("tra_time"), rs.getString("tra_day"), rs.getInt("tra_stCo"),
						rs.getInt("tra_checkCo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 페이징 작업 사용
	public List<Training> traList(PagingVO pag) {
		conn = getConnect();
		List<Training> list = new ArrayList<Training>();
		String sql = "SELECT * \r\n" + "FROM (\r\n" + "SELECT ROWNUM RN, A.* \r\n" + "FROM (\r\n" + "SELECT * \r\n"
				+ "FROM training \r\n" + "ORDER BY tra_id \r\n" + ") A\r\n" + ")\r\n" + "WHERE RN BETWEEN ? AND ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pag.getStart());
			psmt.setInt(2, pag.getEnd());

			rs = psmt.executeQuery();

			while (rs.next()) {
				list.add(new Training(rs.getInt("tra_id"), rs.getString("tra_name"), rs.getString("t_name"),
						rs.getString("tra_time"), rs.getString("tra_day"), rs.getInt("tra_stCo"),
						rs.getInt("tra_checkCo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public int countTra() {
		conn = getConnect();
		int cnt = 0;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) as cnt FROM training");

			while (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;

	}

	// 과목 추가
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 과목이름 찾기
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

	// 강사 이름 변경
	public int tNameUpdate(Training tra) {
		String sql = "update training set t_name = ? where tra_id = ?";
		conn = getConnect();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, tra.gettName());
			psmt.setInt(2, tra.getTraId());

			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return r;
	}

	// 특정과목찾기
	public Training traNameSearch(int traId) {
		String sql = "select * from training where tra_id = ?";
		conn = getConnect();
		Training tra = new Training(0, "", "", "", "", 0, 0);

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, traId);

			rs = psmt.executeQuery();

			if (rs.next()) {
				tra = new Training(rs.getInt("tra_id"), rs.getString("tra_name"), rs.getString("t_name"),
						rs.getString("tra_time"), rs.getString("tra_day"), rs.getInt("tra_stCo"),
						rs.getInt("tra_checkCo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return tra;
	}

	// 과목삭제
	public int traDelete(int traId) {
		String sql = "delete from training where tra_id = ?";
		conn = getConnect();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, traId);

			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return r;
	}

	// 4. 댓글 테이블
	// 댓글 찾기
	public List<TraReply> reSearch(int traId) {
		String sql = "select * from trareply where tra_id = ?";
		conn = getConnect();
		List<TraReply> reList = new ArrayList<TraReply>();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, traId);

			rs = psmt.executeQuery();

			while (rs.next()) {
				TraReply tr = new TraReply(rs.getInt("tra_seq"), rs.getInt("tra_id"), rs.getString("re_content"),
						rs.getString("re_writer"), rs.getString("re_date"));
				reList.add(tr);
			}
			return reList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 자신이 작성한 댓글 보기
	public List<TraReply> reWrSearch(String reWriter) {
		String sql = "select * from trareply where re_writer = ?";
		conn = getConnect();
		List<TraReply> reList = new ArrayList<TraReply>();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, reWriter);

			rs = psmt.executeQuery();

			while (rs.next()) {
				TraReply tr = new TraReply(rs.getInt("tra_seq"), rs.getInt("tra_id"), rs.getString("re_content"),
						rs.getString("re_writer"), rs.getString("re_date"));
				reList.add(tr);
			}
			return reList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 댓글 입력
	public void reInsert(TraReply trr) {
		String sql = "insert into trareply values (treply_seq.nextval, ?, ?, ?, sysdate)";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, trr.getTraId());
			psmt.setString(2, trr.getReContent());
			psmt.setString(3, trr.getReWriter());

			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 댓글 수정
	public void trUpdate(TraReply trr) {
		String sql = "update trareply set re_content = ? where tra_seq = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, trr.getReContent());
			psmt.setInt(2, trr.getTraSeq());

			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 과목ID별 댓글 삭제
	public void trrDelete(int traId) {
		String sql = "delete from trareply where tra_id = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, traId);

			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 댓글 숫번 통해 댓글 삭제
	public void trSeDelete(int tra_seq) {
		String sql = "delete from trareply where tra_seq = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, tra_seq);

			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 5. 임시 비밀번호 테이블
	// 임시 비밀번호 추가
	public void insertPw(String pw) {
		String sql = "insert into pwcheck values (?)";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 임시 비밀번호 조회
	public String selPw(String pw) {
		String sql = "select * from pwcheck where pwnum = ?";
		conn = getConnect();
		String pwck = "";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);

			rs = psmt.executeQuery();
			
			while (rs.next()) {
				pwck = rs.getString("pwnum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return pwck;
	}
	
	// 임시 비밀번호 삭제
	public void delPw(String pw) {
		String sql = "delete from pwcheck where pwnum = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} 
	}

}