package co.edu.variable;

//자바는 class 시작. class반드시 정의
//클래스의 main메소드로 부터 시작.
public class App {
	public static void main(String[] args) {
		//실행시점
		System.out.println("매개값을 출력."); //괄호안에 있는 매개값을 출력하는 기능
		
		//변수의 타입 지정. => 정수(int, long), 실수(double, float), 참/거짓(boolean), 문자열(String)
		int myAge = 25; //오른쪽과 왼쪽의 타입이 항상 동일해야된다.
//		myAge = "스물다섯"; //컴파일 에러.
		
		String 내나이 = "스물다섯";  //문자를 넣고 싶으면 String 사용하고 ""로 문자 묶어주기.
		내나이 = "28";  //문자열 "28"이라는 의미, 숫자x
		
		int result = myAge + 30;
		System.out.println(myAge + "와 30을 더하면 " + result +"입니다.");
		
		//배열 선언.
		int[] numAry = {20, 29, 13, 44, 88, 33};
		int sum = 0;
		//1) 배열 합계 구하기.
		for (int i=0; i<6; i++) {
			//짝수 조건일 경우에만 합계
//			if(numAry[i] % 2 == 0) {
//				sum = sum + numAry[i];
//			}
//			System.out.println(numAry[i]);
			
			//20, 13, 88(인덱스 번호 이용해서 홀수 자리의 합계 구하기)
			if(i % 2 == 0) {
				sum = sum + numAry[i];
			}
		}
//		System.out.println("짝수의 합계 => " + sum);
		System.out.println("홀수 자리의 합계 => " + sum);
		
//		2)배열 조건 : sum의 값이 100을 넘어서는 시점 break;
		sum = 0; //초기화
		for(int i=0; i<6; i++) {
			sum = sum + numAry[i];
			if(sum > 100) {
				break;
			}
		}
		System.out.println("100을 넘어서는 시점의 합은? " + sum);
		
		System.out.println("정상커밋완료.");
		
	}
}
