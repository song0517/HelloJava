package co.tra;

import java.util.List;
import java.util.Scanner;

public class TrainingApp {
	public static void main(String[] args) {
		TrainingDAO tdao = new TrainingDAO();
		LogMenu log = new LogMenu();
		InsMenu ins = new InsMenu();
		UpdMenu upd = new UpdMenu();
		SelMenu sel = new SelMenu();
		DelMenu del = new DelMenu();
		
		Manager mag = null;
		Student stu = null;
		Training tra = null;
		TraReply traRe = null;

		Scanner scn = new Scanner(System.in);

		String id = null;
		String pw = null;
		boolean cklog = false;

		int check = 0;

		// 처음 화면
		while (!cklog) {
			// 회원가입 & 로그인 메뉴
			id = log.logMenu("·········· 1.회원가입 2.로그인 3. 비밀번호 찾기 4.종료 ··········");
			if (id.equals("4")) {
				break;
			}

			// 메인 메뉴
			while (true) {
				System.out.println("·········· 1. 등록 2. 수정 3. 조회 4. 삭제 9. 종료 ··········");
				int mainMenu = Util.checkMenu("입력 >>> ");

				// 1. 등록 메뉴
				if (mainMenu == 1) {
					cklog = false;
					while(!cklog) {
						cklog = ins.insMenu(id);
					}
				} else if (mainMenu == 2) {
					// 2. 수정메뉴
					cklog = false;
					while(!cklog) {
						cklog = upd.updMenu(id);
					}
				} else if (mainMenu == 3) {
					// 3. 조회 메뉴
					cklog = false;
					while(!cklog) {
						cklog = sel.selMenu(id);
					}
				} else if (mainMenu == 4) {
					// 4. 삭제메뉴
					cklog = false;
					while(!cklog) {
						cklog = del.delMenu(id);
					}
				} else if (mainMenu == 9) {
					// 9. 종료
					System.out.println("종료");
					cklog = true;
					break;
				} else {
					System.out.println("올바른 메뉴 번호가 아닙니다.");
				}
			} // end of while (true) 메인 메뉴 부분
		} // end of while (!cklog) 로그인 부분
	}
}
