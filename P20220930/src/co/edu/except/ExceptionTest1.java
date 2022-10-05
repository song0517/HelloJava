package co.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

//발생할 수 있는 예외보기
public class ExceptionTest1 {
	public static void main(String[] args) {
		// null pointer 참조
//		String str = null;
		String str = "Hello World!!";
		// 예외처리. RuntimeException 상속받아서 처리하는 예외클래스.
		try {
			// 0~10번째 자리 구하기
			String result = str.substring(0, 10);
			// 2번째 자리 구하기 0부터 시작이기 때문에 실제로는 3번째 자리 출력
			// char chr = result.charAt(2);
			// 인덱스 범위 초과 : 정해진 범위보다 초과할 경우
			char chr = result.charAt(20);
			System.out.println(result);
			System.out.println(chr);
		} catch (NullPointerException | StringIndexOutOfBoundsException e) {
			System.out.println("참조하는 값이 없습니다.");
//		} catch (StringIndexOutOfBoundsException e1) {
//			System.out.println("인덱스범위를 벗어난 값입니다.");
		} catch (RuntimeException e2) {
			System.out.println("실행예외가 발생했습니다.");
		} catch (Exception e3) {
			System.out.println("알수 없는 예외가 발생했습니다.");
			// 모든 예외 다 처리....무슨 에러인지 모르겠으면 Exception으로 사용
			// 다른 예외를 같이 사용하고 싶으면 꼭 순서 지켜주기. -> 가장큰범위를 가장 마지막에 위치.(내림차순)
		}

		// InputMismatchException : 숫자가 아닌 다른 값이 들어왔을 경우 에러
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("숫자를 입력 >>> ");

			try {
				int menu = scn.nextInt();
				System.out.println("입력값은 : " + menu);
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요!");
				scn.nextLine(); // 문자, Enter의 값까지 소진시켜주겠다. 읽어들인값을 비워주겠다아...
			} finally { // 예외 또는 정상적인 실행이 되더라도 반드시 실행을 시켜주겠다.
				System.out.println("반드시 실행할 코드");
				// db connection 사용하고 resource 반환 코드를 주로 finally안에 넣어준다아아....
			}
		}
		//호출
		try {
			exceptMethod();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
	} // end of main()

	//호출한 영역으로 예외처리 떠넘기기.
	public static void exceptMethod() throws ClassNotFoundException {
		// 일반예외 : Exception 상속받아서 처리하는 예외클래스, 반드시 예외처리코드가 들어가야된다.
//		try {
			Class.forName("java.lang.String");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

	}
}
