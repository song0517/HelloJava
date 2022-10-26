package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
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
		return false;
	}

	@Override
	public boolean deleteBoard(int boardNo) {
		return false;
	}

	@Override
	public List<BoardVO> pageList(int page) {
		return dao.pageList(page);
	}
	
}
