package co.edu.inherit;

//20221004
//상속할 경우 부모클래스에 있는 메소드도 함께 사용가능하다.
public class Child extends Parent {
	String field1;
	
	Child() {
		//부모클래스의 기본 생성자 호출.
		//super();
		//매개변수가 있는 생성자 호출
		super("args");
		System.out.println("Child() call.");
	}
	
	void method1() {
		System.out.println("method1() call.");
	}
	
	//부모클래스가 가지고 있는 기능들 가져오기.
	//부모클래스의 메소드를 재정의. overriding.
	@Override  //어노테이션 : 부모클래스 메소드(반환값, 메소드의 이름, 매개값) 체크. 자식클래스에서 재정의하겠다는 규칙을 정한것
	void method() {
		System.out.println("Child method() call.");
	}

	@Override
	public String toString() {
		return "Child [field1=" + field1 + "]";
	}
	
	/*
    아래와 부모클래스와 달리 매개변수가 있을 경우 Child 메소드이다.
	void method(String arg1) {
		System.out.println("Child method() call.");
	}
	*/
	
	
}
