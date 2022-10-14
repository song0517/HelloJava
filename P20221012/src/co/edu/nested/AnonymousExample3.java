package co.edu.nested;

//221014
//익명구현객체
//추상메소드 하나만 존재하는 인터페이스 => Functional 인터페이스
interface MyInterface {
	void run();
}

//람다표현식은 구현해야되는 메소드가 한개만 있을 경우 가능
interface MyInterface2 {
	void run(String kind);
}

interface MyInterface3 {
	int sum(int num1, int num2);
}

public class AnonymousExample3 {
	public static void main(String[] args) {

		// 인터페이스 안에 있는 메소드를 실행시키기..
		// run의 매개값 부분()만 선언을 한 후 ->를 통해 선언을 간단하게 할 수 있다.
		// 구현하는 것이 한개일 경우 {};를 묶어주지 않아도 괜찮다.

		// 람다표현식 : 구현을 하는데 코드를 간단하게 만들고 싶을 때
		// 매개값이 없을 경우 한줄로 표현 가능
		MyInterface intf = () -> System.out.println("MyInterface run");

		intf.run();

//		MyInterface2 intf2 = new MyInterface2() {			
//			@Override
//			public void run(String kind) {
//				System.out.println(kind + " Run!");
//			}
//		};

		// 매개변수가 한개일 경우 타입(String)과 괄호()를 지울 수 있다.
		MyInterface2 intf2 = kind -> System.out.println(kind + " Run!");

		intf2.run("농구종목");

		// 리턴값이 있을 경우
//		MyInterface3 intf3 = new MyInterface3() {
//			@Override
//			public int sum(int num1, int num2) {
//				return num1*2 + num2;
//			}
//		};

		MyInterface3 intf3 = (num1, num2) -> num1 * 2 + num2;

		int result = intf3.sum(10, 20);
		System.out.println(result);
		
		intf3 = (num1, num2) -> num1 * 2 + num2 * 3;
		result = intf3.sum(11, 22);
		System.out.println(result);
	}
}
