package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.FaqVO;

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
	
	//FAQ
	public List<FaqVO> getFaqList(FaqVO faq);
}
