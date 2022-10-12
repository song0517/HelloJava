package co.edu.board;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import co.edu.jdbc.Employee;

//221012
public class BoardApp {
	public static void main(String[] args) {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		String format_time1 = format1.format (System.currentTimeMillis());
		
		BoardDAO dao = new BoardDAO();
		Board boa = null;
		int count = 0;
		
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("메뉴 : 1.글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 9.종료");
			System.out.print("입력>>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			if(menu == 1) {
				System.out.println("글 등록메뉴");
				System.out.print("글 번호 >>> ");
				int bNum = Integer.parseInt(scn.nextLine());
				System.out.print("글 제목>>> ");
				String bTitle = scn.nextLine();
				System.out.print("글 내용>>> ");
				String bContent = scn.nextLine();
				System.out.print("글 작성자>>> ");
				String bWriter = scn.nextLine();

				boa = new Board(bNum, bTitle, bContent, bWriter, format_time1 , count);
				dao.insert(boa);
				
			} else if(menu == 2) {
				System.out.println("글 수정메뉴");
				System.out.print("수정하고 싶은 글 번호>>> ");
				int bNum = Integer.parseInt(scn.nextLine());
				System.out.print("수정하고 싶은 내용>>> ");
				String bContent = scn.nextLine();
				
				boa = new Board(bNum, null, bContent, null, format_time1, 0);
				dao.update(boa);
				
			} else if(menu == 3) {
				System.out.println("글 삭제메뉴");
				System.out.print("삭제하고 싶은 글 번호>>> ");
				int bNum = Integer.parseInt(scn.nextLine());
				
				dao.delete(bNum);
				
			} else if(menu == 4) {
				System.out.println("글 목록");
				List<Board> boards = dao.search();

				for (Board bo : boards) {
					System.out.println("글 번호: " + bo.getbNum() + "글 제목: " + bo.getbTitle() + ", 글 작성자: " + bo.getbWriter() + ", 작성일시: " + bo.getbDate());
				}
				
			} else if(menu == 5) {
				System.out.println("상세조회");
				System.out.print("내용을 보고 싶은 글 번호>>> ");
				int bNum = Integer.parseInt(scn.nextLine());
				
				System.out.println(dao.getBoard(bNum));
				
			} else if(menu == 9) {
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴 번호입니다.");
			}
		}
	}
}
