package co.edu;

import java.util.Arrays;

// 학생객체 : 속성(학번, 이름, 전공)
//          기능(공부한다, 게임한다, 잠을 잔다) 
//public : 다른 클래스에서도 사용 가능, 필드와 매소드에도 public 입력 가능
//private : 숨김. 잘못된 값들을 막기 위해서 외부 접근을 피하기 위해 필드는 대체로 private으로 숨긴다. 속성은 왠만하면 private 사용
public class Student {
	//필드
	private String stdNo;
	private String stdName;
	private String stdMajor;
	private int age; // 정수값 23, 0, -12
	// 취미부분은 여러가지 속성을 담기위해 배열사용
	// 크기를 정해주지 않는다면 초기에 설정한 공간만큼만 생성이 되어 추가로 넣어도 나타나지 않는다.
	private String[] hobbies = new String[5];
	
	//정적메소드 : static로 정의된 것만, 
	public static void staticMethod() {
		System.out.println("staticMethod call.");
	}
	
	//생성자(필드의 값의 초기화를 정해주는 역할), 매개값의 갯수에 차이를 두어 여러 생성자를 작성할 수 있다. -> 생성자 오버로딩(동일한 이름의 생성자를 여러번 정의)
	//다른 생성자가 있을 경우 기본 생성자를 정의하지 않을 경우 에러가 뜨기 때문에 기본생성자도 따로 지정해 주어야 한다.
	public Student() {
		//매개값이 없는 생성자 = 기본생성자.
		this.stdName = "기본값";
		this.stdNo = "000-000";
	}
	//매개변수값을 이용해서 초기화 정해주기.
	public Student(String stdNo, String stdName) {
		this.stdNo = stdNo;
		this.stdName = stdName;	
	}
	public Student(String stdNo, String stdName, String stdMajor) {
//		this(); //Student()의 기본생성자 호출
		this(stdNo, stdName); //Student(String stdNo, String stdName)의 기본생성자 호출
		this.stdMajor = stdMajor;
	}
	
	//메소드
	// 취미
	void setHobbies(String[] hobbies) {
//		this.hobbies = hobbies;
		for (String hobby : hobbies) {
			for (int i = 0; i < this.hobbies.length; i++) {
				if (this.hobbies[i] == null) {
					this.hobbies[i] = hobby;
					break;
				}
			}
		}
	}

	String[] getHobbies() {
		return this.hobbies;
	}

	String getHobb() {
		String str = "취미는 ";
		for (String hobby : hobbies) {
			if (hobby != null) {
				str += hobby + " ";
			}
		}
		str += "입니다.";
		return str;
	}

	// 취미를 추가
	void addHobby(String hobby) {
		for (int i = 0; i < hobbies.length; i++) {
			if (hobbies[i] == null) {
				hobbies[i] = hobby;
				break;
			}
		}
	}

	// private이 설정되었을 경우 외부로 접근하기 어렵기 때문에 필드에 값을 담을 경우 메소드를 이용해서 담아준다. 대부분 앞에 set붙임
	void setStdNo(String studNo) {
		this.stdNo = studNo;
	}

	// 반환할때 대부분 앞에 get을 붙인다.
	String getStdNo() {
		return this.stdNo;
	}

	// 이름
	void setStdName(String stdName) {
		this.stdName = stdName;
	}

	String getStdName() {
		return this.stdName;
	}

	// 전공
	void setStdMajor(String stdMajor) {
		this.stdMajor = stdMajor;
	}

	String getStdMajor() {
		return this.stdMajor;
	}

	// 나이
	void setAge(int age) {
		if (age < 0) {
			// this.를 사용하면 매개변수가 아닌 해당 필드이름을 의미(인스턴스를 의미)
			this.age = 0;
		} else {
			this.age = age;
		}
	}

	// private를 사용했을 경우 값을 불러오는 메소드를 만들어 제공
	int getAge() {
		return this.age;
	}

	// showInfo() : 이름, 학번, 전공정보를 반환하는 메소드
	public String showInfo() {
		return "이름은 " + this.stdName + "이고 학번은 " + this.stdNo + ", 전공은 " + this.stdMajor + "입니다.";
	}

	void study() {
		System.out.println(stdName + "은 공부를 합니다.");
	}

	void game(String gameName) {
		System.out.println(stdName + "은 " + gameName + "게임을 합니다.");
	}

	void sleep() {
		System.out.println(stdName + "은 잠을 잡니다.");
	}

	@Override
	public String toString() {
		return "Student [stdNo=" + stdNo + ", stdName=" + stdName + ", stdMajor=" + stdMajor + ", age=" + age
				+ ", hobbies=" + Arrays.toString(hobbies) + "]";
	}
	
	

}
