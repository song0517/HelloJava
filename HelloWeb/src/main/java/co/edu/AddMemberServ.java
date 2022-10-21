package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

@WebServlet({ "/addMemberServlet", "/addMember" })
public class AddMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddMemberServ() {
		super();

	}

	// 사용자의 요청 방식, IP주소 등(주소창을 치면) : request, 응답 정보 (처리된 서버 상태 등) : response
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 보여지는 페이지 타입 html로 만들기 : 클라이언트쪽에서 보여지는 문서형태
		// contentType 지정
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("/addMemberSer 페이지입니다.");
		// getParameter, 값 읽어오기
		String empId = request.getParameter("employee_id");
		String lName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hire_date");
		String jobId = request.getParameter("job_id");

		// DB 입력
		EmpDAO dao = new EmpDAO();
		EmployeeVO emp = new EmployeeVO(0, null, lName, email, hireDate, jobId);
		dao.insertEmp(emp);

		System.out.println("입력완료.");

		// 출력스트림. 문자열 처리 객체
		PrintWriter out = response.getWriter();
		// 웹상에 출력
		out.print("<h3>completed.</h3>");
		out.print("<p>입력결과: <br>사원번호: " + emp.getEmployeeId() + "<br>성씨: " + lName + "<br>이메일: " + email + "<br>입사일자: "
				+ hireDate + "<br>직무: " + jobId + "<br>입니다.</p>");
		
		out.print("<a href=\"member/memberAdd.html\">처음으로</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
