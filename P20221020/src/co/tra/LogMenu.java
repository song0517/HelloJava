package co.tra;

import java.util.List;
import java.util.Scanner;

public class LogMenu {
	Scanner scn = new Scanner(System.in);

	public String logMenu(String prompt) {
		TrainingDAO tdao = new TrainingDAO();
		Manager mag = null;
		Student stu = null;

		String id = null;
		String pw = null;
		boolean cklog = false;
		int check = 0;
		
		while (!cklog) {
			System.out.println("·········· 1.회원가입 2.로그인 3. 비밀번호 찾기 4.종료 ··········");
			int logmenu = Util.checkMenu("입력 >>> ");

			// 1. 회원가입 과정
			if (logmenu == 1) {
				System.out.println("·········· 1.관리자 계정 2.회원 계정 ··········");

				int accmenu = Util.checkMenu("입력 >>> ");
				if (accmenu == 1) {
					// 1-1. 관리자 계정
					System.out.println("===관리자 계정 회원가입===");
					System.out.print("관리자 ID 입력 >>> ");
					String magId = scn.nextLine();
					if (tdao.getMag(magId).getMagId().equals(magId)) {
						System.out.println("동일한 관리자ID가 있습니다.");
					} else {
						System.out.print("관리자 PW 입력 >>> ");
						String magPw = scn.nextLine();
						System.out.print("관리자 이름 입력 >>> ");
						String magName = scn.nextLine();

						mag = new Manager(magId, magPw, magName);
						tdao.magInsert(mag);
						System.out.println("관리자 회원가입 완료!");
					}
				} else if (accmenu == 2) {
					// 1-2. 회원 계정
					System.out.println("===회원 계정 회원가입===");
					System.out.print("회원 ID 입력 >>> ");
					String stuId = scn.nextLine();
					if (tdao.getStu(stuId).getStuId().equals(stuId)) {
						System.out.println("동일한 학생ID가 있습니다.");
					} else {
						System.out.print("회원 PW 입력 >>> ");
						String stuPw = scn.nextLine();
						System.out.print("회원 이름 입력 >>> ");
						String stuName = scn.nextLine();
						System.out.print("회원 연락처 입력 >>> ");
						String stuPhone = scn.nextLine();
						System.out.print("회원 생년월일 입력 >>> ");
						String stuBir = scn.nextLine();

						stu = new Student(stuId, stuPw, stuName, stuPhone, stuBir, 0, null);
						tdao.stuInsert(stu);
						System.out.println("회원 회원가입 완료!");
					}
				} else {
					// 번호 잘못 눌렀을 경우
					System.out.println("잘못된 메뉴 번호입니다. 다시 입력해 주세요.");
				}
			} else if (logmenu == 2) {
				// 1-2. 로그인 과정
				System.out.println("·········· 로그인 계정을 선택해 주세요 : 1. 관리자 2. 회원 ··········");
				int accCkMenu = Util.checkMenu("입력 >>> ");
				if (accCkMenu == 1) {
					// 2-1. 관리자 계정 로그인
					System.out.println("===관리자 계정===");
					System.out.print("관리자 ID 입력 >>> ");
					id = scn.nextLine();
					System.out.print("관리자 PW 입력 >>> ");
					pw = scn.nextLine();

					mag = new Manager(id, pw, null);
					List<Manager> mags = tdao.magList(mag);

					if (mags.size() == 1) {
						cklog = true;
						System.out.println("관리자계정 로그인 완료.");
					} else {
						System.out.println("등록되어 있지 않은 정보입니다.");
					}

				} else if (accCkMenu == 2) {
					// 2-2. 회원 계정 로그인
					System.out.println("===회원 계정===");
					System.out.print("회원 ID 입력 >>> ");
					id = scn.nextLine();
					System.out.print("회원 PW 입력 >>> ");
					pw = scn.nextLine();

					check = tdao.stuCheck(id, pw);
					if (check == 1) {
						cklog = true;
						System.out.println("회원계정 로그인 완료.");
						if (pw.equals("5080")) {
							System.out.println("===임시 비밀번호를 수정해 주세요.===");
							System.out.print("수정할 비밀번호 >>> ");
							String upPw = scn.nextLine();
							tdao.pwdUpdate(new Student(id, upPw, null, null, null, 0, null));
							System.out.println("새로운 비밀번호를 메일로 보냈습니다.");
						}
					} else {
						// 번호 잘못 눌렀을 경우
						System.out.println("등록되어 있지 않은 정보입니다.");
					}
				} else {
					System.out.println("잘못된 메뉴 번호입니다. 다시 입력해 주세요.");
				}
			} else if (logmenu == 3) {
				System.out.println("===비밀번호 재발급===");
				System.out.print("ID >>> ");
				String stuId = scn.nextLine();
				if (tdao.getStu(stuId).getStuId().equals(stuId)) {
					System.out.print("임시 비밀번호 발급받을 이메일 >>> ");
					String email = scn.nextLine();
					String upPw = "5080";
					MailApp app = new MailApp();
					app.sendMail("songj137@naver.com", email, "비밀번호 재설정", upPw);

					tdao.pwdUpdate(new Student(stuId, upPw, null, null, null, 0, null));
					System.out.println("새로운 비밀번호를 메일로 보냈습니다.");

				} else {
					System.out.println("해당 ID가 없습니다.");
				}
			} else if (logmenu == 4) {
				// 3. 종료
				System.out.println("프로그램을 종료합니다.");
				cklog = true;
				id = "4";
			} else {
				System.out.println("잘못된 메뉴 번호입니다. 다시 입력해주세요.");
			}
		}
		return id;
	}
}
