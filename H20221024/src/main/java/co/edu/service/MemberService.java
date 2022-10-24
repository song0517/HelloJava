package co.edu.service;

import java.util.List;

import co.edu.vo.MemberVO;

//CRUD 기능 담기
public interface MemberService {
	// 멤버 추가
	public void addMember(MemberVO vo);

	// 멤버 수정
	public void modifyMember(MemberVO vo);

	// 멤버 삭제
	public void removeMember(String id);

	// 멤버 한건 조회
	public MemberVO findMember(String id);
	
	// 멤버 전체 조회
	public List<MemberVO> memberList();
}
