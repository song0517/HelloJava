package co.edu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.member.MemberVO;
import co.edu.service.MemberDAO;

@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// json타입, 한글 처리
		response.setContentType("text/json;charset=utf-8");

		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();

		// [{"id":"user1", "name":"홍길동", "email":"user1@email", "resposibility":"user"},
		// {}, {}, {}]
		// 3건일 경우 1(0), 2(1), 3(2)
		/*
		 * String json = "["; for(int i=0; i<list.size(); i++) { // '\'는 ""를 문자열로 표시해
		 * 주겠다... json +=
		 * "{\"id\":\""+list.get(i).getId()+"\", \"name\":\""+list.get(i).getName() //
		 * +"\", \"email\":\""+list.get(i).getEmail() //
		 * +"\", \"resposibility\":\""+list.get(i).getResposibility()+"\"}";
		 * 
		 * if(i < list.size() - 1) { json += ","; } } json += "]";
		 * response.getWriter().print(json);
		 */

		// gson사용할 경우
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		String job = request.getParameter("job");
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		
		// job => 등록, 삭제 구분
		if (job.equals("delete")) {
			if(dao.deleteMember(id)) {
				response.getWriter().print("success");
			} else {
				response.getWriter().print("fail");
			}

		} else if (job.equals("insert")) {
			String pw = request.getParameter("passwd");
			String email = request.getParameter("email");
			String name = request.getParameter("name");

			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPasswd(pw);
			vo.setEmail(email);
			vo.setName(name);
			
			dao.insertMember(vo);

			// gson 인스턴스 호출.
			Gson gson = new GsonBuilder().create();
			// gson -> {"id":"user1","passwd":...."} 자동생성
			// 콘솔에 출력
			response.getWriter().print(gson.toJson(vo));
		}
	}
}
