package co.edu.inherit.friend;

public class ComFriend extends Friend{
	private String company;
	private String dept;
	
//부모클래스의 기본생성자를 작성해주어야된다.
	public ComFriend() {
		super();
	}
	
	//값 초기화, 4개의 매개값
	public ComFriend(String name, String phone, String company, String dept) {
		//this는 현재의 클래스에 있을 경우에만 가능.
		//부모클래스에서 가져오는 생성자가 있다. 부모클래스의 생성자 호출. -> super(부모클래스에 있는 변수)
		super(name, phone);
		this.company = company;
		this.dept = dept;
	}
	
//회사이름
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompany() {
		return company;
	}

//부서
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDept() {
		return dept;
	}

	@Override
	public String showInfo() {
		//회사 친구의 정보
		//부모클래스에 있는 값은 get메소드를 사용해서 가져오기.
		return "회사 친구의 이름 " + getName() + ", 연락처는 " + getPhone() + ", 회사명은 " + this.company + ", 부서는 " + this.dept + "입니다."; 
	}
		
}
