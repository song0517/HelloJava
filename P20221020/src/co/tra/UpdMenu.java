package co.tra;

import java.util.List;
import java.util.Scanner;

public class UpdMenu {
	Scanner scn = new Scanner(System.in);

	public boolean updMenu(String id) {
		TrainingDAO tdao = new TrainingDAO();
		Manager mag = null;
		Student stu = null;
		Training tra = null;
		TraReply traRe = null;

		boolean updLog = false;

		System.out.println("===수정메뉴===");
		// 관리자 계정인지 확인
		
			while (!updLog) {
				System.out.println("·········· 1. 과목 정보 변경 2. 회원 수강 과목 변경 3. 회원정보 변경 4. 처음으로 ··········");
				int updMenu = Util.checkMenu("입력 >>> ");

				if (updMenu == 1) {
					// 2-1
					System.out.println("===과목 정보 변경===");

					if (tdao.getMag(id).getMagId().equals(id)) {
						int traId = Util.checkMenu("변경할 과목ID >>> ");
						System.out.print("변경할 강사 ID >>> ");
						String magId = scn.nextLine();

						if (tdao.getMag(magId).getMagId().equals(magId)) {
							String tName = tdao.getMag(magId).getMagName();
							tra = new Training(traId, null, tName, null, null, 0, 0);
							if (tdao.tNameUpdate(tra) == 1) {
								System.out.println("강사 변경이 완료되었습니다.");
							} else {
								System.out.println("해당 과목이 없습니다.");
							}
						} else {
							System.out.println("해당 ID 강사가 없습니다.");
						}
					} else {
						System.out.println("관리자 권한 페이지입니다.");
					}
				} else if (updMenu == 2) {
					// 2-2
					System.out.println("===회원 수강 과목 변경===");
					// 관리자가 맞는지 확인 후 실행
					if (tdao.getMag(id).getMagId().equals(id)) {
						System.out.print("변경할 회원ID >>> ");
						String stuId = scn.nextLine();
						String name = tdao.getStu(stuId).getStuId();
						if (name.equals(stuId) && !name.equals(null)) {
							int traId1 = tdao.getStu(stuId).getTraId();
							int traId2 = Util.checkMenu("변경할 과목ID >>> ");
//							int traId2 = Integer.parseInt(scn.nextLine());

							if (tdao.traNameSearch(traId2).getTraId() == traId2) {
								if (traId1 != traId2) {
									if (tdao.pluCount(traId2) == 1) {
										tdao.delCount(traId1);
										String traName = tdao.traNameCheck(traId2);
										stu = new Student(stuId, null, null, null, null, traId2, traName);
										tdao.stuUpdate(stu);
										System.out.println("과목이 변경되었습니다.");
										
									} else {
										System.out.println("수강 인원이 초과하여 등록할 수 없습니다.");
//										continue;
									}
								} else {
									System.out.println("수강과목이 같습니다.");
								}
							} else {
								System.out.println("해당 과목ID가 없습니다.");
							}
						} else {
							System.out.println("해당 학생이 없습니다.");
						}
					} else {
						System.out.println("관리자 권한 페이지입니다.");
					}
				} else if (updMenu == 3) {
					// 2-3
					System.out.println("===회원정보 변경===");

					if (tdao.getStu(id).getStuId().equals(id)) {
						System.out.print("수정할 연락처 >>> ");
						String stuPhone = scn.nextLine();
						stu = new Student(id, null, null, stuPhone, null, 0, null);
						tdao.phoneUpdate(stu);
						System.out.println("연락처 변경 완료");

					} else if (tdao.getMag(id).getMagId().equals(id)) {
						System.out.print("수정하고 싶은 회원ID >>> ");
						String stuId = scn.nextLine();
						if (tdao.getStu(stuId).getStuId().equals(stuId)) {
							System.out.print("수정할 연락처 >>> ");
							String stuPhone = scn.nextLine();
							stu = new Student(stuId, null, null, stuPhone, null, 0, null);
							tdao.phoneUpdate(stu);
							System.out.println("연락처 변경 완료");

						} else {
							System.out.println("해당 회원ID 정보가 없습니다.");
						}
					} 
				} else if (updMenu == 4) {
					System.out.println("처음으로 이동합니다.");
					updLog = true;
				} else {
					System.out.println("올바른 메뉴 번호가 아닙니다.");
				}
			}
		return updLog;
	}
}
