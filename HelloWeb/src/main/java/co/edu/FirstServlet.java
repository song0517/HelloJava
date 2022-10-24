package co.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

//20221024
//자바 클래스 -> 서블릿이 되려면 HttpServlet 상속.
//init()메소드와 service()메소드 구현.
//제어의 흐름을 개발자가 아니라 서블릿컨테이너가 흐름을 제어 : 제어의 역전(IOC)
public class FirstServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// 인스턴스가 생성이 될 때 한번만 실행
		System.out.println("init() 호출.");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// FristServlet이 호출이 될때마다 실행.
		System.out.println("service() 호출.");
		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter out = resp.getWriter();

		// 요청방식 정보를 담고 있는것 req
		// 사용자 paramet를 들고와서 처리
		String job = req.getParameter("job");
		//호출해서 사용...
		EmpDAO dao = new EmpDAO();

		if (req.getMethod().equals("GET")) {
			// 대체적으로 get방식은 정보 조회할때 많이 사용
			List<EmployeeVO> list = dao.empList(new EmployeeVO(job));
			out.print("<table border='1'");
			out.print("<tr><th>사원번호</th><th>이름</th><th>이메일</th><th>직무</th></tr>");
			for (EmployeeVO emp : list) {
				out.print("<tr><td>" + emp.getEmployeeId() + "</td><td>" + emp.getLastName() + "</td><td>"
						+ emp.getEmail() + "</td><td>" + emp.getJobId() + "</td></tr>");
			}
			out.print("</table>");
		} else if (req.getMethod().equals("POST")) {
			// 데이터 입력할때 많이 사용
			// 각각의 값을 파라메타로 넘겨오겠다. -> http에서 name에 설정한 이름대로 설정
			String empId = req.getParameter("emp_id");
			String lName = req.getParameter("last_name");
			String email = req.getParameter("email");
			String hDate = req.getParameter("hire_date");

			dao.insertEmp(new EmployeeVO(Integer.parseInt(empId) // 사원번호 int타입으로 만들기
					, null // first_name
					, lName // last_name
					, email // email
					, hDate // hire_date
					, job // job_id
			));

			out.print("<script>alert('입력완료');</script>");
		}
	}

	// 서브 종료
	@Override
	public void destroy() {
		System.out.println("distroy() 호출.");

	}
}
