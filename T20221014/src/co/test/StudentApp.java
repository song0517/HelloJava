package co.test;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {

		StudentManage app = StudentManage.getInstance();
		Scanner scn = new Scanner(System.in);
		Student stu = null;

		app.readFromFile();

		while (true) {
			System.out.println("--------------------------------");
			System.out.println("1.등록 2.삭제 3.목록(총점) 4.순위 9.종료");
			System.out.println("--------------------------------");

			System.out.print("선택> ");
			int menu = scn.nextInt();
			scn.nextLine();

			if (menu == 1) { // 등록.
				System.out.println("--------------------------------");
				System.out.print("학생번호>> ");
				int studNo = scn.nextInt();
				scn.nextLine();
				System.out.print("학생이름>> ");
				String studName = scn.nextLine();
				System.out.print("학생나이>> ");
				int studAge = scn.nextInt();
				scn.nextLine();
				System.out.print("영어점수>> ");
				int engScore = scn.nextInt();
				scn.nextLine();
				System.out.print("수학점수>> ");
				int mathScore = scn.nextInt();
				scn.nextLine();

				stu = new Student(studNo, studName, studAge, engScore, mathScore);
				app.add(stu);
				System.out.println("<<입력되었습니다!>>");

			} else if (menu == 2) { // 삭제.
				System.out.print("삭제할 학생번호>> ");
				int studNo = scn.nextInt();
				app.del(studNo);

			} else if (menu == 3) { // 목록.
				app.list();
			} else if (menu == 4) { // 순위.
				app.ord();
			} else if (menu == 9) { // 종료.
				app.storeToFile();
				System.out.println("<<저장되었습니다!>>");
				break;
			}
		}
		scn.close();
		System.out.println("프로그램 종료.");
	}
}
