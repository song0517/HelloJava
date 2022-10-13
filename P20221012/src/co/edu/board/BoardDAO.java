package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//221012
//CRUD기능 구현
public class BoardDAO extends DAO {
	// 로그인 확인
	public int check(String id, String pw) {
		String sql = "select * from users where id = ? and passwd = ?";
		conn = getConnect();
		boolean ch = true;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {
				rs.getString("id");
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}

	// 글등록
	public void insert(Board boa) {
		String sql = "insert into board(board_num, board_title, board_content, board_writer) " + "values("
				+ boa.getbNum() + ", '" + boa.getbTitle() + "', '" + boa.getbContent() + "', '" + boa.getbWriter()
				+ "')";

		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
//			System.out.println(r + "건 입력완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 글 수정
	public void update(Board boa) {
		String sql = "update board set board_content = ?, creation_date = sysdate where board_num = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, boa.getbContent());
			psmt.setInt(2, boa.getbNum());

			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 글 삭제
	public void delete(int bNum) {
		String sql = "delete from board where board_num = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNum);

			int r = psmt.executeUpdate();
//			System.out.println(r + "건 삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 글 목록
	public List<Board> search() {
		conn = getConnect();
		List<Board> list = new ArrayList<Board>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board");

			while (rs.next()) {
				list.add(new Board(rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 상세보기
	public Board getBoard(int bNum) {
		String sql = "select * from board where board_num = ?";
		conn = getConnect();
		Board boa = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNum);

			rs = psmt.executeQuery();

			if (rs.next()) {
				boa = new Board(rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return boa;
	}

	// 읽은 횟수 추가
	public void count(int bNum) {
		String sql = "update board set cnt = cnt + 1 where board_num = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNum);

			int r = psmt.executeUpdate();
//			System.out.println(r + "건 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 댓글 추가
	public void reply(Reply rep) {
		String sql = "insert into reply (rep_seq, board_num, rep_content, rep_writer, creation_date) values(reply_seq.nextval, ?, ?, ?, sysdate)";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rep.getBoNum());
			psmt.setString(2, rep.getReContent());
			psmt.setString(3, rep.getReWriter());

			int r = psmt.executeUpdate();
//			System.out.println(r + "건 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 댓글읽어오기
	public List<Reply> search2(int boNum) {
		String sql = "select * from reply where board_num = ?";
		conn = getConnect();
		List<Reply> list2 = new ArrayList<Reply>();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boNum);

			rs = psmt.executeQuery();

			while (rs.next()) {
//				System.out.println(rs.getInt("rep_seq"));
				Reply r = new Reply(rs.getInt("rep_seq"), rs.getInt("board_num"), rs.getString("rep_content"),
						rs.getString("rep_writer"), rs.getString("creation_date"));
				list2.add(r);
				
			}
			return list2;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
}
