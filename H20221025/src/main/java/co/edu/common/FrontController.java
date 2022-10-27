package co.edu.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.control.BulletinControl;
import co.edu.control.FaqControl;
import co.edu.control.MainControl;
import co.edu.control.MemberList;
import co.edu.control.SearchBoard;
import co.edu.control.SignIn;
import co.edu.control.SignInForm;
import co.edu.control.SignOut;
import co.edu.control.SignUp;
import co.edu.control.SignUpForm;
import co.edu.control.UpdateBoard;
import co.edu.control.UpdateBoardForm;
import co.edu.control.WriteBoard;
import co.edu.control.WriteForm;

public class FrontController extends HttpServlet {

	HashMap<String, Control> controlList;
	String charset;

	// 서블릿 호출 되면 한번만 실행 init()
	// 매개값없이 가져오기
//	@Override
//	public void init() throws ServletException {
//		ServletContext sc = this.getServletContext();
//		sc.getInitParameter("charset");
//	}

	// 매개값으로 ServletConfig가져오기
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		controlList = new HashMap<String, Control>();

		controlList.put("/main.do", new MainControl());

		// 게시판
		controlList.put("/bulletin.do", new BulletinControl());

		// 한건조회
		controlList.put("/searchBoard.do", new SearchBoard());

		// 등록
		controlList.put("/writeBoardForm.do", new WriteForm());
		controlList.put("/writeBoard.do", new WriteBoard());

		// 수정
		controlList.put("/updateBoardForm.do", new UpdateBoardForm());
		controlList.put("/updateBoard.do", new UpdateBoard());

		// 회원가입
		controlList.put("/signUpForm.do", new SignUpForm()); // 회원가입화면
		controlList.put("/signUp.do", new SignUp()); // 회원가입처리(DB입력 후 "회원가입되었습니다")

		// 로그인
		controlList.put("/signInForm.do", new SignInForm()); // 로그인화면
		controlList.put("/signIn.do", new SignIn()); // 로그인처리

		// 로그아웃
		controlList.put("/signOut.do", new SignOut());

		// 회원목록
		controlList.put("/memberList.do", new MemberList());

		// FAQ
		controlList.put("/faq.do", new FaqControl());
	}

	// service()
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글은 utf-8로 처리하겠다!
		req.setCharacterEncoding(charset); // 한글처리.
		resp.setCharacterEncoding(charset); // 한글

		String uri = req.getRequestURI(); // http://localhost:8081/H20221025/main.do
		String context = req.getContextPath(); // /H20221025
		String path = uri.substring(context.length()); // /main.do

		System.out.println(path);
		Control subControl = controlList.get(path);
		subControl.exec(req, resp); // main.do 호출해서 거기에 매핑되어있는 control실행.
	}
}
