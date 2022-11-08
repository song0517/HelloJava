package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.impl.MemberServiceImpl;

public class AjaxIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// ajax 아이디 중복 체크
		MemberService dao = new MemberServiceImpl();
		//ajax에서 호출할때 가져오는 파라메타 이름 가져오기
		String id = request.getParameter("id");
		
		boolean b = dao.isMemberIdCheck(id); //존재하면 false
		String result = "0";
		
		if(b) {
			result = "1";
		}
		
		return "ajax:" + result;
	}

}
