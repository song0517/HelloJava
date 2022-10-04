package co.edu.inherit;

//20221004
//호출하는 메인 클래스
public class MainApp {
	public static void main(String[] args) {
		// 인스턴스 생성
		Child child = new Child();

		//Child클래스에 부모클래스 method를 재정의할 경우 child클래스에 정의한 결과값이 나타난다.
		child.method(); // Parent의 메소드
		child.method1(); // Child의 메소드

		System.out.println();

		Child2 child2 = new Child2();
		child2.method();
		child2.method2();

		System.out.println();
		
		// 왼쪽에 있는 타입과 오른쪽에 있는 타입이 항상 같아야된다.
		Parent c1 = new Parent();
		// 하지만 상속의 관계일 경우 부모클래스의 참조 변수에 자식 인스턴스 대입이 가능하다.
		// 자동형변환이 일어난다.(자식인스턴스 -> 부모인스턴스)
		c1 = new Child();
		c1 = new Child2();

		// 단, 자식클래스를 통해 인스턴스를 지정을 해도 부모가 가지고 있는 멤버들만 호출이 가능하다.
		// c1.method2();
		
		System.out.println();
		
		//그래서 인스턴스오브를 통해 c1의 참조변수가 child2의 인스턴스이면 c2인스턴스로 변환이 가능하다는 조건
		//강제형변환(casting)
		if(c1 instanceof Child2) {
			Child2 c2 = (Child2) c1;
			c2.method2();
		}
		
		System.out.println();
		
		//Parent 인스턴스가 담겨있다.
		Parent c3 = new Parent();
		//casting, if를 안쓸 경우 문법상 가능은 하지만 실행에는 오류가 발생
		//instance가 맞는지 확인을 한 후 실행, 아래는 결과x
		//담겨있는 변수의 인스턴스가 어떤 타입인지 먼저 확인한 후 실행
		if(c3 instanceof Child2) {
		Child2 c4 = (Child2) c3;
		c4.method2();
		}
	}
}
