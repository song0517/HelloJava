package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.book.command.BookList;
import co.micol.prj.common.Command;
import co.micol.prj.main.MainCommand;
import co.micol.prj.member.command.AjaxIdCheck;
import co.micol.prj.member.command.Logout;
import co.micol.prj.member.command.MemberJoin;
import co.micol.prj.member.command.MemberJoinForm;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;

/**
 * 모든 요청을 받아들이는 컨트롤러, 서블릿생성
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//명령을 저장할 수 있는 map 컬렉션 생성(키 값과 value값으로 설정)
	private HashMap<String, Command> map = new HashMap<String, Command>();
	
	// 생성자
    public FrontController() {
        super();
    }
    
    // 요청한 것을 실행하는 명령을 모아 두는 곳
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); //처음보여줄 메인 페이지 명령
		map.put("/bookList.do", new BookList()); //책목록보기
		
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); //멤버로그인처리
		map.put("/logout.do", new Logout()); //로그아웃
		
		map.put("/memberJoinForm.do", new MemberJoinForm()); //회원가입 폼
		 
		map.put("/ajaxIdCheck.do", new AjaxIdCheck()); //ajax를 이용한 아이디 중복체크
		
		map.put("/memberJoin.do", new MemberJoin()); //멤버 추가
		
	}
	
	// 요청을 분석하고 실행, 결과를 돌려주는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지
		String uri = request.getRequestURI(); // 요청한 URI를 구함
		String contextPath = request.getContextPath(); // 루트를 구함, contextPath 구함
		String page = uri.substring(contextPath.length()); // 실제 수행할 요청을 구함
		
		Command command = map.get(page); // init 메소드에서 수행할 명령을 가져온다. map의 키값을 가져오면 그에 맞는 값을 들고온다.
		//Command command = new MainCommand();, 위에 코드가 실행이 될 경우 초기화하는 것과 같다.
		String viewPage = command.exec(request, response); // 명령을 수행하고 결과를 돌려받음
		
		// viewResolve파트, 어느페이지에 보여줄지 뷰를 찾는다. 돌아갈 곳을 찾아주는 것
		// 리턴되는 문자열에서 마지막에 .do가 포함되어 있지 않다면
		// 서버에서 접근할 수 있도록 설정
		if(!viewPage.endsWith(".do") && viewPage != null) {
			// ajax 처리 : 요청한 페이지로 돌아오는 곳
			if(viewPage.startsWith("ajax:")){
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			
			// 타일즈 돌아가는 곳
			if(!viewPage.endsWith(".tiles")) {
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp"; //tiles를 안태움
			}
			
			// 뷰를 찾아서 Dispatcher하기
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response); // dispatcher로 하면 요청을 하면서 값을 그대로 전달받아 req, resp을 함께 가져간다., 내가 하기 싫은 것을 값과 함께 전달
		} else {
			response.sendRedirect(viewPage); // *.do로 들어올때 돌아가는 곳 -> 권한을 위임하는데 새로 req와 resp가 생성이 되어 새로운 요청만 실행, viewpage만 돌려주세요., .do로 들어오면 다시 명령어 실행 
		}
	}

}
