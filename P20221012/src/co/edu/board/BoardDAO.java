package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//221012
//CRUD기능 구현
public class BoardDAO extends DAO {
	// 글등록
	public void insert(Board boa) {
		String sql = "insert into board(board_num, board_title, board_content, board_writer) " + "values("
				+ boa.getbNum() + ", '" + boa.getbTitle() + "', '" + boa.getbContent() + "', '" + boa.getbWriter()
				+ "')";
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//글 수정
	public void update(Board boa) {
		String sql = "update board set board_content = ? where board_num = ?";
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
			System.out.println(r + "건 삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//글 목록
	public List<Board> search() {
		conn = getConnect();
		List<Board> list = new ArrayList<Board>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select board_num, board_title, board_writer, creation_date from board");
			
			while (rs.next()) {
				list.add(new Board(rs.getInt("board_num"),rs.getString("board_title"), rs.getString("board_writer"), rs.getString("creation_date")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//상세보기
	public Board getBoard(int bNum) {
		String sql = "select * from board where board_num = ?";
		conn = getConnect();
		Board boa = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNum);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				boa = new Board(rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_content"), rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return boa;
	
	}
}
