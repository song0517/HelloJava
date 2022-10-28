package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.FaqVO;
import co.edu.board.MemberVO;
import co.edu.dao.BoardDAO;

//메소드만 있는 기능
public class BoardServiceImpl implements BoardService {
	
	BoardDAO dao = new BoardDAO();

	@Override
	public BoardVO insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getList(BoardVO vo) {
		return dao.boardList(vo);
	}

	@Override
	public BoardVO findBoard(int boardNo) {
		return dao.searchBoard(boardNo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public boolean deleteBoard(int boardNo) {
		return false;
	}

	@Override
	public List<BoardVO> pageList(int page) {
		return dao.pageList(page);
	}

	@Override
	public List<FaqVO> getFaqList(FaqVO faq) {
		return dao.faqList(faq);
	}

	@Override
	public MemberVO insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}

	@Override
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

	@Override
	public MemberVO login(String id, String passwd) {
		return dao.login(id, passwd);
	}

	@Override
	public MemberVO findId(String id) {
		return dao.findId(id);
	}

	@Override
	public boolean updatePw(MemberVO vo) {
		return dao.updatePw(vo);
	}
	
}
