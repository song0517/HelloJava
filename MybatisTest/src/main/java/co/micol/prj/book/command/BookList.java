package co.micol.prj.book.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.book.service.BookService;
import co.micol.prj.book.service.impl.BookServiceImpl;
import co.micol.prj.book.vo.BookVO;
import co.micol.prj.common.Command;

public class BookList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 책목록 가져오기, 구현체를 통해 초기화
		BookService dao = new BookServiceImpl();
		List<BookVO> books = new ArrayList<BookVO>();
		books = dao.bookSelectList(); //전체목록
		request.setAttribute("books", books); //결과 담기
		
		//보여줄페이지
		return "book/bookList";
	}
}
