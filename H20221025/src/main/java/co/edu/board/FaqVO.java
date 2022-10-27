package co.edu.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaqVO {
	private int faqNo;
	private String title;
	private String content;
	private String writer;
	private String writeDate; // 2020-11-23
	private int clickCnt;
}
