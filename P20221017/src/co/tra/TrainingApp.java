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
		String id = null;
		String pw = null;
		int check = 0;

		// 처음 화면
		while (!cklog) {
			System.out.println("메뉴 : 1. 회원가입 2. 로그인 3.종료");
			System.out.println("입력 >>> ");
			int logmenu = Integer.parseInt(scn.nextLine());
			// 1. 회원가입 과정
			if (logmenu == 1) {
				System.out.println("1. 관리자 계정 2. 회원 계정");
				System.out.println("입력 >>> ");
				int accmenu = Integer.parseInt(scn.nextLine());
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
				int accCkMenu = Integer.parseInt(scn.nextLine());
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
				} else if (logmenu == 3) {
					// 3. 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("잘못된 메뉴 번호입니다. 다시 입력해 주세요.");
					continue;
				}
				while (true) {
					System.out.println("메뉴: 1. 등록 2. 수정 3. 조회 4. 후기 작성 5. 삭제 9. 종료");
					System.out.print("입력 >>> ");
					int mainMenu = Integer.parseInt(scn.nextLine());

					// 1. 등록 메뉴
					if (mainMenu == 1) {
						System.out.println("===등록메뉴===");
						// 관리자 계정인지 확인
						check = tdao.magCheck(id, pw);
						if (check == 1) {
//							System.out.println("관리자계정 로그인 완료.");
							System.out.println("등록 메뉴 : 1. 과목 등록 2. 회원 수강과목 등록");
							int regMenu = Integer.parseInt(scn.nextLine());
							if (regMenu == 1) {
								// 1-1. 과목 등록 메뉴
								System.out.println("===과목 등록===");
								System.out.println("과목 ID 입력 >>> ");
								int traId = Integer.parseInt(scn.nextLine());
								System.out.println("과목 이름 입력 >>> ");
								String traName = scn.nextLine();
								System.out.println("강사 입력 >>> ");
								String tName = scn.nextLine();
								System.out.println("교육 시간 입력 >>> ");
								String traTime = scn.nextLine();
								System.out.println("교육 요일 입력 >>> ");
								String traDay = scn.nextLine();
								System.out.println("수강 가능 인원 입력 >>> ");
								int stCo = Integer.parseInt(scn.nextLine());

								tra = new Training(traId, traName, tName, traTime, traDay, stCo, 0);
								tdao.tarInsert(tra);
							} else if (regMenu == 2) {
								// 1-2. 회원 수강과목 등록
								System.out.println("===회원 수강과목 등록===");
								System.out.println("등록할 회원ID >>> ");
								String stuId = scn.nextLine();
								System.out.println("수강신청할 과목ID >>> ");
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
						int selMenu = Integer.parseInt(scn.nextLine());

						if (selMenu == 1) {
							// 2-1
							System.out.println("===과목 정보 변경===");
							check = tdao.magCheck(id, pw);
							if (check == 1) {
								System.out.println("변경할 강사 과목ID >>> ");
								int traId = Integer.parseInt(scn.nextLine());
								System.out.println("변경할 강사 이름 >>> ");
								String tName = scn.nextLine();

								tra = new Training(traId, null, tName, null, null, 0, 0);
								tdao.tNameUpdate(tra);

							} else {
								System.out.println("관리자 권한 페이지입니다.");
							}
						} else if (selMenu == 2) {
							// 2-2
							System.out.println("===회원 수강 과목 변경===");
							check = tdao.magCheck(id, pw);
							if (check == 1) {
								System.out.println("변경할 회원ID >>> ");
								String stuId = scn.nextLine();
								String name = tdao.getStu(stuId).getStuId();
								if (name.equals(stuId) && !name.equals(null)) {
									int traId1 = tdao.getStu(stuId).getTraId();
									System.out.println("변경할 수강ID >>> ");
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
						} else if (selMenu == 3) {
							// 2-3
							System.out.println("===회원정보 변경===");
							// 관리자 또는 본인계정인지 확인
							if(tdao.magCheck(id, pw) == 1 || tdao.stuCheck(id, pw) == 1) {
								
							}
						}
					}

					else if (mainMenu == 9) {
						System.out.println("종료");
						break;
					}
				}
			}
		}
	}
}
