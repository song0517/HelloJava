package co.edu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.common.DAO;
import co.edu.member.CalendarVO;
import co.edu.member.MemberVO;

public class MemberDAO extends DAO {
	// 전체목록
	public List<MemberVO> memberList() {
		getConnect();
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from members order by id";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				// vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setResposibility(rs.getString("resposibility"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 한건 입력
	public void insertMember(MemberVO vo) {
		getConnect();
		String sql = "insert into members(id, passwd, email, name, resposibility) values (?, ?, ?, ?, 'user')";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getName());

			psmt.executeUpdate();

			vo.setResposibility("user");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 한건 삭제
	public boolean deleteMember(String id) {
		getConnect();
		String sql = "delete from members where id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
	// 부서명, 부서인원
	public Map<String, Integer> getEmpByDept() {
		getConnect();
		Map<String, Integer> map = new HashMap<>();
		String sql = "select d.department_name, count(1)\r\n"
					  + "from hr.employees e\r\n"
					  + "join hr.departments d\r\n"
					  + "on e.department_id = d.department_id\r\n"
					  + "group by d.department_name";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				//칼럼위치에 따라 키와 값 가져오기
				map.put(rs.getString(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return map;
	}
	
	// 전체일정가져오기
	public List<CalendarVO> getCalendar() {
		getConnect();
		List<CalendarVO> list = new ArrayList<CalendarVO>();
		String sql = "select * from full_calendar";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CalendarVO vo = new CalendarVO();
				vo.setTitle(rs.getString("title"));
				vo.setStart(rs.getString("start_date"));
				vo.setEnd(rs.getString("end_date"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;		
	}
	
	public boolean insertSch(CalendarVO vo) {
		getConnect();
		String sql = "insert into full_calendar (title, start_date, end_date) values (?, ?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getStart());
			psmt.setString(3, vo.getEnd());

			int r = psmt.executeUpdate();
			if(r>0) {
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
