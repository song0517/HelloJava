package co.edu.variable;

public class MethodExe {
	//void : 반환하는 값이 없다, 메소드이름 : main (String[] args) : 문자열 배열이 매개변수로 오게 만들겠답
	//main은 클래스가 실행될 때 제일먼저 실행이 되는 메소드.
	public static void main(String[] args) {
		//main안에 호출하는 값을 넣어주어야 실행이 된다., 매개변수를 실행하는 것이 매개값
//		printStar();
		printStar(3);
		printCircle("==");
		printCircle("♣", 3);
		
//		sum(2,3);
		int result = sum(sum(2,3), sum(3,4));
		System.out.println("최종값은 " + result);
	}
	
	//반환하는 값도 없고 매게변수도 없는 유형의 메소드
	public static void printStar() {
		System.out.println("★");
	}
	
	//반환값은 없지만 매게변수는 있는 유형의 메소드
	public static void printStar(int times) {
		for(int i=0; i<times; i++) {
			System.out.println("★");
		}
	}
	
	//매개변수에 어떤 값이 들어오는지에 따라 출력되는 값이 달라질 수 있다.
	public static void printCircle(String circle) {
		System.out.println(circle);
	}
	
	//다른 메소드의 매개변수를 이용해서 하나의 메소드 생성 가능, 변수를 이용해서 유형만 생성하여 나중에 값이 들어올 수 있도록 설정.
	public static void printCircle(String circle, int times) {
		for(int i =0; i<times; i++) {
			System.out.println(circle);
		}
	}
	
	//반환값을 가지는 메소드.
	//return을 사용할 경우 : result는 int로 정의되었기 때문에 반환값의 유형은 int로 변경되어야 한다., 똑같은 유형의 값을 반환하겠다는 규칙을 따라줘야된다..
	public static int sum(int n1, int n2) {
		int result = n1 * 2 + n2 * 3;
		System.out.println("결과값은 " + result);
		return result; 
	}
}
