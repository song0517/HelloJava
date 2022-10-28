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

public class PasswdReConfirm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		BoardService service = new BoardServiceImpl();
		MemberVO result = service.findId(id);
		
		req.setAttribute("logInfo", result);
		
		if(result != null) {
			String email = result.getEmail();
			String passwdRe = "";
			
			for(int i=0; i<4; i++) {
				passwdRe += (int) (Math.random() *9) +1;
			}
			
			MailApp app = new MailApp();
			app.sendMail("songj137@naver.com", email, "비밀번호 재발급", passwdRe);
			
			service.updatePw(new MemberVO(id, passwdRe, null, null));
			
			HttpUtil.forward(req, resp, "member/passwdRe.tiles");
		} else {
//			HttpUtil.forward(req, resp, "member/passwdReConfirm.tiles");
			HttpUtil.forward(req, resp, "member/passwdRe.tiles");
		}
		
	}

}
