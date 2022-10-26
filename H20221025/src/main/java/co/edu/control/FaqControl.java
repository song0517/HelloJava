package co.edu.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.FaqVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class FaqControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService service = new BoardServiceImpl();
		List<FaqVO> list = service.getFaqList(new FaqVO(0, "", "", "", "", 0));
		
		req.setAttribute("fList", list);
		HttpUtil.forward(req, resp, "bulletin/faqBulletin.tiles");

	}

}
