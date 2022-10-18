package co.tra;

import java.sql.ResultSet;

public class Student {
	private String stuId; //회원ID
	private String stuPw; //회원PW
	private String stuName; //회원이름
	private String stuPhone; //회원연락처
	private String stuBir; //회원생년월일
	private int traId; //회원수강과목ID
	private String traName; //회원수강과목이름
	
	//생성자
	public Student(String stuId, String stuPw, String stuName, String stuPhone, String stuBir, int traId, String traName) {
		this.stuId = stuId;
		this.stuPw = stuPw;
		this.stuName = stuName;
		this.stuPhone = stuPhone;
		this.stuBir = stuBir;
		this.traId = traId;
		this.traName = traName;
	}

	//get, set
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuPw() {
		return stuPw;
	}
	public void setStuPw(String stuPw) {
		this.stuPw = stuPw;
	}

	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPhone() {
		return stuPhone;
	}
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	public String getStuBir() {
		return stuBir;
	}
	public void setStuBir(String stuBir) {
		this.stuBir = stuBir;
	}

	public int getTraId() {
		return traId;
	}
	public void setTraId(int traId) {
		this.traId = traId;
	}

	public String getTraName() {
		return traName;
	}
	public void setTraName(String traName) {
		this.traName = traName;
	}

	@Override
	public String toString() {
		return "학생ID: " + stuId + ", 이름: " + stuName + ", 연락처: " + stuPhone
				+ ", 생년월일: " + stuBir + ", 수강과목ID: " + traId + ", 수강과목: " + traName;
	}
}
