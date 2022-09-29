package co.edu.variable;

import java.util.Scanner;

// 계좌정보 선언 : 계좌번호, 예금주, 잔고
// 은행에 계좌생성: Account[] banks; 배열선언
public class WhileBankApp {
	public static void main(String[] args) {
		// 메뉴 : 0.계좌번호생성 1.예금 2.출금 3.잔액 4.종료
		Account[] banks = new Account[10];

		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("메뉴 : 0.계좌번호생성 1.예금 2.출금 3.잔액 4.종료");
			int menu = scn.nextInt();
			scn.nextLine();

			if (menu == 1) {
				// 예금가능, 어떤 계좌번호에 얼마를 넣을 것인가?
				System.out.println("계좌번호>>> ");
				String accNo = scn.nextLine();
				System.out.println("예금할 금액>>> ");
				int money = scn.nextInt();
				boolean check = true;

				for (int i = 0; i < banks.length; i++) {
					if (banks[i] != null && banks[i].accNO.equals(accNo)) {
						if (money % 1000 == 0) {
							banks[i].balance = banks[i].balance + money;
							check = false;
						} else {
							System.out.println("1000단위로 입금가능합니다.");
							break;
						}
					}
				}
				
				if(check) {
					System.out.println("계좌가 없습니다.");
				}
				
			} else if (menu == 2) {
				System.out.println("계좌번호>>> ");
				String accNo = scn.nextLine();
				System.out.println("출금할 금액>>> ");
				int money = scn.nextInt();
				boolean check = true;
				
				for (int i = 0; i < banks.length; i++) {
					if (banks[i] != null && banks[i].accNO.equals(accNo)) {
						if (money % 1000 != 0) {
							System.out.println("1000단위로 출금가능합니다.");
							break;
						} else if (banks[i].balance < money) {
							System.out.println("잔고가 부족합니다.");
							break;
						} else {
							banks[i].balance = banks[i].balance - money;
							check = false;
						}
					}
				}
				
				if(check) {
					System.out.println("계좌가 없습니다.");
				}
			} else if (menu == 3) {
				System.out.println("조회할 계좌번호 입력>>> ");
				String accNo = scn.nextLine();
				boolean check = true;

				for (int i = 0; i < banks.length; i++) {
					if (banks[i] != null && banks[i].accNO.equals(accNo)) {
						System.out.println("잔액 : " + banks[i].balance);
						check = false;
					}
				}
				if(check) {
					System.out.println("계좌가 없습니다.");
				}
			} else if (menu == 4) {
				break;
			} else if (menu == 0) {
				System.out.println("계좌번호입력>>> ");
				String accNo = scn.nextLine();
				System.out.println("예금주>>> ");
				String Owner = scn.nextLine();

				Account acc = new Account(); // 인스턴스 생성.
				acc.accNO = accNo;
				acc.Owner = Owner;

				for (int i = 0; i < banks.length; i++) {
					if (banks[i] == null) {
						// 한건입력 후 break;
						banks[i] = acc;
						break;
					}
				}
				System.out.println("계좌 생성이 완료되었습니다.");
			}
		}
	}
}