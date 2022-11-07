package co.micol.prj.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 공통적인 인터페이스
public interface Command {
	// 실행해서 돌려줄 리턴 객체가 String
	// 서버가 자동으로 생성 : 처음 요청이 들어오면 request(클라이언트에서 요청하는 모든 값들을 담는다), response(응답하는 객체)
	public String exec(HttpServletRequest request, HttpServletResponse response);
}
