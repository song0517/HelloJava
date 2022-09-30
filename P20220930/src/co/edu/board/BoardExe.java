package co.edu.board;

public class BoardExe {
	public static void main(String[] args) {
		//프로그램 시작
		//인스턴스 호출
//		BoardDAO dao = new BoardDAO();
		
		//싱글톤 방식 인스턴스 불러오기
		BoardDAO dao = BoardDAO.getInstance();
		//dao의 메소드 호출
		dao.exe();
	}
}
