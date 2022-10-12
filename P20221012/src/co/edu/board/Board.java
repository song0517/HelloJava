package co.edu.board;

//221012
public class Board {
	private int bNum;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private String bDate;
	private int count;
	
	public Board(int bNum, String bTitle, String bContent, String bWriter, String bDate, int count) {
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriter = bWriter;
		this.bDate = bDate;
		this.count = 0;
	}
	
	public Board(int bNum, String bTitle, String bWriter, String bDate) {
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bWriter = bWriter;
		this.bDate = bDate;
	}
	
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "책번호: " + bNum + ", 이름: " + bTitle + ", 내용: " + bContent + ", 저자: " + bWriter + ", 작성날짜: " + bDate + ", 읽은횟수: " + count;
	}
}
