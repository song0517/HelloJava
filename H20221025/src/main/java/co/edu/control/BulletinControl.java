package co.edu.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.BoardVO;
import co.edu.board.PageVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class BulletinControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		int pg = Integer.parseInt(page);
		
//		PageVO paging = new PageVO(512, pg);
		
		BoardService service = new BoardServiceImpl();
		List<BoardVO> total = service.getList(new BoardVO(0, "", "", "", "", 0, ""));
		PageVO paging = new PageVO(total.size(), pg);
		
//		List<BoardVO> list = service.getList(new BoardVO(0, "", "", "", "", 0, ""));
		List<BoardVO> list = service.pageList(pg);

		//정보 넘기기
		req.setAttribute("bList", list);
		req.setAttribute("page", paging);

		HttpUtil.forward(req, resp, "bulletin/bulletin.tiles");
	}
}
