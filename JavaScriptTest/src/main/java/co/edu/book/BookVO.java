package co.edu.book;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookVO {
	
	private String bookCode;  // 도서코드
	private String bookName;  // 도서명
	private String author;    // 저자
	private String press;     // 출판사
	private int price;        // 가격
	
	public BookVO() {
	}
}
