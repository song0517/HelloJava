package co.edu.inherit.friend;

public class UnivFriend extends Friend {
	private String univ;
	private String major;

//초기값
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);
		this.univ = univ;
		this.major = major;
	}

//학교
	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getUniv() {
		return univ;
	}

//전공
	public void setMajor(String major) {
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	@Override
	public String showInfo() {
		return "학교친구의 이름 " + getName() + ", 연락처는 " + getPhone() + ", 학교명은 " + this.univ + ", 전공은 " + this.major
				+ "입니다.";
	}
}
