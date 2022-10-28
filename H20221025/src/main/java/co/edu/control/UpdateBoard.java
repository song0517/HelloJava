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

public class UpdateBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		String content = req.getParameter("content");
		
		BoardVO vo = new BoardVO(boardNo, null, content, null, null, 0, null);
		
		BoardService service = new BoardServiceImpl();
		service.updateBoard(vo);
		
//		HttpUtil.forward(req, resp, "bulletin/bulletin.tiles");
		resp.sendRedirect("bulletin.do");
	}

}
