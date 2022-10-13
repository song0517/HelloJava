package co.edu.board;

public class Reply {
	private int reNum;
	private int boNum;
	private String reContent;
	private String reWriter;
	private String reDate;

	public Reply(int reNum, int boNum, String reContent, String reWriter, String reDate) {
		this.reNum = reNum;
		this.boNum = boNum;
		this.reContent = reContent;
		this.reWriter = reWriter;
		this.reDate = reDate;
	}

	public int getReNum() {
		return reNum;
	}
	public void setReNum(int reNum) {
		this.reNum = reNum;
	}

	public int getBoNum() {
		return boNum;
	}
	public void setBoNum(int boNum) {
		this.boNum = boNum;
	}

	public String getReContent() {
		return reContent;
	}
	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public String getReWriter() {
		return reWriter;
	}
	public void setReWriter(String reWriter) {
		this.reWriter = reWriter;
	}

	public String getReDate() {
		return reDate;
	}
	public void setReDate(String reDate) {
		this.reDate = reDate;
	}

	public String toString() {
		return "댓글 번호: " + reNum + ", 댓글 내용: " + reContent + ", 댓글 작성자: " + reWriter + ", 작성일자: " + reDate;
	}

}
