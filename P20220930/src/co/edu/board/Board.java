package co.edu.board;

public class Board {
	private int boardNo;
	private String title;
	private String content;

	// 매개변수가 없는 기본 생성자
	public Board() {
	}

	public Board(int boardNo, String title, String content) {
		super(); // 상속
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
	}

	// 글번호
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	// 제목
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	// 내용
	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	// 주소값이 아닌 아래의 형태로 나타남
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + "]";
	}
}
