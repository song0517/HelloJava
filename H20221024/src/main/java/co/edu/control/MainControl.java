package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

public class MainControl implements Command {

	// 제일 첫번째로 호출되는 페이지
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		//session정보(id)가 있으면 메인페이지 이동, 없으면 로그인페이지로 이동
		String id = (String) session.getAttribute("id");
		if(id != null) {
			HttpUtil.forward(req, resp, "memberView/main.jsp");
		} else {
			HttpUtil.forward(req, resp, "memberLog/loginForm.jsp");
		}
	}

}
