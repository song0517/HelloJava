package co.edu.variable;

import java.util.Scanner;

public class WhileExe {
	public static void main(String[] args) {
		whileFnc3();
	}

	public static void whileFnc() {
		// for 반복문 : 반복 횟수가 정해져 있으면 사용하기 좋다. for(int i=0; i<10; i++){}
		// while : 조건이 맞을 경우에만 반복
		int i = 0;
		while (i < 4) {
			System.out.println(i);
			i++;
		}
		System.out.println("end of program");
	} // end of whileFnc()

	public static void whileFnc2() {
		// while 구문.
		// System.in : 키보드값 입력
		System.out.println("값을 입력하세요. 종료하려면 stop 입력 >>>");
		Scanner scn = new Scanner(System.in);
		while (true) {
			String inputVal = scn.nextLine();
			if (inputVal.equals("stop")) {
				break;
			}
			System.out.println("사용자 입력값 >> " + inputVal);
		}
		System.out.println("end of program");
		// 시스템 자원을 자바가상머신에 반환.
		scn.close();
	} // end of whileFnc2()

	public static void whileFnc3() {
		// 보고싶은 달을 입력. 종료하고 싶으면 -1입력
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("월을 입력하세요. 종료하려면 -1 입력 >>>");
			int input = scn.nextInt();
			if (input == -1) {
				break;
			}
			MethodCalendar.makeCal(input); // 만든 메소드 불러들이기 : class이름.메소드이름()
			System.out.println();
			System.out.println();
		}
		System.out.println("end of program");
		scn.close();
	} // end of whileFnc3()
} // end of class.
