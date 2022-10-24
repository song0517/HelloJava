package co.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//20221024
public interface Command {
	//추상메소드
	//요청정보와 응답정보를 매개값으로 넘겨주겠다.
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
