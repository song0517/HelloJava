package co.dev;

//221014
public class Student {
	private int studNo;
	private String studName;
	private int score;
	
	Student(int studNo, String studName, int score){
		this.studNo = studNo;
		this.studName = studName;
		this.score = score;
	}
	
	
	public void setStudNo(int studNo) {
		this.studNo = studNo;
	}
	public int getStudNo() {
		return studNo;
	}
	
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudName() {
		return studName;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
}
