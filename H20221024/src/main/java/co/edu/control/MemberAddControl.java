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

// 사용자 요청이 들어오면 DB에 추가
public class MemberAddControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 만약 오라클이 아닌 MySql로 바꿔야될 경우 같은 인터페이스를 구현하는 객체일 경우 클래스이름만 바꿔주면 다른 코드를 수정하지 않아도 된다. -> CRUD 수정 X
		//MemberService service = new MemberServiceMysql();
		
		// parameter 값에 따라서...
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		MemberVO vo = new MemberVO(id, passwd, name, mail);
		
		// DB 입력처리
		MemberService service = new MemberServiceImpl();
		service.addMember(vo);
		
		// DB 처리된 결과를 보여주는 페이지.
		HttpUtil.forward(req, resp, "memberResult/memberInsertOutput.jsp");
		
	}
}
