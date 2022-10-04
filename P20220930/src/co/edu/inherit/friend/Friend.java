package co.edu.inherit.friend;

public class Friend {
	private String name;
	private String phone;

//기본 생성자 정의
	public Friend() {};
//생성자
	public Friend(String name, String phone) {
		super(); // object클래스의 생성자 호출, 그냥 부모클래스의 생성자를 호출한다고 알면 좋다. 없어도 가능
		this.name = name;
		this.phone = phone;
	}

//이름
	public void setName(String name) {
		this.name = name;
	}

	// name필드를 반환해주는 메소드.
	public String getName() {
		return name;
	}

//전화번호
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}
	
	public String showInfo() {
		return "친구의 이름은 " + name + "이고 연락처는 " + phone +"입니다.";
	}
}
