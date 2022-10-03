package co.edu.library;

import java.util.Scanner;

public class BookDAO {
	private static BookDAO instance = new BookDAO();
	private BookDAO() {}
	public static BookDAO getInstance() {
		return instance;
	}
	
	Scanner scn = new Scanner(System.in);
	Book[] library = new Book[100];
	
	//1. 도서 추가 
	public void add() {
		System.out.println("도서 등록 메뉴입니다.");
		System.out.print("도서 ID를 입력하세요. >>>");
		String bookId = scn.next();
		System.out.print("도서 이름를 입력하세요. >>>");
		String bookName = scn.next();
		System.out.print("도서 출판사를 입력하세요. >>>");
		String bookCom = scn.next();
		System.out.println("분류코드 : 1.문학 2.자연과학 3.역사 4.예술 5.기타..");
		System.out.print("도서 분류코드를 입력하세요. >>>");
		int bookCode = scn.nextInt();
		System.out.print("도서 요약을 입력하세요. >>>");
		String bookRep = scn.next();
		System.out.print("도서 가격을 입력하세요. >>>");
		int bookSal = scn.nextInt();
		
		Book bk = new Book(bookId, bookName, bookCom, bookCode, bookRep, bookSal);
		for(int i=0; i<library.length; i++) {
			if(library[i] == null) {
				library[i] = bk;
				System.out.println("도서가 등록되었습니다.");
				break;
			}
		}
	}
	
	//2. 전체 목록 나타내기
		public void list() {
			System.out.println("전체 도서 목록입니다.");
			for(Book bk : library) {
				if(bk != null) {
					System.out.println(bk.toString());
				}
			}
		}
		
	
	
	//3. 분류별 모아보기
		public void code() {
			System.out.println("분류별 도서를 확인하는 목록입니다.");
			System.out.println("분류코드 : 1.문학 2.자연과학 3.역사 4.예술 5.기타..");
			System.out.print("보고싶은 분류 코드 번호를 입력하세요. >>>");
			int bookCode = scn.nextInt();

			for(Book bk : library) {
				if(bk != null && bk.getBookCode() == bookCode) {
					System.out.println(bk.toString());
				}
			}
		}
	
	//4. 도서 ID 찾기 
	public void find() {
		int count = 0;
		System.out.println("도서 ID를 찾는 메뉴입니다.");
		System.out.print("찾고자 하는 도서 이름을 입력하세요. >>> ");
		String bookName = scn.next();
		for(int i=0; i<library.length; i++) {
			if(library[i] != null && library[i].getBookName().equals(bookName)) {
				System.out.println(bookName + "의 아이디는 " + library[i].getBookId() + "입니다.");
				count += 1;
			}
		}
		System.out.println("총 " + count + "권 있습니다.");
	}
	
	//5. 도서 이름 찾기
	public void name() {
		System.out.println("도서 이름을 찾는 메뉴입니다.");
		System.out.print("찾고자 하는 도서 ID을 입력하세요. >>> ");
		String bookId = scn.next();
		for(int i=0; i<library.length; i++) {
			if(library[i] != null && library[i].getBookId().equals(bookId)) {
				System.out.println(library[i].getBookId() + "의 책은 " + library[i].getBookName()  + "입니다.");
				break;
			}
		}
	}
	
	//6. 도서 가격 수정하기
	public void update() {
		System.out.println("도서 가격 수정메뉴입니다.");
		System.out.print("수정하고 싶은 도서 ID를 입력하세요. >>>");
		String bookId = scn.next();
		System.out.println(bookId);
		System.out.print("수정할 가격을 입력하세요. >>>");
		int bookSal = scn.nextInt();
		System.out.println(bookSal);
		
		for(int i=0; i<library.length; i++) {
			if(library[i] != null && library[i].getBookId().equals(bookId)) {
				library[i].setBookSal(bookSal);
				System.out.println(library[i].getBookId() + "아이디 번호의 " + library[i].getBookName() + "를 " + library[i].getBookSal() + "원으로 변경하였습니다.");
				break;
			}
		}
	}
	
	//7. 판매된 도서 삭제
	public void del() {
		System.out.println("판매된 도서 삭제 목록입니다.");
		System.out.print("판매가 된 도서ID를 입력하세요. >>>");
		String bookId = scn.next();
		
		for(int i=0; i<library.length; i++) {
			if(library[i] != null && library[i].getBookId().equals(bookId)) {
				library[i] = null;
				System.out.println("도서가 삭제되었습니다. 확인해주세요.");
				break;
			}
		}
	}
	
	//6. 전체 메뉴 표시
	public void setBook() {
		boolean run = true;
		
		while(run) {
			System.out.println("메뉴 : 1.책등록 2.전체목록 3.분류별보기 4.Id찾기 5.도서찾기 6.가격수정 7.판매도서삭제 9.종료");
			System.out.println("원하는 항목의 번호를 입력하세요. >>> ");
			
			int menu = scn.nextInt();
			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				list();
				break;
			case 3:
				code();
				break;
			case 4:
				find();
				break;
			case 5:
				name();
				break;
			case 6:
				update();
				break;
			case 7:
				del();
				break;
			case 9:
				run = false;
				break;
			default :
				System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요.");
			} //end of switch
		}//end of while
		System.out.println("도서 프로그램을 종료합니다.");
	}//end of setBook
	
}
