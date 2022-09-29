package co.edu.variable;

import java.util.Scanner;

public class WhileBank {
	public static void main(String[] args) {
		bankApp();
	}

	// 입출금기능
	public static void bankApp() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int money = 0;
		// 메뉴 : 1)예금 2)출금 3)잔고확인 4)종료
		// 10만원이 넘으면 예금안됨. 잔고보다 더 많은 돈을 출금하지 못한다.
		while (run) {
			System.out.println("메뉴 [1.예금 2.출금 3.잔고확인 4.종료]");
			int menu = scn.nextInt();

			switch (menu) {
			case 1:
				System.out.println("예금처리 메뉴");
				System.out.println("예금액을 입력 >>> ");
				int input = scn.nextInt();
				if (input % 1000 != 0) {
					System.out.println("1000단위로 입금해주세요.");
					break;
				} else {
						money += input;
						if (money > 100000) {
							System.out.println("10만원이 넘어 예금하지 못합니다.");
							money -= input;
						}
				}
				break;
			case 2:
				System.out.println("출굼처리 메뉴");
				System.out.println("출금액을 입력 >>> ");
				int input2 = scn.nextInt();
				if (input2 % 1000 != 0) {
					System.out.println("1000단위로 입금해주세요.");
					break;
				} else if (money < input2) {
						System.out.println("잔액이 부족하여 출금하지 못합니다.");
						break;
				} else {
						money -= input2;
				}
				break;
			case 3:
				System.out.println("잔고조회 메뉴");
				System.out.println("현재 잔고는 : " + money + "원입니다.");
				break;
			case 4:
				System.out.println("종료 메뉴");
				run = false;
			}
		} // end of while
		System.out.println("end of program");
	} // end of bankApp

} // end of class.
