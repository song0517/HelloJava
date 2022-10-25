package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

public class LogOut implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//웹브라우저안에 있는 session객체의 값을 삭제 -> invalidate()
		session.invalidate();
		
		HttpUtil.forward(req, resp, "memberLog/loginForm.jsp");
	}

}
