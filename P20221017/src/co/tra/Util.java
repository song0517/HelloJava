package co.tra;

import java.util.Scanner;

public class Util {
	// 스캐너로 해서 체크
	// 정상 -> 입력된 값 리턴
	static Scanner scn = new Scanner(System.in);
	public static int checkMenu(String prompt) {
		System.out.print(prompt);
		int menu = -1;
		while (true) {
			try {
				menu = Integer.parseInt(scn.nextLine());
				return menu;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
				System.out.println("입력 >>> ");
			}
		}
	}
}
