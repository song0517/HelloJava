package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

public class MemberAddForm implements Command {

	// 입력하는 화면으로 페이지 이동
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpUtil.forward(req, resp, "memberView/memberInsert.jsp");

	}

}
