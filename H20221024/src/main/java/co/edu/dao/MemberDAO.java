package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO {
	// 생성, 수정, 삭제, 한건조회, 목록조회

	// 추가
	public void memberInsert(MemberVO vo) {
		conn = getConnect();
		String sql = "insert into members(id, passwd, name, email) values(?, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 한건 조회
	public MemberVO memberSearch(String id) {
		conn = getConnect();
		String sql = "select * from members where id = ?";
		MemberVO meb = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				meb = new MemberVO(rs.getString("id"), rs.getString("passwd"), rs.getString("name"),
						rs.getString("email"), rs.getString("resposibility"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return meb;
	}

	// 수정
	public void memberUpdate(MemberVO vo) {
		conn = getConnect();
		String sql = "update members set passwd = ?, name = ?, email = ? where id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getId());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public void memberDelete(String id) {
		conn = getConnect();
		String sql = "delete from members where id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 전체 조회
	public List<MemberVO> memberList() {
		conn = getConnect();
		String sql = "select * from members";
		List<MemberVO> mebList = new ArrayList<MemberVO>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				mebList.add(new MemberVO(rs.getString("id"), rs.getString("passwd"), rs.getString("name"),
						rs.getString("email"), rs.getString("resposibility")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return mebList;
	}

	// String id, String passwd => MemberVO
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
}
