package co.edu.friend;

public class CoFriend extends Friend{
	// 친구이름, 연락처 (상속) + 회사명, 부서정보 (추가)
	private String company;
	private String department;

	// 필요한 생성자를 작성.
	public CoFriend() {
		super();
	}
	
	public CoFriend(String name, String phoneNumber, String company, String department) {
		super(name,phoneNumber);
		this.company = company;
		this.department = department;
	}

	// get, set 메소드 작성.
	public String getCompany() {
		return this.company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getDepartment() {
		return this.department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	// Friend클래스의 getInfo() 를 overriding 하세요.
	@Override
	public String getInfo() {
		return "회사 친구 이름: " + getName() + ", 연락처: " + getPhoneNumber() + ", 회사명: " + this.company + ", 부서: " + this.department;
	}
}
