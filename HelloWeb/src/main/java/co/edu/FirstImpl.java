package co.edu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstImpl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// first.do 호출할 경우 first.jsp 페이지 호출
		//.jsp가 WEB-INF에 있을 경우 : 정보 보안상 숨김
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/first.jsp");
		rd.forward(req, resp);
		//.jsp가 밖에 있을 경우
//		resp.sendRedirect("WEB-INF/jsp/first.jsp");
		
	}

}
