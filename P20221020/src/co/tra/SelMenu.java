package co.tra;

import java.util.List;
import java.util.Scanner;

public class SelMenu {
	Scanner scn = new Scanner(System.in);

	public boolean selMenu(String id) {
		TrainingDAO tdao = new TrainingDAO();
		Manager mag = null;
		Student stu = null;
		Training tra = null;
		TraReply traRe = null;

		boolean selLog = false;

		System.out.println("===조회메뉴===");
		// 관리자 계정인지 확인
		while (!selLog) {
			System.out.println(
					"\n·········· 1. 과목 전체 2. 회원 전체 3. 강사 전체 4. 특정 과목 조회 5. 과목별 수강 회원 조회 6. 특정 회원 조회 7. 작성한 댓글 확인 8. 처음으로 ··········");
			int selMenu = Util.checkMenu("입력 >>> ");
			if (selMenu == 1) {
				// 3-1 과목 전체 조회
				System.out.println("===과목 전체 조회===");
				PagingVO pag = new PagingVO();

				boolean check = false;
				int total = tdao.countTra();
				int nowPage = 0;
				int cntPerPage = 0;
				
				// 페이징 작업
				System.out.println("=== 1page ===");
				if (nowPage == 0 && cntPerPage == 0) {
					nowPage = 1;
					cntPerPage = 5;
				} else if (nowPage == 0) {
					nowPage = 1;
				} else if (cntPerPage == 0) {
					cntPerPage = 5;
				}
				pag = new PagingVO(total, nowPage, cntPerPage);

				List<Training> trains = tdao.traList(pag);

				for (Training tr : trains) {
					System.out.println(tr.toString());
				}

				while (!check) {
					nowPage = 0;
					cntPerPage = 0;
					int totalPage = (int) Math.ceil(total / 5.0);
					System.out.println("\n 전체 페이지 : " + totalPage);
					System.out.println("조회를 종료하고 싶을 경우 '0'을 입력해주세요.");
					// 조회하고 싶은 페이지 입력
					int num = Util.checkMenu("조회하고 싶은 페이지 >>> ");
					
					if (num > totalPage) {
						System.out.println("총 페이지 수보다 많습니다.");
					} else if (num == 0) {
						System.out.println("조회를 종료합니다.");
						check = true;
					} else {
						System.out.println("=== " + num + "page ===");
						if (nowPage == 0 && cntPerPage == 0) {
							nowPage = num;
							cntPerPage = 5;
						} else if (nowPage == 0) {
							nowPage = num;
						} else if (cntPerPage == 0) {
							cntPerPage = 5;
						}
						pag = new PagingVO(total, nowPage, cntPerPage);

						List<Training> trains2 = tdao.traList(pag);

						for (Training tr : trains2) {
							System.out.println(tr.toString());
						}
					}
				}

			} else if (selMenu == 2) {
				// 3-2 회원 전체 조회
				System.out.println("===회원 전체 조회===");

				// 관리자 확인
				if (tdao.getMag(id).getMagId().equals(id)) {
					// 페이징 작업
					PagingVO pag = new PagingVO();

					boolean check = false;
					int total = tdao.countStu();
					int nowPage = 0;
					int cntPerPage = 0;
					
					System.out.println("=== 1page ===");
					if (nowPage == 0 && cntPerPage == 0) {
						nowPage = 1;
						cntPerPage = 5;
					} else if (nowPage == 0) {
						nowPage = 1;
					} else if (cntPerPage == 0) {
						cntPerPage = 5;
					}
					pag = new PagingVO(total, nowPage, cntPerPage);

					List<Student> stus = tdao.stuSearch(pag);

					for (Student st : stus) {
						System.out.println(st.toString());
					}

					while (!check) {
						nowPage = 0;
						cntPerPage = 0;
						int totalPage = (int) Math.ceil(total / 5.0);
						System.out.println("\n 전체 페이지 : " + totalPage);
						System.out.println("조회를 종료하고 싶을 경우 '0'을 입력해주세요.");
						// 조회하고 싶은 페이지 입력
						int num = Util.checkMenu("조회하고 싶은 페이지 >>> ");
						
						if (num > totalPage) {
							System.out.println("총 페이지 수보다 많습니다.");
						} else if (num == 0) {
							System.out.println("조회를 종료합니다.");
							check = true;
						} else {
							System.out.println("=== " + num + "page ===");
							if (nowPage == 0 && cntPerPage == 0) {
								nowPage = num;
								cntPerPage = 5;
							} else if (nowPage == 0) {
								nowPage = num;
							} else if (cntPerPage == 0) {
								cntPerPage = 5;
							}
							pag = new PagingVO(total, nowPage, cntPerPage);

							List<Student> stus2 = tdao.stuSearch(pag);

							for (Student st : stus2) {
								System.out.println(st.toString());
							}
						}
					}
				} else {
					System.out.println("관리자 권한 페이지입니다.");
				}

			} else if (selMenu == 3) {
				// 3-3 강사 전체 조회
				System.out.println("===강사 전체 조회===");
				List<Manager> mags = tdao.magSearch();

				for (Manager mg : mags) {
					System.out.println("강사ID : " + mg.getMagId() + ", 강사 이름: " + mg.getMagName());
				}
				
			} else if (selMenu == 4) {
				// 3-4 특정 과목 조회
				System.out.println("===특정 과목 조회===");
				int traId = Util.checkMenu("조회하고 싶은 과목ID >>> ");

				if (tdao.traNameSearch(traId).getTraId() == traId) {
					System.out.println(tdao.traNameSearch(traId));

					// 후기조회
					System.out.println("===후기===");
					List<TraReply> trReply = tdao.reSearch(traId);
					if (trReply.size() == 0) {
						System.out.println("● 후기가 없습니다.");
					}

					for (TraReply res : trReply) {
						System.out.println("● " + res);
					}

					// 후기작성
					System.out.println("\n ·········· Q: 1. 후기작성 2. 종료 ··········");
					int trr = Util.checkMenu(">>> ");

					if (trr == 1) {
						// 관리자는 후기 작성X, 회원인지 확인
						if (tdao.getStu(id).getStuId().equals(id)) {
							// 3-4-1
							System.out.print("후기 내용 >>> ");
							String reContent = scn.nextLine();

							String reWriter = id;
							traRe = new TraReply(0, traId, reContent, reWriter, null);

							tdao.reInsert(traRe);
							System.out.println("후기를 추가했습니다.");
						} else {
							System.out.println("회원만 후기 작성이 가능합니다.");
							continue;
						}
					} else if (trr == 2) {
						// 3-4-2
						System.out.println("메뉴로 돌아갑니다.");
						continue;
					} else {
						System.out.println("잘못된 번호입니다.");
						continue;
					}
				} else {
					System.out.println("해당 과목ID가 없습니다.");
				}
			} else if (selMenu == 5) {
				// 3-5 과목별 수강회원조회
				System.out.println("===과목별 수강 회원 조회===");
				// 관리자 확인
				if (tdao.getMag(id).getMagId().equals(id)) {
					int traId = Util.checkMenu("조회하고 싶은 과목ID 입력>>> ");
					// 과목 ID 확인
					if (tdao.traNameSearch(traId).getTraId() == traId) {

						List<Student> stus = tdao.traStu(traId);

						for (Student st : stus) {
							System.out.println(st.toString());
						}
					} else {
						System.out.println("해당 과목ID가 없습니다.");
					}
				} else {
					System.out.println("관리자 권한 페이지입니다.");
				}

			} else if (selMenu == 6) {
				// 3-6 특정 회원 조회
				System.out.println("===특정 회원 조회===");
				// 회원일 경우 자신의 정보만 조회
				if (tdao.getStu(id).getStuId().equals(id)) {
					System.out.println(tdao.getStu(id));
				} else if (tdao.getMag(id).getMagId().equals(id)) {
					//관리자일 경우 조회하고 싶은 회원ID 호가인
					System.out.print("조회하고 싶은 회원ID >>> ");
					String stuId = scn.nextLine();
					
					// 회원ID 확인
					if (tdao.getStu(stuId).getStuId().equals(stuId)) {
						System.out.println(tdao.getStu(stuId));
					} else {
						System.out.println("해당 회원ID 정보가 없습니다.");
					}
				}

			} else if (selMenu == 7) {
				// 3-7 작성한 후기 조회
				System.out.println("===자신이 작성한 후기 조회===");
				
				// 관리자(강사)는 후기가 없다.
				if (tdao.getMag(id).getMagId().equals(id)) {
					System.out.println("선생님은 후기가 없습니다.");
				} else {
					// 회원계정일 경우
					List<TraReply> trReply = tdao.reWrSearch(id);
					if (trReply.size() == 0) {
						System.out.println("● 후기가 없습니다.");
					}
					for (TraReply res : trReply) {
						System.out.println("● " + res);
					}

					System.out.println("\n ·········· Q: 1. 후기 수정 2. 후기 삭제 3. 종료 ··········");
					int reUp = Util.checkMenu(">>> ");
					int count = 0;

					if (reUp == 1) {
						int reNum = Util.checkMenu("수정하고 싶은 후기 번호 입력 >>> ");

						// 자신이 작성한 것인지 확인
						for (TraReply res : trReply) {
							if (reNum == res.getTraSeq()) {
								System.out.print("수정할 후기 내용 >>> ");
								String reContent = scn.nextLine();

								traRe = new TraReply(reNum, 0, reContent, null, null);

								tdao.trUpdate(traRe);
								System.out.println("후기를 수정했습니다.");
								count = 1;
							}
						}

						if (count == 0) {
							System.out.println("수정할 수 있는 후기가 없습니다.");
						}

					} else if (reUp == 2) {
						int dlNum = Util.checkMenu("삭제하고 싶은 후기 번호 입력 >>> ");

						// 자신이 작성한 것인지 확인
						for (TraReply res : trReply) {
							if (dlNum == res.getTraSeq()) {
								tdao.trSeDelete(dlNum);
								System.out.println("후기를 삭제했습니다.");
								count = 1;
							}
						}
						if (count == 0) {
							System.out.println("삭제할 수 있는 번호가 없습니다.");
						}
					} else if (reUp == 3) {
						System.out.println("처음메뉴로 이동합니다.");
					}
				}
			} else if (selMenu == 8) {
				System.out.println("처음메뉴로 이동합니다.");
				selLog = true;
			} else {
				System.out.println("잘못된 메뉴 번호입니다.");
			}
		}
		return selLog;
	}
}
