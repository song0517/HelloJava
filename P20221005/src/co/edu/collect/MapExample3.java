package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample3 {
	public static void main(String[] args) {
		//스캐너 클래스를 이용
		//1. 저장 2. 조회 3. 종료 (이름, 점수)
		Map<String, Integer> students = new HashMap<>();
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 저장 2. 조회 3. 종료");
			System.out.println("선택 >>> ");
			
			int menu = scn.nextInt(); scn.nextLine();
			if(menu == 1) {
				System.out.println("학생 이름 >>> ");
				String name = scn.nextLine();
				System.out.println("학생 점수 >>> ");
				int score = scn.nextInt();
				
				students.put(name, score);
				 
			}else if(menu == 2) {
				System.out.println("조회할 이름 입력 >>> ");
				String searchName = scn.nextLine();
				
				//점수 출력
				System.out.println("점수: " + students.get(searchName));
				
			}else if(menu == 3) {
				System.out.println("프로그램 종료합니다.");
				break;
			}
		} // end of while
		System.out.println("프로그램 종료");
	}
}
