package co.edu.inherit.friend;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendExe {
	// 친구 등록 - 학교친구 / 회사친구 / 기본정보
	Scanner scn = new Scanner(System.in);
//	Friend[] friends = new Friend[10];
	ArrayList friends = new ArrayList();

	public void exe() {
		while (true) {
			System.out.println("1.친구등록 2.친구조회 3.종료");
			System.out.print("선택 >>> ");

			int menu = scn.nextInt();
			if (menu == 1) {
				System.out.println("1.회사친구 2.학교친구 3.친구");
				System.out.print("선택 >>> ");
				int subMenu = scn.nextInt();
				if (subMenu == 1) {
					addComFriend();
				} else if (subMenu == 2) {
					addUnivFriend();
				} else if (subMenu == 3) {
					addFriend();
				} else {
					System.out.println("잘못된 선택입니다.");
				}
			} else if (menu == 2) {
				System.out.println("1.전체목록 2.친구조회");
				System.out.print("선택 >>> ");
				int scMenu = scn.nextInt();
				if(scMenu == 1) {
					searchFriend();
				}else if(scMenu == 2){
					searchFriends();
				}
			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		} // end of while
		System.out.println("프로그램 종료");
	}// end of exe

	// 추가메소드 정의
	public void addComFriend() {
		// 이름, 연락처, 회사명, 부서명
		scn.nextLine();
		System.out.print("이름을 입력하세요. >>> ");
		String name = scn.nextLine();
		System.out.print("연락처를 입력하세요. >>> ");
		String phone = scn.nextLine();
		System.out.print("회사명을 입력하세요. >>> ");
		String company = scn.nextLine();
		System.out.print("부서명을 입력하세요. >>> ");
		String dept = scn.nextLine();
		

		ComFriend comFr = new ComFriend(name, phone, company, dept);

//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] == null) {
//				friends[i] = comFr;
//				System.out.println("회사 친구 등록이 완료되었습니다.");
//				break;
//			}
//		}
		friends.add(comFr);
		
//		for(int i=0; i<friends.size(); i++) {
//			String fr = (String) friends.get(i);
//			System.out.println(fr);
//		}
	}

	public void addUnivFriend() {
		// 이름, 연락처, 학교명, 전공
		scn.nextLine();
		System.out.print("이름을 입력하세요. >>> ");
		String name =scn.nextLine();;
		System.out.print("연락처를 입력하세요. >>> ");
		String phone = scn.nextLine();
		System.out.print("학교명을 입력하세요. >>> ");
		String univ = scn.nextLine();
		System.out.print("전공을 입력하세요. >>> ");
		String major = scn.nextLine();

		UnivFriend univFr = new UnivFriend(name, phone, univ, major);

		friends.add(univFr);
//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] == null) {
//				friends[i] = univFr;
//				System.out.println("학교 친구 등록이 완료되었습니다.");
//				break;
//			}
//		}
	}

	public void addFriend() {
		// 이름, 연락처
		scn.nextLine();
		System.out.print("이름을 입력하세요. >>> ");
		String name = scn.nextLine();
		
		System.out.print("연락처를 입력하세요. >>> ");
		String phone = scn.nextLine();

		Friend Fr = new Friend(name, phone);
		
		//비워져 있는 위치에 알아서 한건 등록
		friends.add(Fr);
		
//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] == null) {
//				friends[i] = Fr;
//				System.out.println("친구 등록이 완료되었습니다.");
//				break;
//			}
//		}
	}

	public void searchFriend() {
		System.out.println("전체 친구목록입니다.");
//		for (Friend firend : friends) {
//			if (firend != null) {
//				System.out.println(firend.showInfo());
//			}
//		}

	}
	
	public void searchFriends() {
//		System.out.println("보고싶은 친구 이름을 입력하세요. >>>");
//		String name = scn.next();
//		scn.nextLine();
//		for(int i=0; i<friends.length; i++) {
//			if(friends[i] != null && friends[i].getName().equals(name)) {
//				System.out.println(friends[i].showInfo());
//			}
//		}
		
		//문자하나로 친구 찾기 -> contains
//		scn.nextLine();
//		System.out.println("찾고싶은 친구 이름을 입력하세요. >>>");
//		String searchKey = scn.nextLine();
//		for(int i=0; i<friends.length; i++) {
//			if(friends[i] != null && friends[i].getName().contains(searchKey)) {
//				System.out.println(friends[i].showInfo());
//			}
//		}
		
		scn.nextLine();
		System.out.println("찾고싶은 친구 이름을 입력하세요. >>>");
		String searchKey = scn.nextLine();
		for(int i=0; i<friends.size(); i++) {
			// Friend클래스의 상속. 각각의 클래스의 인스턴스
			// 인스턴스 타입에 맞게 클래스 타입으로 변환시켜주기. 
			// 각 클래스의 타입에 맞게 설정해주기.
			Object frnd = friends.get(i);
			if(frnd instanceof Friend) {  //frnd의 타입(유형)이 무엇인지 물어보는 것.
				Friend friend = (Friend) frnd;
				System.out.println(friend.showInfo());
				
			} else if(frnd instanceof ComFriend) {
				ComFriend friend = (ComFriend) frnd;
				System.out.println(friend.showInfo());
				
			} else if(frnd instanceof UnivFriend) {
				UnivFriend friend = (UnivFriend) frnd;
				System.out.println(friend.showInfo());
			}
			
		}
		
	}
}
