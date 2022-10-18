package co.tra;

import java.util.List;
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
		String id = null;
		String pw = null;
		int check = 0;

		// 처음 화면
		while (!cklog) {
			System.out.println("메뉴 : 1. 회원가입 2. 로그인 3.종료");
			int logmenu = Util.checkMenu("입력 >>> ");

			// 1. 회원가입 과정
			if (logmenu == 1) {
				System.out.println("1. 관리자 계정 2. 회원 계정");

				int accmenu = Util.checkMenu("메뉴를 입력하세요>> ");
				if (accmenu == 1) {
					// 1-1. 관리자 계정
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
					// 1-2. 회원 계정
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
					// 번호 잘못 눌렀을 경우
					System.out.println("잘못된 메뉴 번호입니다. 다시 입력해 주세요.");
					continue;
				}
			} else if (logmenu == 2) {
				// 1-2. 로그인 과정
				System.out.println("로그인 계정을 선택해 주세요 : 1. 관리자 2. 회원");
				System.out.print("입력 >>> ");
				int accCkMenu = Util.checkMenu("입력 >>> ");
				if (accCkMenu == 1) {
					// 2-1. 관리자 계정 로그인
					System.out.println("===관리자 계정===");
					System.out.print("관리자 ID 입력 >>> ");
					id = scn.nextLine();
					System.out.print("관리자 PW 입력 >>> ");
					pw = scn.nextLine();

					check = tdao.magCheck(id, pw);
					if (check == 1) {
						cklog = true;
						System.out.println("관리자계정 로그인 완료.");
					} else {
						System.out.println("등록되어 있지 않은 정보입니다.");
						continue;
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
					} else {
						// 번호 잘못 눌렀을 경우
						System.out.println("등록되어 있지 않은 정보입니다.");
						continue;
					}
				}
			} else if (logmenu == 3) {
				// 3. 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴 번호입니다. 다시 입력해주세요.");
				continue;
			}

			while (true) {
				System.out.println("메뉴: 1. 등록 2. 수정 3. 조회 4. 삭제 9. 종료");
				System.out.print("입력 >>> ");
				int mainMenu = Util.checkMenu("입력 >>> ");

				// 1. 등록 메뉴
				if (mainMenu == 1) {
					System.out.println("===등록메뉴===");
					// 관리자 계정인지 확인
					check = tdao.magCheck(id, pw);
					if (check == 1) {
//							System.out.println("관리자계정 로그인 완료.");
						System.out.println("등록 메뉴 : 1. 과목 등록 2. 회원 수강과목 등록");
						int regMenu = Util.checkMenu("입력 >>> ");
						if (regMenu == 1) {
							// 1-1. 과목 등록 메뉴
							System.out.println("===과목 등록===");
							System.out.print("과목 ID 입력 >>> ");
							int traId = Integer.parseInt(scn.nextLine());
							System.out.print("과목 이름 입력 >>> ");
							String traName = scn.nextLine();
							System.out.print("강사 입력 >>> ");
							String tName = scn.nextLine();
							System.out.print("교육 시간 입력 >>> ");
							String traTime = scn.nextLine();
							System.out.print("교육 요일 입력 >>> ");
							String traDay = scn.nextLine();
							System.out.print("수강 가능 인원 입력 >>> ");
							int stCo = Integer.parseInt(scn.nextLine());

							tra = new Training(traId, traName, tName, traTime, traDay, stCo, 0);
							tdao.tarInsert(tra);
						} else if (regMenu == 2) {
							// 1-2. 회원 수강과목 등록
							System.out.println("===회원 수강과목 등록===");
							System.out.print("등록할 회원ID >>> ");
							String stuId = scn.nextLine();
							System.out.print("수강신청할 과목ID >>> ");
							int traId = Integer.parseInt(scn.nextLine());

							// ID에 맞는 수강과목 찾기
							String traName = tdao.traNameCheck(traId);

							// 수강 인원 추가, 수강생 초과일 경우 등록하지 못함.
							if (tdao.pluCount(traId) == 1) {
								stu = new Student(stuId, null, null, null, null, traId, traName);
								tdao.stuUpdate(stu);
							} else {
								System.out.println("수강 인원이 초과하여 등록할 수 없습니다.");
								continue;
							}
						}
					} else {
						// 관리자 계정이 아닐경우
						System.out.println("관리자 권한 페이지입니다.");
						continue;
					}
				} else if (mainMenu == 2) {
					// 2. 수정메뉴
					System.out.println("===수정메뉴===");
					System.out.println("1. 과목 정보 변경 2. 회원 수강 과목 변경 3. 회원정보 변경");
					int updMenu = Util.checkMenu("입력 >>> ");

					if (updMenu == 1) {
						// 2-1
						System.out.println("===과목 정보 변경===");

						// 관리자가 맞는지 확인 후 실행
						check = tdao.magCheck(id, pw);
						if (check == 1) {
							System.out.print("변경할 강사 과목ID >>> ");
							int traId = Integer.parseInt(scn.nextLine());
							System.out.print("변경할 강사 이름 >>> ");
							String tName = scn.nextLine();

							tra = new Training(traId, null, tName, null, null, 0, 0);
							tdao.tNameUpdate(tra);

						} else {
							System.out.println("관리자 권한 페이지입니다.");
						}
					} else if (updMenu == 2) {
						// 2-2
						System.out.println("===회원 수강 과목 변경===");

						// 관리자가 맞는지 확인 후 실행
						check = tdao.magCheck(id, pw);
						if (check == 1) {
							System.out.print("변경할 회원ID >>> ");
							String stuId = scn.nextLine();
							String name = tdao.getStu(stuId).getStuId();
							if (name.equals(stuId) && !name.equals(null)) {
								int traId1 = tdao.getStu(stuId).getTraId();
								System.out.print("변경할 수강ID >>> ");
								int traId2 = Integer.parseInt(scn.nextLine());

								if (traId1 != traId2) {
									if (tdao.pluCount(traId2) == 1) {
										tdao.delCount(traId1);
										String traName = tdao.traNameCheck(traId2);
										System.out.println(traName);
										stu = new Student(stuId, null, null, null, null, traId2, traName);
										tdao.stuUpdate(stu);
									} else {
										System.out.println("수강 인원이 초과하여 등록할 수 없습니다.");
										continue;
									}
								} else {
									System.out.println("수강과목이 같습니다.");
								}
							} else {
								System.out.println("헤당 학생이 없습니다.");
							}
						} else {
							System.out.println("관리자 권한 페이지입니다.");
						}
					} else if (updMenu == 3) {
						// 2-3
						System.out.println("===회원정보 변경===");
						// 수정하고자 하는 ID와 연락처 입력
						System.out.print("수정하고 싶은 회원ID >>> ");
						String stuId = scn.nextLine();
						System.out.print("수정할 연락처 >>> ");
						String stuPhone = scn.nextLine();

						// 관리자 또는 본인계정인지 확인 후 update실행
						String stuid = tdao.getStu(stuId).getStuId();
						if (stuid.equals(id) || tdao.magCheck(id, pw) == 1) {
							System.out.println("수정 가능");
							stu = new Student(stuId, null, null, stuPhone, null, 0, null);
							tdao.phoneUpdate(stu);
							System.out.println("연락처 변경 완료");
						} else {
							System.out.println("본인 또는 관리자만 수정가능합니다.");
						}
					}
				} else if (mainMenu == 3) {
					// 3. 조회 메뉴
					System.out.println("===조회메뉴===");
					System.out.println("1. 과목 전체 2. 회원 전체 3. 특정 과목 조회 4. 특정 회원 조회");
					int selMenu = Util.checkMenu("입력 >>> ");
					if (selMenu == 1) {
						// 3-1
						System.out.println("===과목 전체 조회===");
						List<Training> trains = tdao.traSearch();

						for (Training tr : trains) {
							System.out.println(tr.toString());
						}

					} else if (selMenu == 2) {
						// 3-2
						System.out.println("===회원 전체 조회===");

						// 관리자 확인
						check = tdao.magCheck(id, pw);
						if (check == 1) {
							List<Student> stus = tdao.stuSearch();

							for (Student st : stus) {
								System.out.println(st.toString());
							}
						} else {
							System.out.println("관리자 권한 페이지입니다.");
						}
					} else if (selMenu == 3) {
						// 3-3
						System.out.println("===특정 과목 조회===");
						System.out.print("조회하고 싶은 과목ID >>> ");
						int traId = Integer.parseInt(scn.nextLine());

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
						System.out.println("\n Q: 1. 후기작성 2. 종료");
						System.out.print(">>> ");
						int trr = Util.checkMenu("입력 >>> ");

						if (trr == 1) {
							// 관리자는 후기 작성X, 회원인지 확인
							check = tdao.stuCheck(id, pw);
							if (check == 1) {
								// 3-3-1
								System.out.print("후기 내용 >>> ");
								String reContent = scn.nextLine();

								String reWriter = id;
								traRe = new TraReply(traId, reContent, reWriter, null);

								tdao.reInsert(traRe);
								System.out.println("후기를 추가했습니다.");
							} else {
								System.out.println("회원만 후기 작성이 가능합니다.");
								continue;
							}
						} else if (trr == 2) {
							// 3-3-2
							System.out.println("메뉴로 돌아갑니다.");
							continue;
						} else {
							System.out.println("잘못된 번호입니다.");
							continue;
						}
					} else if (selMenu == 4) {
						// 3-4
						System.out.println("===특정 회원 조회===");
						System.out.print("조회하고 싶은 회원ID >>> ");
						String stuId = scn.nextLine();

						String stuid = tdao.getStu(stuId).getStuId();
						// 본인 또는 관리자인지 확인
						if (stuid.equals(id) || tdao.magCheck(id, pw) == 1) {
							System.out.println(tdao.getStu(stuid));
						} else {
							System.out.println("본인 또는 관리자만 수정가능합니다.");
						}
					}
				} else if (mainMenu == 4) {
					// 4. 삭제메뉴
					System.out.println("===삭제 메뉴===");

					// 관리자 확인.
					check = tdao.magCheck(id, pw);
					if (check == 1) {
						System.out.println("메뉴 : 1. 과목 삭제 2. 회원 수강과목 삭제");
						System.out.print("입력 >>> ");
						int deMenu = Util.checkMenu("입력 >>> ");

						if (deMenu == 1) {
							// 4-1
							System.out.println("===과목 삭제===");

							System.out.print("삭제하고 싶은 과목ID를 입력하세요. >>> ");
							int traId = Integer.parseInt(scn.nextLine());
							// 과목 삭제
							tdao.traDelete(traId);
							// 과목에 달린 후기 삭제
							tdao.trrDelete(traId);
							System.out.println("삭제가 완료되었습니다.");
						} else if (deMenu == 2) {
							// 4-2
							System.out.println("===회원 수강과목 삭제===");
							System.out.println("삭제할 회원ID 입력 >>> ");
							String stuId = scn.nextLine();
							int traId = tdao.getStu(stuId).getTraId();
							tdao.delCount(traId);
							// 수강ID와 수강이름만 삭제
							stu = new Student(stuId, null, null, null, null, 0, "");
							tdao.stuUpdate(stu);
						}
					} else {
						System.out.println("관리자 권한 페이지입니다.");
					}
				} else if (mainMenu == 9) {
					// 9. 종료
					System.out.println("종료");
					break;
				}
			}
		}
	}
}
