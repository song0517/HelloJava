package co.edu;

//사람 : 속성(이름, 나이, 키, 몸무게)
//      기능(달린다, 먹는다, 잠을 잔다)
public class Person {
	//속성을 클래스 안에서는 필드
	String name;
	int age;
	double height;
	double weight;
	
	//기능은 선언할때 '리턴타입 매소드이름(매개값){}'
	//기능은 클래스에서 메소드라고 한다.
	void run() {
		System.out.println(name + "는 달립니다.");
	}
	void eat(String food) {
		System.out.println(name + "는 " + food + "을 먹습니다.");
	}
	void sleep() {
		System.out.println(name + "는 잠을 잡니다.");
	}
}
