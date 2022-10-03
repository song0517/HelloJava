package co.edu.library;

public class Book {
	private String bookId;
	private String bookName;
	private String bookCom;
	private int bookCode;
	private String bookRep;
	private int bookSal;
	
	//기본생성자
	public Book() {}
	//초기값
	public Book(String bookId, String bookName, String bookCom, int bookCode, String bookRep, int bookSal) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookCom = bookCom;
		this.bookCode = bookCode;
		this.bookRep = bookRep;
		this.bookSal = bookSal;
	}

	//책ID
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getBookId() {
		return bookId;
	}
	
	//책이름
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookName() {
		return bookName;
	}

	//책 출판사
	public void setBookCom(String bookCom) {
		this.bookCom = bookCom;
	}
	
	public String getBookCom() {
		return bookCom;
	}

	//책 분류코드
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	
	public int getBookCode() {
		return bookCode;
	}

	//책 요약
	public void setBookRep(String bookRep) {
		this.bookRep = bookRep;
	}
	
	public String getBookRep() {
		return bookRep;
	}

	//책 가격
	public void setBookSal(int bookSal) {
		this.bookSal = bookSal;
	}
	
	public int getBookSal() {
		return bookSal;
	}

	//주소가 아닌 아래의 형태로 나타내기
	@Override
	public String toString() {
		return "Book [책ID=" + bookId + ", 이름=" + bookName + ", 출판사=" + bookCom + ", 분류코드=" + bookCode
				+ ", 요약=" + bookRep + ", 가격=" + bookSal + "]";
	};
	
	
}
