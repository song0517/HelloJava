package co.edu.nested;

//20221014

interface Run {
	void run();
}

class Runner implements Run {
	@Override
	public void run() {
		System.out.println("달린다.");
	}
}

//상황에 따라서 다른 기능을 수행하고 싶을 경우 익명의 클래스를 생성하여 메소드 오버라이딩하기.
public class AnonymousExample2 {
	public static void main(String[] args) {
		//익명구현객체: 상황에 따라 기능이 다를 경우 사용.
		
		//실행문이기 때문에 끝에 ; 붙여야된다.
		Run runner = new Run() {
			String kind;
			void runKind() {
				System.out.println("육상");
			}
			
			//필요한 기능 바꾸기
			@Override
			public void run() {
				System.out.println("구현 run");
				//익명클래스 안에서 새로 구현한 메소드는 익명클래스 안에서 실행해야된다.
				runKind();
			}
		};
		runner.run();
		
		//필요한 만큼 새로 생성 가능
		Run runner2 = new Run() {
			@Override
			public void run() {
				System.out.println("구기종목");
			}
		};
		runner2.run();
	}
}
