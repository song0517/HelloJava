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

import co.edu.control.MainControl;

public class FrontController extends HttpServlet{
	
	HashMap<String, Control> controlList;
	String charset;
	
	//서블릿 호출 되면 한번만 실행 init()
	//매개값없이 가져오기
//	@Override
//	public void init() throws ServletException {
//		ServletContext sc = this.getServletContext();
//		sc.getInitParameter("charset");
//	}
	
	//매개값으로 ServletConfig가져오기
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		controlList = new HashMap<String, Control>();
		
		controlList.put("/main.do", new MainControl());
	}
	
	//service()
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // http://localhost:8081/H20221025/main.do
		String context = req.getContextPath(); // /H20221025
		String path = uri.substring(context.length()); // /main.do
		
		System.out.println(path);
		Control subControl = controlList.get(path);
		subControl.exec(req, resp); // main.do 호출해서 거기에 매핑되어있는 control실행.
	}
}
