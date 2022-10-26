package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.BoardVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class SearchBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bno파라메터 읽어오기
		
		String bno = req.getParameter("bno");
		
		BoardService service = new BoardServiceImpl();
		BoardVO board = service.findBoard(Integer.parseInt(bno));
		
		//값 저장해서 가져가지
		req.setAttribute("board", board);
		
		HttpUtil.forward(req, resp, "bulletin/searchBulltin.tiles");
		
	}

}
