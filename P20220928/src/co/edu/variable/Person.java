package co.edu.variable;

// 추상화 : 필요한 만큼만 정보를 생성해서 사용하기.
// Person은 값을 넣을수도 기능을 넣을 수도 있는 복합적인 구조.
public class Person {
	//속성을 클래스 안에서는 필드라고 한다.
	String name;
	int age; //나이를 담을 수 있는 필드..
	double height;
	
	// 기능을 클래스 안에서는 메소드라고 한다.
	void laugh() {
		System.out.println("웃는다.");
	}
	void sleep() {
		System.out.println("잠을 잔다.");
	}
}
