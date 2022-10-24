package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;
import co.edu.vo.MemberVO;

public class MemberModify implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자입력정보를 parameter통해 읽어오기
		
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		String email = req.getParameter("mail");
		
		MemberVO vo = new MemberVO(id, passwd, name, email);
		
		MemberService service = new MemberServiceImpl();
		service.modifyMember(vo);
		
		HttpUtil.forward(req, resp, "memberResult/memberUpdateOutput.jsp");

	}

}
