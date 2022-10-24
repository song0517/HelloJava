package co.edu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//20221024
//모든 요청(*.do)서블릿들을 FrontController를 사용하여 처리(실행)
public class FrontController extends HttpServlet{
	//모든 servlet 관리.
	//url주소와 실행할 서블릿을 map;타입으로 관리
	Map<String, Command> map = new HashMap<String, Command>();
	
	@Override
	public void init() throws ServletException {
		//map(키, 값)
		map.put("/first.do", new FirstImpl());
		map.put("/second.do", new SecondImpl());
		map.put("/third.do", new ThirdImpl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//http://localhost:8081/HelloWeb/first.do, 서버 정보를 뺀 나머지 uri라고 한다:/HelloWeb/first.do
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath(); // 요청 uri에서 프로젝트 정보를 반환
		String path = uri.substring(contextPath.length());
		
//		System.out.println("uri: " + uri);
//		System.out.println("contextPath: " + contextPath);
//		System.out.println("path: " + path);
		
		//내가 어떤 서블릿을 연결했는지 알아볼 수 있다.
		Command command = map.get(path);
		command.exec(req, resp);
	}
}
