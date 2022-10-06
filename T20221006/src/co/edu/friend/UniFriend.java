package co.edu.friend;

public class UniFriend extends Friend {
	// 친구이름, 연락처 (상속) + 학교정보, 전공정보 (추가)
	private String college;
	private String major;

	// 필요한 생성자를 작성.
	public UniFriend() {
		super();
	}
	
	public UniFriend(String name, String phoneNumber, String college, String major) {
		super(name, phoneNumber);
		this.college = college;
		this.major = major;
	}

	// get, set 메소드 작성.
	public String getCollege() {
		return this.college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	
	public String getMajor() {
		return this.major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	// Friend클래스의 getInfo() 를 overriding 하세요.
	@Override
	public String getInfo() {
		return "학교 친구 이름: " + getName() + ", 연락처: " + getPhoneNumber() + ", 학교명: " + this.college + ", 전공: " + this.major;
	}
}
