package co.edu.book;

import java.util.Scanner;

public class BookDAO {
	Scanner scn = new Scanner(System.in);
	Book[] library = new Book[100];

	// 1. 책 등록하기
	public void bookAdd() {
		System.out.println("새로운 도서를 등록합니다.");
		System.out.print("도서아이디를 입력하세요. >>>");
		int bookId = scn.nextInt();
		scn.nextLine();
		System.out.print("도서이름을 입력하세요. >>>");
		String bookName = scn.nextLine();
		System.out.print("도서가격을 입력하세요. >>>");
		int bookSal = scn.nextInt(); scn.nextLine();
		System.out.print("도서출판사를 입력하세요. >>>");
		String bookMark = scn.nextLine();
		
		Book check = new Book(bookId, bookName, bookSal, bookMark);
		
		for(int i=0; i<library.length; i++) {
			if(library[i] == null) {
				library[i] = check;
				System.out.println("도서 등록이 완료되었습니다.");
				break;
			}
		}
	}

	// 2. 책 리스트 출력
	public void bookList() {
		System.out.println("현재 있는 도서들입니다.");
		for(Book check : library) {
			if(check != null) {
				System.out.println(check.toString());
			}
		}
	}

	// 3. 원하는 책 출력
	public void bookCheck() {
		System.out.println("도서 찾기 목록입니다.");
		System.out.print("찾고자 하는 도서이름를 입력해주세요. >>>");
		String bookName = scn.nextLine();
		
		for(int i=0; i<library.length; i++) {
			if(library[i] != null && library[i].getBookName()==bookName) {
//				System.out.println((i+1) + "번째 위치에 있습니다. 도서 이름은 : '" + library[i].getBookName() + "'입니다.");
				System.out.println(library[i].getBookId());
				break;
			}
		}
	}

	// 4. 가격 수정하기
	public void salUpdate() {
		System.out.println("도서 가격 수정 목록입니다.");
		System.out.print("가격을 수정하고 싶은 도서 ID를 입력해주세요. >>>");
		int bookId = scn.nextInt();
		scn.nextLine();
		System.out.print("수정 가격을 입력해주세요. >>>");
		int bookSal = scn.nextInt();
		scn.nextLine();
		
		for(int i=0; i<library.length; i++) {
			if(library[i] != null && library[i].getBookId() == bookId) {
				library[i].setBookSal(bookSal);
				System.out.println(library[i].getBookId() + "아이디 번호의 " + library[i].getBookName() + "를 " + library[i].getBookSal() + "원으로 변경하였습니다.");
				break;
			}
		}
	}

	// 5. 판매되어 삭제
	public void bookDel() {
		System.out.println("판매 도서 삭제 목록입니다.");
		System.out.print("판매가 된 도서ID를 입력해주세요. >>>");
		int bookId = scn.nextInt();
		scn.nextLine();
		for(int i=0; i<library.length; i++) {
			if(library[i] != null && library[i].getBookId()==bookId) {
				library[i] = null;
				System.out.println("도서가 삭제되었습니다. 확인해주세요.");
				break;
			}
		}
	}

	// 6. 전체 메뉴
	public void bookCk() {
		boolean run = true;
		while (run) {
			System.out.println("메뉴 : 1. 책등록 2.책리스트 3.책찾기 4.책가격수정 5.책삭제 9.종료");
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
