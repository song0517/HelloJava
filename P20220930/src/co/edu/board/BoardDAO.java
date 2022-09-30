package co.edu.board;

import java.util.Scanner;

public class BoardDAO {
	//싱글톤, 클래스에 소속이 되어 여러개를 만들지 못하도록 하는 의미가 static
	//외부에서 접근 제한, 하지만 getInstance를 이용해서 정적메소드(static)할 경우 instance를 호출할 수 있게 해준다.
	//정적메소드로 호출하는 방식으로 코딩하시오.
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	Scanner scn = new Scanner(System.in);
	Board[] myBoards = new Board[100];

	// 1. 글등록
	public void addBoard() {
		System.out.println("글 등록 기능입니다.");
		System.out.print("글 번호를 입력하세요. >>> ");
		int bNo = scn.nextInt();
		//엔터알리기
		scn.nextLine();
		System.out.println("글 제목을 입력하세요. >>> ");
		String title = scn.nextLine();
		System.out.print("글 내용을 입력하세요. >>> ");
		String content = scn.nextLine();
		
		//생성자를 가지고 값을 초기화
		Board brd = new Board(bNo, title, content);
		//배열 등록.
		for(int i=0; i<myBoards.length; i++) {
			if(myBoards[i] == null) {
				myBoards[i] = brd;
				System.out.println("글이 등록되었습니다.");
				break;
			}
		}
	}

	// 2. 글목록보기
	public void boardList() {
		System.out.println("글 목록 기능입니다.");
		for(Board brd : myBoards) {
			if(brd != null) {
				System.out.println(brd.toString());
			}
		}
	}

	// 3. 글상세보기
	public void boardDetail() {
		System.out.println("글 상세보기 기능입니다.");
		System.out.print("글 번호를 입력하세요. >>> ");
		int bNo = scn.nextInt();
		scn.nextLine();
		for(int i=0; i<myBoards.length; i++) {
			if(myBoards[i] != null && myBoards[i].getBoardNo() == bNo) {
				System.out.println(myBoards[i].getContent());
				break;
			} 
		}
		
	}

	// 4. 글삭제
	public void delBoard() {
		System.out.println("글 삭제 기능입니다.");
		System.out.print("글 번호를 입력하세요. >>> ");
		int bNo = scn.nextInt();
		scn.nextLine();
		for(int i=0; i<myBoards.length; i++) {
			if(myBoards[i] != null && myBoards[i].getBoardNo() == bNo) {
				myBoards[i] = null;
				System.out.println("삭제되었습니다.");
				break;
			}
		}
	}

	// 5. 전체 메뉴
	public void exe() {
		boolean run = true;
		while (run) {
			System.out.println("메뉴 : 1.글등록 2.글목록보기 3.글상세보기 4.글삭제 9.종료");
			System.out.print("선택 >>> ");

			int menu = scn.nextInt();
			switch (menu) {
				case 1:
					addBoard();
					break;
				case 2:
					boardList();
					break;
				case 3:
					boardDetail();
					break;
				case 4:
					delBoard();
					break;
				case 9:
					run = false;
					break;
				default:
					System.out.println("잘못된 메뉴입니다.");
			}
		} // end of while
		System.out.println("프로그램 종료");
	}// end of exe
}
