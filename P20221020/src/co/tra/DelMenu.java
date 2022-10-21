package co.tra;

import java.util.List;
import java.util.Scanner;

public class DelMenu {
	Scanner scn = new Scanner(System.in);

	public boolean delMenu(String id) {
		TrainingDAO tdao = new TrainingDAO();
		Manager mag = null;
		Student stu = null;
		Training tra = null;
		TraReply traRe = null;

		boolean delLog = false;

		System.out.println("===삭제 메뉴===");
		// 관리자(선생님) 계정인지 확인
		if (tdao.getMag(id).getMagId().equals(id)) {
			while (!delLog) {
				System.out.println("\n·········· 1. 과목 삭제 2. 회원 수강과목 삭제 3. 강사 삭제 4. 처음으로 ··········");
				int deMenu = Util.checkMenu("입력 >>> ");

				if (deMenu == 1) {
					// 4-1 과목 삭제
					System.out.println("===과목 삭제===");
					int traId = Util.checkMenu("삭제하고 싶은 과목ID를 입력하세요. >>> ");
					
					// 다시 물어보기
					System.out.println("'" + traId + "번' 과목을 삭제하시겠습니까?");
					int magCheck = Util.checkMenu("·········· 1. 예 2.아니요 >>> ");

					if (magCheck == 1) {
						//과목 아이디확인
						if (tdao.traDelete(traId) == 1) {
							tdao.stuDelete(traId);
							tdao.trrDelete(traId);
							System.out.println("삭제가 완료되었습니다.");
						} else {
							System.out.println("과목ID가 없습니다.");
						}
					} else if (magCheck == 2) {
						System.out.println("처음화면으로 돌아갑니다.");
					}

				} else if (deMenu == 2) {
					// 4-2 회원 수강과목 삭제
					System.out.println("===회원 수강과목 삭제===");
					System.out.print("삭제할 회원ID 입력 >>> ");
					String stuId = scn.nextLine();

					System.out.println("'" + stuId + "' 계정의 수강항목을 삭제하시겠습니까?");
					int stuCheck = Util.checkMenu("·········· 1. 예 2.아니요 >>> ");

					if (stuCheck == 1) {
						stu = new Student(stuId, null, null, null, null, 0, "");
						int traId = tdao.getStu(stuId).getTraId();
						tdao.delCount(traId);
						// 회원 계정ID 확인
						if (tdao.stuUpdate(stu) == 1) {
							System.out.println("삭제가 완료되었습니다.");
						} else {
							System.out.println("회원 계정이 없습니다.");
						}
					} else if (stuCheck == 2) {
						System.out.println("처음화면으로 돌아갑니다.");
					}
				} else if (deMenu == 3) {
					// 4-3 강사 계정 삭제
					System.out.println("===강사 계정 삭제===");
					System.out.print("삭제할 강사ID 입력 >>> ");
					String magId = scn.nextLine();

					System.out.println("'" + magId + "' 계정을 삭제하시겠습니까?");
					int magCheck = Util.checkMenu("·········· 1. 예 2.아니요 >>> ");
					int count = 0;

					if (magCheck == 1) {
						List<Training> trains = tdao.traSearch();
						
						// 수업 중인 과목 있는지 확인
						for (Training tr : trains) {
							if (tr.gettName().equals(tdao.getMag(magId).getMagName())) {
								count = 1;
							}
						}
						
						if (count == 1) {
							System.out.println("수업 중인 과목이 있어 삭제할 수 없습니다.");
						}

						if (count == 0) {
							// 관리자(선생님) 계정 확인
							if (tdao.magDelete(magId) == 1) {
								System.out.println("삭제가 완료되었습니다.");
							} else {
								System.out.println("관리자 계정이 없습니다.");
							}
						}
					} else if (magCheck == 2) {
						System.out.println("취소합니다.");
					}
				} else if (deMenu == 4) {
					System.out.println("처음으로 이동합니다.");
					delLog = true;
				} else {
					System.out.println("올바른 메뉴 번호가 아닙니다.");
				}
			}
		} else {
			System.out.println("관리자 권한 페이지입니다.");
			delLog = true;
		}
		return delLog;
	}
}
