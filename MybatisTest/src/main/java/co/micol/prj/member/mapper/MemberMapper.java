package co.micol.prj.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.member.vo.MemberVO;

//MemberService와 동일
public interface MemberMapper {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	int memberUpdate(MemberVO vo);
	
	//매개변수가 2개 이상일 경우
	MemberVO memberLogin(@Param("id") String id, @Param("password") String password);
	boolean isMemberIdCheck(String id); //아이디를 넘겨서 중복 확인, 존재하면 false 
}
