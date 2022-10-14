package co.edu.nested;

//20221014

//클래스의 멤버 : 필드, 생성자, 메소드
//멤버클래스
class Person{
	//필드
	String name;
	int age;
	
	//생성자
	Person(){}
	
	//메소드
	void showInfo() {
		//로컬 클래스
		class Local {
			void show() {
				System.out.println("show");
			}
		}
		//로컬클래스의 경우 로컬클래스 인스턴스 생성 후 메소드 실행 코드를 작성해주어야 main에서 로컬 클래스 안에 있는 코드 실행 가능
		Local local = new Local();
		local.show();
	}
	
	// Inner 클래스(인스턴스)
	class Car {
		String carName;
		
		void run() {
			System.out.println("run");
		}
	}
	
	// Inner 클래스(정적)
	static class Calculator {
		void add() {
			System.out.println("add");
		}
	}
	
	//인터페이스 안에 있는 메소드는 무조건 구현해 주어야 된다.
	//클래스 안에 선언이 되었기 때문에 class안에서만 인터페이스 사용가능
	class Run implements Runnable{
		@Override
		public void run() {
			System.out.println("run 구현");
		}
	}
	
	// Inner interface : 저장된 클래스 안에서만 사용하겠다아...
	interface Runnable {
		void run();
	}
	
}

public class NestedExample {
	public static void main(String[] args) {
		Person p = new Person();
		
		//인스턴스 멤버 클래스.
		//외부클래스.내부클래스 인스턴스이름 = 외부클래스인스턴스이름.new 내부클래스();
		//내부인스턴스 생성
		Person.Car car = p.new Car();
		car.run();
		
		//정적 멤버 클래스.
		//외부클래스.정적멤버클래스 인스턴스이름 = new 외부클래스.정적멤버클래스
		Person.Calculator cal = new Person.Calculator();
		cal.add();
		
		//로컬 클래스 호출
		p.showInfo();
	}
}
