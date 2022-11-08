package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;

public class Logout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		//session객체는 타입이 없기때문에 타입 지정
		String message = (String) session.getAttribute("name");
		message = message.concat("님 안녕히 가세요!!!");
		request.setAttribute("message", message);
		//세션자체를 완전히 없애버린다.
		session.invalidate();
		
		return "member/memberLogin.tiles";
		
		//return "main.do"; //처음 로그인 안된상태로 돌아가기
	}

}
