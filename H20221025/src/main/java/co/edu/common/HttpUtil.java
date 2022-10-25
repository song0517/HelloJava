package co.edu.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String path) {
		RequestDispatcher rs = req.getRequestDispatcher(path);
		try {
			rs.forward(req, resp); //first.do 호출 시 -> WEB-INF/jsp/first.jsp 실제 실행, 주소창에는 first.do라고 표시
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
