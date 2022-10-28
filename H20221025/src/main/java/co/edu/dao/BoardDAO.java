package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.FaqVO;
import co.edu.board.MemberVO;
import co.edu.common.DAO;

public class BoardDAO extends DAO {
	// 입력, 조회, 수정, 삭제
	// 1.입력
	public BoardVO insertBoard(BoardVO vo) {
		// 입력처리 중 에러가 발생하면 -> null;
		getConnect();
		String sql = "select board_seq.nextval from dual";
		String sql2 = "insert into tbl_board(board_no, title, content, writer, image) values(?, ?, ?, ?, ?)";

		try {
			// 시퀀스값 가져오기
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int nextSeq = 0;
			if (rs.next()) {
				nextSeq = rs.getInt(1);
			}

			// 입력위한작업
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, nextSeq);
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setString(5, vo.getImage());

			int r = psmt.executeUpdate();
			if (r > 0) {
				vo.setBoardNo(nextSeq);
				return vo;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null; // 실패할경우
	}

	// 2.한건조회
	public BoardVO searchBoard(int boardNo) {
		getConnect();
		String sql = "select * from tbl_board where board_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);

			rs = psmt.executeQuery();
			if (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));

				return board;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 3.목록조회
	public List<BoardVO> boardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList<>();
		getConnect();
		String sql = "select * from tbl_board " + "where 1=1 " //
				+ "and title like '%'||?||'%' "//
				+ "and content like '%'||?||'%' "//
				+ "and writer like '%'||?||'%' ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());

			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));

				list.add(board);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 4.수정
	public boolean updateBoard(BoardVO vo) {
		// 처리건수가 0일 경우 false;
		getConnect();
		String sql = "update tbl_board set content = ? where board_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getContent());
			psmt.setInt(2, vo.getBoardNo());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 5.삭제
	public boolean deleteBoard(int boardNo) {
		// 처리건수가 0일 경우 false;
		getConnect();
		String sql = "delete from tbl_board where board_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 페이지. 전체건수 기준으로 10개씩 자르기, 검색결과 전체건수/10개씩
	// 전체건수
	public int totalCnt() {
		getConnect();
		String sql = "select count(1) from tbl_board";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				// 가지고 온 컬럼의 순서로 표시
				int cnt = rs.getInt(1);
				return cnt;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}

	// 페이지값
	public List<BoardVO> pageList(int page) {
		getConnect();
		List<BoardVO> list = new ArrayList<>();
		String sql = "select b.* " + "from (select rownum rn, a.* " + "      from (select * "
				+ "            from tbl_board " + "            order by board_no desc) a "
				+ "      where rownum <= ?) b " + "where b.rn >= ?";

		int from = (page - 1) * 10 + 1; // 1, 11
		int to = (page * 10); // 10, 20

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, to);
			psmt.setInt(2, from);

			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));

				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public List<FaqVO> faqList(FaqVO vo) {
		List<FaqVO> list = new ArrayList<>();
		getConnect();
		String sql = "select * from faq_board " + "where 1=1 " //
				+ "and title like '%'||?||'%' "//
				+ "and content like '%'||?||'%' "//
				+ "and writer like '%'||?||'%' ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());

			rs = psmt.executeQuery();
			while (rs.next()) {
				FaqVO faq = new FaqVO();
				faq.setFaqNo(rs.getInt("faq_no"));
				faq.setTitle(rs.getString("title"));
				faq.setContent(rs.getString("content"));
				faq.setWriter(rs.getString("writer"));
				faq.setWriteDate(rs.getString("write_date"));
				faq.setClickCnt(rs.getInt("click_cnt"));

				list.add(faq);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 회원가입
	public MemberVO insertMember(MemberVO vo) {
		// 입력처리 중 에러가 발생하면 -> null;
		getConnect();
		String sql = "insert into members(id, passwd, name, email, resposibility) values(?, ?, ?, ?, 'user')";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());

			int r = psmt.executeUpdate();

			if (r > 0) {
//					MemberVO member = new MemberVO(vo.getId(), vo.getPasswd(), vo.getName(), vo.getEmail());
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 회원목록출력하기 for member/memberList.jsp에서 jstl이용
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		getConnect();
		String sql = "select * from members";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));

				list.add(vo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 로그인
	public MemberVO login(String id, String passwd) {
		getConnect();
		String sql = "select * from members where id = ? and passwd = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);

			rs = psmt.executeQuery();
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setResposibility(rs.getString("resposibility"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// ID찾기
	public MemberVO findId(String id) {
		getConnect();
		String sql = "select * from members where id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setResposibility(rs.getString("resposibility"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// PW수정
	public boolean updatePw(MemberVO vo) {
		getConnect();
		String sql = "update members set passwd = ? where id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getId());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
}
