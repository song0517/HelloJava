package co.edu.book;

public class Book {
	private String bookId;
	private String bookName;
	private int bookSal;
	private String bookMark;
	
	public Book() {}
	
	public Book(String bookId, String bookName, int bookSal, String bookMark) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookSal = bookSal;
		this.bookMark = bookMark;
	}
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookId() {
		return bookId;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookName() {
		return bookName;
	}
	
	public void setBookSal(int bookSal) {
		this.bookSal = bookSal;
	}
	public int getBookSal() {
		return bookSal;
	}
	
	public void setBookMark(String bookMark) {
		this.bookMark = bookMark;
	}
	public String getBookMark() {
		return bookMark;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookSal=" + bookSal + ", bookMark=" + bookMark + "]";
	}
	
	
}
