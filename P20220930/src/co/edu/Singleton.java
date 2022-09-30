package co.edu;

public class Singleton {
	//private 정적 필드 : class에 하나만 존재하도록 하겠다. 외부에서는 필드에 접속하지 못하도록 private로 호출
	private static Singleton singleton = new Singleton();
	
	//private 생성자도 외부에서 접속 불가
	private Singleton() {
		
	}
	
	//가져갈수 있는 방법은 이 메소드를 통해서만 가능, public getInstance(); 생성자를 만들 수 있음
	public static Singleton getInstance() {
		return singleton;
	}
}
