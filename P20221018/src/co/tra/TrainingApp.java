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

		String id = null;
		String pw = null;
		boolean cklog = false;

		int check = 0;

		// 처음 화면
		while (!cklog) {
			// 회원가입 & 로그인 메뉴
			System.out.println("▶▶▶▶▶▶▶▶▶▶ 1.회원가입 2.로그인 3. 비밀번호 찾기 4.종료 ◀◀◀◀◀◀◀◀◀◀");
			int logmenu = Util.checkMenu("입력 >>> ");

			// 1. 회원가입 과정
			if (logmenu == 1) {
				System.out.println("▶▶▶▶▶▶▶▶▶▶ 1.관리자 계정 2.회원 계정 ◀◀◀◀◀◀◀◀◀◀");

				int accmenu = Util.checkMenu("입력 >>> ");
				if (accmenu == 1) {
					// 1-1. 관리자 계정
					System.out.println("===관리자 계정 회원가입===");
					System.out.print("관리자 ID 입력 >>> ");
					String magId = scn.nextLine();
					if (tdao.getMag(magId).getMagId().equals(magId)) {
						System.out.println("동일한 관리자ID가 있습니다.");
						continue;
					} else {
						System.out.print("관리자 PW 입력 >>> ");
						String magPw = scn.nextLine();
						System.out.print("관리자 이름 입력 >>> ");
						String magName = scn.nextLine();

						mag = new Manager(magId, magPw, magName);
						tdao.magInsert(mag);
						continue;
					}
				} else if (accmenu == 2) {
					// 1-2. 회원 계정
					System.out.println("===회원 계정 회원가입===");
					System.out.print("회원 ID 입력 >>> ");
					String stuId = scn.nextLine();
					if (tdao.getStu(stuId).getStuId().equals(stuId)) {
						System.out.println("동일한 학생ID가 있습니다.");
						continue;
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
						continue;
					}
				} else {
					// 번호 잘못 눌렀을 경우
					System.out.println("잘못된 메뉴 번호입니다. 다시 입력해 주세요.");
					continue;
				}
			} else if (logmenu == 2) {
				// 1-2. 로그인 과정
				System.out.println("▶▶▶▶▶▶▶▶▶▶ 로그인 계정을 선택해 주세요 : 1. 관리자 2. 회원 ◀◀◀◀◀◀◀◀◀◀");
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
						continue;
					}
				} else {
					System.out.println("잘못된 메뉴 번호입니다. 다시 입력해 주세요.");
					continue;
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
					continue;

				} else {
					System.out.println("해당 ID가 없습니다.");
					continue;
				}
			} else if (logmenu == 4) {
				// 3. 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴 번호입니다. 다시 입력해주세요.");
				continue;
			}

			// 메인 메뉴
			while (true) {
				System.out.println("▶▶▶▶▶▶▶▶▶▶ 1. 등록 2. 수정 3. 조회 4. 삭제 9. 종료 ◀◀◀◀◀◀◀◀◀◀");
				int mainMenu = Util.checkMenu("입력 >>> ");

				// 1. 등록 메뉴
				if (mainMenu == 1) {
					System.out.println("===등록메뉴===");
					// 관리자 계정인지 확인
					mag = new Manager(id, pw, null);
					List<Manager> mags = tdao.magList(mag);

					if (mags.size() == 1) {
						System.out.println("▶▶▶▶▶▶▶▶▶▶ 1. 과목 등록 2. 회원 수강과목 등록 ◀◀◀◀◀◀◀◀◀◀");
						int regMenu = Util.checkMenu("입력 >>> ");
						if (regMenu == 1) {
							// 1-1. 과목 등록 메뉴
							System.out.println("===과목 등록===");
							int traId = Util.checkMenu("과목 ID 입력 >>> ");
							if (tdao.traNameSearch(traId).getTraId() == traId) {
								System.out.println("동일한 과목ID가 있습니다.");
								continue;
							}
							System.out.print("과목 이름 입력 >>> ");
							String traName = scn.nextLine();
							System.out.print("강사 ID 입력 >>> ");
							String magId = scn.nextLine();

							if (tdao.getMag(magId).getMagId().equals(magId)) {
								String tName = tdao.getMag(magId).getMagName();
								System.out.print("교육 시간 입력 >>> ");
								String traTime = scn.nextLine();
								System.out.print("교육 요일 입력 >>> ");
								String traDay = scn.nextLine();
								int stCo = Util.checkMenu("수강 가능 인원 입력 >>> ");

								tra = new Training(traId, traName, tName, traTime, traDay, stCo, 0);
								tdao.tarInsert(tra);
							} else {
								System.out.println("해당 ID 강사가 없습니다. 확인해 주세요.");
							}
						} else if (regMenu == 2) {
							// 1-2. 회원 수강과목 등록
							System.out.println("===회원 수강과목 등록===");
							System.out.print("등록할 회원ID >>> ");
							String stuId = scn.nextLine();

							if (tdao.getStu(stuId).getStuId().equals(stuId)) {
								int traId = Util.checkMenu("수강신청할 과목ID >>> ");

								// ID에 맞는 수강과목 찾기
								String traName = tdao.traNameCheck(traId);

								// 수강 인원 추가, 수강생 초과일 경우 등록하지 못함.
								if (tdao.pluCount(traId) == 1) {
									stu = new Student(stuId, null, null, null, null, traId, traName);
									tdao.stuUpdate(stu);
									System.out.print("수강 등록 완료!");
								} else {
									System.out.println("수강 인원이 초과하여 등록할 수 없습니다.");
									continue;
								}
							} else {
								System.out.println("해당 회원ID 정보가 없습니다.");
							}
						} else {
							System.out.println("올바른 메뉴 번호가 아닙니다.");
						}
					} else {
						System.out.println("관리자 권한 페이지입니다.");
						continue;
					}

				} else if (mainMenu == 2) {
					// 2. 수정메뉴
					System.out.println("===수정메뉴===");
					System.out.println("▶▶▶▶▶▶▶▶▶▶ 1. 과목 정보 변경 2. 회원 수강 과목 변경 3. 회원정보 변경 ◀◀◀◀◀◀◀◀◀◀");
					int updMenu = Util.checkMenu("입력 >>> ");

					if (updMenu == 1) {
						// 2-1
						System.out.println("===과목 정보 변경===");

						// 관리자가 맞는지 확인 후 실행
						mag = new Manager(id, pw, null);
						List<Manager> mags = tdao.magList(mag);

						if (mags.size() == 1) {
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
						mag = new Manager(id, pw, null);
						List<Manager> mags = tdao.magList(mag);

						if (mags.size() == 1) {
							System.out.print("변경할 회원ID >>> ");
							String stuId = scn.nextLine();
							String name = tdao.getStu(stuId).getStuId();
							if (name.equals(stuId) && !name.equals(null)) {
								int traId1 = tdao.getStu(stuId).getTraId();
								System.out.print("변경할 과목ID >>> ");
								int traId2 = Integer.parseInt(scn.nextLine());

								if (tdao.traNameSearch(traId2).getTraId() == traId2) {
									if (traId1 != traId2) {
										if (tdao.pluCount(traId2) == 1) {
											tdao.delCount(traId1);
											String traName = tdao.traNameCheck(traId2);
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

						mag = new Manager(id, pw, null);
						List<Manager> mags = tdao.magList(mag);

						if (tdao.stuCheck(id, pw) == 1) {
							System.out.print("수정할 연락처 >>> ");
							String stuPhone = scn.nextLine();
							stu = new Student(id, null, null, stuPhone, null, 0, null);
							tdao.phoneUpdate(stu);
							System.out.println("연락처 변경 완료");

						} else if (mags.size() == 1) {
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
					}
				} else if (mainMenu == 3) {
					// 3. 조회 메뉴
					System.out.println("===조회메뉴===");
					System.out.println(
							"▶▶▶▶▶▶▶▶▶▶ 1. 과목 전체 2. 회원 전체 3. 강사 전체 4. 특정 과목 조회 5. 과목별 수강 회원 조회 6. 특정 회원 조회 7. 작성한 댓글 확인 ◀◀◀◀◀◀◀◀◀◀");
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
						mag = new Manager(id, pw, null);
						List<Manager> mags = tdao.magList(mag);

						if (mags.size() == 1) {
							List<Student> stus = tdao.stuSearch();

							for (Student st : stus) {
								System.out.println(st.toString());
							}
						} else {
							System.out.println("관리자 권한 페이지입니다.");
						}

					} else if (selMenu == 3) {
						System.out.println("===강사 전체 조회===");
						mag = new Manager(null, null, null);
						List<Manager> mags = tdao.magList(mag);

						for (Manager mg : mags) {
							System.out.println("선생님ID : " + mg.getMagId() + ", 선생님 이름: " + mg.getMagName());
						}

					} else if (selMenu == 4) {
						// 3-3
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
							System.out.println("\n ▶▶▶▶▶▶▶▶▶▶ Q: 1. 후기작성 2. 종료 ◀◀◀◀◀◀◀◀◀◀");
							int trr = Util.checkMenu(">>> ");

							if (trr == 1) {
								// 관리자는 후기 작성X, 회원인지 확인
								check = tdao.stuCheck(id, pw);
								if (check == 1) {
									// 3-3-1
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
								// 3-3-2
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
						System.out.println("===과목별 수강 회원 조회===");

						mag = new Manager(id, pw, null);
						List<Manager> mags = tdao.magList(mag);

						if (mags.size() == 1) {
							int traId = Util.checkMenu("조회하고 싶은 과목ID 입력>>> ");
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
						// 3-6
						System.out.println("===특정 회원 조회===");

						mag = new Manager(id, pw, null);
						List<Manager> mags = tdao.magList(mag);

						if (tdao.stuCheck(id, pw) == 1) {
							System.out.println(tdao.getStu(id));
						} else if (mags.size() == 1) {
							System.out.print("조회하고 싶은 회원ID >>> ");
							String stuId = scn.nextLine();

							if (tdao.getStu(stuId).getStuId().equals(stuId)) {
								System.out.println(tdao.getStu(stuId));
							} else {
								System.out.println("해당 회원ID 정보가 없습니다.");
							}
						}

					} else if (selMenu == 7) {
						// 3-7
						System.out.println("===자신이 작성한 후기 조회===");

						mag = new Manager(id, pw, null);
						List<Manager> mags = tdao.magList(mag);

						if (mags.size() == 1) {
							System.out.println("관계자는 후기가 없습니다.");
						} else {
							List<TraReply> trReply = tdao.reWrSearch(id);
							if (trReply.size() == 0) {
								System.out.println("● 후기가 없습니다.");
							}
							for (TraReply res : trReply) {
								System.out.println("● " + res);
							}

							System.out.println("\n ▶▶▶▶▶▶▶▶▶▶ Q: 1. 후기 수정 2. 후기 삭제 3. 종료 ◀◀◀◀◀◀◀◀◀◀");
							int reUp = Util.checkMenu(">>> ");
							int count = 0;

							if (reUp == 1) {
								int reNum = Util.checkMenu("수정하고 싶은 후기 번호 입력 >>> ");

								// 본인인지 확인확인
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

								// 본인인지 확인확인
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
					}
				} else if (mainMenu == 4) {
					// 4. 삭제메뉴
					System.out.println("===삭제 메뉴===");

					// 관리자 확인.
					mag = new Manager(id, pw, null);
					List<Manager> mags = tdao.magList(mag);

					if (mags.size() == 1) {
						System.out.println("▶▶▶▶▶▶▶▶▶▶ 1. 과목 삭제 2. 회원 수강과목 삭제 3. 강사 삭제 ◀◀◀◀◀◀◀◀◀◀");
						int deMenu = Util.checkMenu("입력 >>> ");

						if (deMenu == 1) {
							// 4-1
							System.out.println("===과목 삭제===");
							int traId = Util.checkMenu("삭제하고 싶은 과목ID를 입력하세요. >>> ");

							System.out.println("'" + traId + "번' 과목을 삭제하시겠습니까?");
							int magCheck = Util.checkMenu("▶▶▶▶▶▶▶▶▶▶ 1. 예 2.아니요 >>> ");

							if (magCheck == 1) {
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
							// 4-2
							System.out.println("===회원 수강과목 삭제===");
							System.out.print("삭제할 회원ID 입력 >>> ");
							String stuId = scn.nextLine();

							System.out.println("'" + stuId + "' 계정의 수강항목을 삭제하시겠습니까?");
							int stuCheck = Util.checkMenu("▶▶▶▶▶▶▶▶▶▶ 1. 예 2.아니요 >>> ");

							if (stuCheck == 1) {
								stu = new Student(stuId, null, null, null, null, 0, "");
								int traId = tdao.getStu(stuId).getTraId();
								tdao.delCount(traId);
								if (tdao.stuUpdate(stu) == 1) {
									System.out.println("삭제가 완료되었습니다.");
								} else {
									System.out.println("회원 계정이 없습니다.");
								}
							} else if (stuCheck == 2) {
								System.out.println("처음화면으로 돌아갑니다.");
							}
						} else if (deMenu == 3) {
							System.out.println("===강사 계정 삭제===");
							System.out.print("삭제할 강사ID 입력 >>> ");
							String magId = scn.nextLine();

							System.out.println("'" + magId + "' 계정을 삭제하시겠습니까?");
							int magCheck = Util.checkMenu("▶▶▶▶▶▶▶▶▶▶ 1. 예 2.아니요 >>> ");
							int count = 0;

							if (magCheck == 1) {
								List<Training> trains = tdao.traSearch();

								for (Training tr : trains) {
									if (tr.gettName().equals(tdao.getMag(magId).getMagName())) {
										count = 1;
									}
								}

								if (count == 1) {
									System.out.println("수업 중인 과목이 있어 삭제할 수 없습니다.");
								}

								if (count == 0) {
									if (tdao.magDelete(magId) == 1) {
										System.out.println("삭제가 완료되었습니다.");
									} else {
										System.out.println("관리자 계정이 없습니다.");
									}
								}
							} else if (magCheck == 2) {
								System.out.println("처음화면으로 돌아갑니다.");
							}
						}
					} else {
						System.out.println("관리자 권한 페이지입니다.");
					}

				} else if (mainMenu == 9) {
					// 9. 종료
					System.out.println("종료");
					break;
				} else {
					System.out.println("올바른 메뉴 번호가 아닙니다.");
				}
			} // end of while (true) 메인 메뉴 부분
		} // end of while (!cklog) 로그인 부분
	}
}
