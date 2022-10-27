package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class SignUp implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		BoardService service = new BoardServiceImpl();
		service.insertMember(new MemberVO(id, passwd, name, email));
		
		HttpUtil.forward(req, resp, "member/member.tiles");
	}

}
