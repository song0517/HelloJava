package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.edu.board.BoardVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class WriteBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saveDir = req.getServletContext().getRealPath("upload");
		System.out.println(saveDir);
		String encod = "UTF-8";
		int maxSize = 5 * 1024 * 1024; //(5MB까지 업로드 가능)
		
		MultipartRequest mr = new MultipartRequest(
				req, //요청정보.
				saveDir, //저장위치
				maxSize, //업로드 파일 크기
				encod, //인코딩(언어설정)
				new DefaultFileRenamePolicy() //리네임 정책.(같은 파일 이름이 있을 경우)
				);
		
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String image = mr.getFilesystemName("image");
		
		//DB 입력
		BoardService service = new BoardServiceImpl();
		service.insertBoard(new BoardVO(0,title, content, writer, null, 0, image));
		
//		HttpUtil.forward(req, resp, "bulletin/bulletin.tiles");
		resp.sendRedirect("bulletin.do");
	}

}
