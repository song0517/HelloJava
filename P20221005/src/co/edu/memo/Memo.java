package co.edu.memo;

import java.io.Serializable;

//20221011
public class Memo implements Serializable {
	private int no;
	private String date;
	private String content;
	
	public Memo(int no, String date, String content) {
		this.no = no;
		this.date = date;
		this.content = content;
	}
	
	//getter / setter
	public void setNo(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	
	@Override
	public String toString() {
		return "번호: " + no + ", 작성날짜: " + date + ", 내용: " + content;
	}
}
