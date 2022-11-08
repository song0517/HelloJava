package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	int memberUpdate(MemberVO vo);
	
	//로그인
	MemberVO memberLogin(String id, String password);
	//is를 붙이는 이유가 존재하면 false를 리턴하기 위해. is가 붙여있으면 거의 존재하면 false를 리턴
	boolean isMemberIdCheck(String id); //아이디를 넘겨서 중복 확인, 존재하면 false 
}
