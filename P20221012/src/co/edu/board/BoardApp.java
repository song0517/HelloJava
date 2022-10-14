package co.edu.board;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import co.edu.jdbc.Employee;

//221012
public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Board boa = null;
		Reply rep = null;

		Scanner scn = new Scanner(System.in);

		boolean chk = false;
		int count = 0;

		while (!chk) {
			System.out.println("===로그인===");
			System.out.print("아이디>>> ");
			String id = scn.nextLine();
			System.out.println("비밀번호>>> ");
			String pw = scn.nextLine();

			int a = dao.check(id, pw);
			if (a == 1) {
				chk = true;
				System.out.println("로그인 완료");
			} else {
				System.out.println("다시 로그인하세요.");
				continue;
			}

			while (true) {
				System.out.println("메뉴 : 1.글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 9.종료");
				System.out.print("입력>>> ");
				int menu = Integer.parseInt(scn.nextLine());

				if (menu == 1) {
					System.out.println("===글 등록메뉴===");
					System.out.print("글 번호 >>> ");
					int bNum = Integer.parseInt(scn.nextLine());
					System.out.print("글 제목>>> ");
					String bTitle = scn.nextLine();
					System.out.print("글 내용>>> ");
					String bContent = scn.nextLine();
//					System.out.print("글 작성자>>> ");
//					String bWriter = scn.nextLine();
					String bWriter = id;

					boa = new Board(bNum, bTitle, bContent, bWriter, null, count);
					dao.insert(boa);
					System.out.println("글 등록이 완료되었습니다.");

				} else if (menu == 2) {
					System.out.println("===글 수정메뉴===");

					System.out.print("수정하고 싶은 글 번호>>> ");
					int bNum = Integer.parseInt(scn.nextLine());
					System.out.print("수정하고 싶은 내용>>> ");
					String bContent = scn.nextLine();

					String name = dao.getBoard(bNum).getbWriter();
					if (name.equals(id)) {
						boa = new Board(bNum, null, bContent, null, null, count);
						dao.update(boa);
						System.out.println("수정이 완료되었습니다.");
					} else {
						System.out.println("작성자가 달라 수정할 수 없습니다.");
					}
				} else if (menu == 3) {
					System.out.println("===글 삭제메뉴===");

					System.out.print("삭제하고 싶은 글 번호>>> ");
					int bNum = Integer.parseInt(scn.nextLine());

					String name = dao.getBoard(bNum).getbWriter();
					if (name.equals(id)) {
						dao.delete(bNum);
						System.out.println("삭제가 완료되었습니다.");
					} else {
						System.out.println("작성자가 달라 삭제할 수 없습니다.");
					}
					
					
				} else if (menu == 4) {
					System.out.println("===글 목록===");
					List<Board> boards = dao.search();
					
//					int page = 1;
					
//					final int rowsParpage = 3;
//					int boarCount = dao.bCount();
					
//					int totalPage = (int) Math.ceil(boarCount/ (double) rowsParpage);
//					
//					int pageCount = 1;
//					int startPage = ((page - 1) / pageCount) * pageCount + 1;
//					int endPage = startPage + pageCount - 1;
					
					for (Board bo : boards) {
						System.out.println("글 번호: " + bo.getbNum() + ", 글 제목: " + bo.getbTitle() + ", 글 작성자: "
								+ bo.getbWriter() + ", 작성일시: " + bo.getbDate());
					}

				} else if (menu == 5) {
					System.out.println("===상세조회===");
					System.out.print("내용을 보고 싶은 글 번호>>> ");
					int bNum = Integer.parseInt(scn.nextLine());
//					int boNum = dao.getBoard(bNum).getbNum();

					dao.count(bNum);
					System.out.println(dao.getBoard(bNum));

					System.out.println();
					System.out.println("===댓글===");

					// 댓글보여주기
					List<Reply> reply = dao.search2(bNum);
					if (reply.size() == 0) {
						System.out.println("댓글 없음");
					}

					for (Reply res : reply) {
						System.out.println("● " + res);
					}

					// 댓글달기
					System.out.println();
					System.out.println("Q : 1.댓글달기 2.종료");
					System.out.println("입력>>> ");
					int re = Integer.parseInt(scn.nextLine());

					if (re == 1) {
						System.out.print("댓글 내용>>> ");
						String reContent = scn.nextLine();

						String reWriter = id;
						rep = new Reply(0, bNum, reContent, reWriter, null);

						dao.reply(rep);
						System.out.println("댓글을 추가했습니다.");
					} else if (re == 2) {
						System.out.println("종료");
						continue;
					}

				} else if (menu == 9) {
					System.out.println("종료합니다.");
					break;
				} else {
					System.out.println("잘못된 메뉴 번호입니다.");
				}
			}
		}
	}
}
