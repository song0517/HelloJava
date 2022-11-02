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

import co.edu.member.CalendarVO;
import co.edu.service.MemberDAO;


@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ScheduleServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		List<CalendarVO> result = dao.getCalendar();
		System.out.println(result);
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(result));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		MemberDAO dao = new MemberDAO();
		
		String title = request.getParameter("title");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		CalendarVO vo = new CalendarVO();
		vo.setTitle(title);
		vo.setStart(start);
		vo.setEnd(end);
		
		if(dao.insertSch(vo)) {
			response.getWriter().print("success");
		} else {
			response.getWriter().print("fail");
		}
	}

}
