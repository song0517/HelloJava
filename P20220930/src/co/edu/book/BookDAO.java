package co.edu.book;

import java.util.Scanner;

public class BookDAO {
	Scanner scn = new Scanner(System.in);
	Book[] liabray = new Book[100];

	// 1. 책 등록하기
	public void bookAdd() {
		System.out.println("새로운 도서 정보를 입력해주세요.");
	}

	// 2. 책 리스트 출력
	public void bookList() {
		System.out.println("현재 있는 도서들입니다.");
	}

	// 3. 원하는 책 출력
	public void bookCheck() {
		System.out.println("찾고 싶은 도서의 ID를 입력해주세요.");
	}

	// 4. 가격 수정하기
	public void salUpdate() {
		System.out.println("가격을 수정하고 싶은 도서 ID를 입력해주세요.");
	}

	// 5. 판매되어 삭제
	public void bookDel() {
		System.out.println("판매가 된 도서ID를 입력해주세요.");
	}

	// 6. 전체 메뉴
	public void bookCk() {
		boolean run = true;
		while (run) {
			System.out.println("메뉴 : 1. 책등록 2.책리스트 3.책찾기 4.책가격수정 5.책삭제 9.종류");
			System.out.print("원하는 메뉴 번호를 눌러주세요. >>> ");
			int menu = scn.nextInt();

			switch (menu) {
				case 1:
					bookAdd();
					break;
				case 2:
					bookList();
					break;
				case 3:
					bookCheck();
					break;
				case 4:
					salUpdate();
					break;
				case 5:
					bookDel();
					break;
				case 9:
					run = false;
					break;
				default :
					System.out.println("올바른 번호가 아닙니다.");
			}//end of switch
		}// end of while
		System.out.println("도서 관리를 끝냅니다.");
	}// end of bookCk

}
