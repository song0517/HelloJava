package co.tra;

import java.util.List;
import java.util.Scanner;

public class InsMenu {
	Scanner scn = new Scanner(System.in);

	public boolean insMenu(String id) {
		TrainingDAO tdao = new TrainingDAO();
		Manager mag = null;
		Student stu = null;
		Training tra = null;
		TraReply traRe = null;

		boolean insLog = false;

		System.out.println("===등록메뉴===");
		// 관리자 계정인지 확인
		if (tdao.getMag(id).getMagId().equals(id)) {
			while (!insLog) {
				System.out.println("\n·········· 1. 과목 등록 2. 회원 수강과목 등록 3. 처음으로 ··········");
				int regMenu = Util.checkMenu("입력 >>> ");
				if (regMenu == 1) {
					// 1-1. 과목 등록 메뉴
					System.out.println("===과목 등록===");
					int traId = Util.checkMenu("과목 ID 입력 >>> ");
					// 동일한 과목 있는지 확인
					if (tdao.traNameSearch(traId).getTraId() == traId) {
						System.out.println("동일한 과목ID가 있습니다.");
					} else {
						System.out.print("과목 이름 입력 >>> ");
						String traName = scn.nextLine();
						System.out.print("강사 ID 입력 >>> ");
						String magId = scn.nextLine();
						
						//강사 ID 있는지 확인
						if (tdao.getMag(magId).getMagId().equals(magId)) {
							String tName = tdao.getMag(magId).getMagName();
							System.out.print("교육 시간 입력 >>> ");
							String traTime = scn.nextLine();
							System.out.print("교육 요일 입력 >>> ");
							String traDay = scn.nextLine();
							int stCo = Util.checkMenu("수강 가능 인원 입력 >>> ");

							tra = new Training(traId, traName, tName, traTime, traDay, stCo, 0);
							tdao.tarInsert(tra);
							System.out.println("수강등록 완료!");

						} else {
							System.out.println("해당 ID 강사가 없습니다. 확인해 주세요.");
						}
					}
				} else if (regMenu == 2) {
					// 1-2. 회원 수강과목 등록
					System.out.println("===회원 수강과목 등록===");
					System.out.print("등록할 회원ID >>> ");
					String stuId = scn.nextLine();
					
					// 회원 계정 확인
					if (tdao.getStu(stuId).getStuId().equals(stuId)) {
						int traId = Util.checkMenu("수강신청할 과목ID >>> ");

						// ID에 맞는 수강과목 찾기
						String traName = tdao.traNameCheck(traId);
						// 수강과목 ID가 없을 경우
						if(traName == null) {
							System.out.println("해당 과목ID는 없습니다. ");
							continue;
						}

						// 수강 인원 추가, 수강생 초과일 경우 등록하지 못함.
						if (tdao.pluCount(traId) == 1) {
							stu = new Student(stuId, null, null, null, null, traId, traName);
							tdao.stuUpdate(stu);
							System.out.println("수강 등록 완료!");

						} else {
							System.out.println("수강 인원이 초과하여 등록할 수 없습니다.");
						}
					} else {
						System.out.println("해당 회원ID 정보가 없습니다.");
					}
				} else if (regMenu == 3) {
					System.out.println("처음으로 이동합니다.");
					insLog = true;
				} else {
					System.out.println("올바른 메뉴 번호가 아닙니다.");
				}
			}
		} else {
			System.out.println("관리자 권한 페이지입니다.");
			insLog = true;
		}
		return insLog;
	}
}
