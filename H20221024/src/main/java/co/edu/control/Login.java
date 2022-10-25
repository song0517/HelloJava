package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Command;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;
import co.edu.vo.MemberVO;

public class Login implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");

		MemberService service = new MemberServiceImpl();
		MemberVO result = service.login(id, passwd);
		
		//회원아이디와 비밀번호가 맞으면 메인페이지로 이동(main.jsp) => 정보를 함께 가져감
		if (result != null) {
			req.setAttribute("logInfo", result);

			// 요청정보가 가지고 있는 정보 저장
			HttpSession session = req.getSession();
			session.setAttribute("id", result.getId());
			session.setAttribute("auth", result.getResposibility()); //admin인지 user인지에 따라 권한 달리 부여

			HttpUtil.forward(req, resp, "memberView/main.jsp");
		} else {
			HttpUtil.forward(req, resp, "memberLog/loginForm.jsp");
		}
	}

}
