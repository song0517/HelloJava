package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.FaqVO;
import co.edu.board.MemberVO;

//기능만 정의
public interface BoardService {
	//입력
	public BoardVO insertBoard(BoardVO vo);
	
	//목록보기
	public List<BoardVO> getList(BoardVO vo);
	
	//한건조회
	public BoardVO findBoard(int boardNo);
	
	//수정
	public boolean updateBoard(BoardVO vo);
	
	//삭제
	public boolean deleteBoard(int boardNo);
	
	//페이지
	public List<BoardVO> pageList(int page);
	
	//회원가입
	public MemberVO insertMember(MemberVO vo);
	
	//로그인
	public MemberVO login(String id, String passwd);
	
	//회원목록보기
	public List<MemberVO> memberList();
	
	//ID찾기
	public MemberVO findId(String id);
	//비밀번호 변경
	public boolean updatePw(MemberVO vo);
	
	//FAQ
	public List<FaqVO> getFaqList(FaqVO faq);
}
