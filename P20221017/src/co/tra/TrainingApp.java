package co.tra;

import java.util.Scanner;

public class TrainingApp {
	public static void main(String[] args) {
		TrainingDAO tdao = new TrainingDAO();
		Manager mag = null;
		Student stu = null;
		Training tra = null;
		TraReply traRe = null;

		Scanner scn = new Scanner(System.in);

		boolean cklog = false;

		// 처음
		while (!cklog) {
			System.out.println("메뉴 : 1. 회원가입 2. 로그인");
			int logmenu = Integer.parseInt(scn.nextLine());
			// 회원가입
			if (logmenu == 1) {
				System.out.println("1. 관리자 계정 2. 회원 계정");
				int accmenu = Integer.parseInt(scn.nextLine());
				if (accmenu == 1) {
					// 관리자 계정
					System.out.println("===관리자 계정 회원가입===");
					System.out.print("관리자 ID 입력 >>> ");
					String magId = scn.nextLine();
					System.out.print("관리자 PW 입력 >>> ");
					String magPw = scn.nextLine();
					System.out.print("관리자 이름 입력 >>> ");
					String magName = scn.nextLine();

					mag = new Manager(magId, magPw, magName);
					tdao.magInsert(mag);

				} else if (accmenu == 2) {
					// 회원 계정
					System.out.println("===회원 계정 회원가입===");
					System.out.println("회원 ID 입력 >>> ");
					String stuId = scn.nextLine();
					System.out.println("회원 PW 입력 >>> ");
					String stuPw = scn.nextLine();
					System.out.println("회원 이름 입력 >>> ");
					String stuName = scn.nextLine();
					System.out.println("회원 연락처 입력 >>> ");
					String stuPhone = scn.nextLine();
					System.out.println("회원 생년월일 입력 >>> ");
					String stuBir = scn.nextLine();

					stu = new Student(stuId, stuPw, stuName, stuPhone, stuBir, 0, null);
					tdao.stuInsert(stu);

				} else {
					System.out.println("잘못된 메뉴 번호입니다. 다시 입력해 주세요.");
					continue;
				}
			} else if (logmenu == 2) {
				// 로그인
				System.out.println("로그인 계정을 선택해 주세요 : 1. 관리자 2. 회원");
				int accCkMenu = Integer.parseInt(scn.nextLine());
				if (accCkMenu == 1) {
					// 관리자 계정 로그인
					System.out.println("===관리자 계정===");
					System.out.print("관리자 ID 입력 >>> ");
					String id = scn.nextLine();
					System.out.print("관리자 PW 입력 >>> ");
					String pw = scn.nextLine();

					int check = tdao.magCheck(id, pw);
					if (check == 1) {
						cklog = true;
						System.out.println("관리자계정 로그인 완료.");
					} else {
						System.out.println("등록되어 있지 않은 정보입니다.");
						continue;
					}
				} else if (accCkMenu == 2) {
					// 회원 계정
					System.out.println("===회원 계정===");
					System.out.println("회원 ID 입력 >>> ");
					String Id = scn.nextLine();
					System.out.println("회원 PW 입력 >>> ");
					String Pw = scn.nextLine();

					int check = tdao.stuCheck(Id, Pw);
					if (check == 1) {
						cklog = true;
						System.out.println("회원계정 로그인 완료.");
					} else {
						System.out.println("등록되어 있지 않은 정보입니다.");
						continue;
					}
				} else {
					System.out.println("잘못된 메뉴 번호입니다. 다시 입력해 주세요.");
					continue;
				}
				while (true) {
					System.out.println("메뉴: 1. 등록 2. 수정 3. 조회 4. 후기 작성 5. 삭제 9. 종료");
					System.out.print("입력 >>> ");
					int mainMenu = Integer.parseInt(scn.nextLine());

					if (mainMenu == 1) {
						System.out.println("등록메뉴");
					}
				}
			}
		}
	}
}
