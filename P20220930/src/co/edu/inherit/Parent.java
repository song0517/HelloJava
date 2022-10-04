package co.edu.inherit;

//20221004
//Object는 모든클래스의 제일 상위에 있는 클래스, 그래서 따로 상속을 지정하지 않아도 소속되어 있다.
public class Parent{
	String field;
	
	//부모클래스 생성자 호출
	Parent() {
		System.out.println("Parent() call.");
	}
	
	//매게변수를 넣을 경우 기본생성자는 사라짐. 그래서 위에처럼 기본생성자를 작성해주어야된다.
	Parent(String args) {
		System.out.println("Parent(String args) call.");
	}
	
	void method() {
		System.out.println("Parent method() call.");
	}

	//Override가 가능한 이유는 toString의 메소드가 Object 클래스에 있는 메소드이기 때문에 사용 가능
	@Override
	public String toString() {
		return "Parent [field=" + field + "]";
	}
	
}
