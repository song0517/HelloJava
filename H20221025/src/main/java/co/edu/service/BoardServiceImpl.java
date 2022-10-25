package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.dao.BoardDAO;

//메소드만 있는 기능
public class BoardServiceImpl implements BoardService {
	
	BoardDAO dao = new BoardDAO();

	@Override
	public BoardVO insertBoard(BoardVO vo) {
		return null;
	}

	@Override
	public List<BoardVO> getList(BoardVO vo) {
		return null;
	}

	@Override
	public BoardVO findBoard(int boardNo) {
		return null;
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		return false;
	}

	@Override
	public boolean deleteBoard(int boardNo) {
		return false;
	}
	
}
