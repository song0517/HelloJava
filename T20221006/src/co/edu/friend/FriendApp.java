package co.edu.friend;

import java.util.Scanner;

public class FriendApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		FriendService service = FriendListImpl.getInstance(); // FriendListImpl 인스턴스 생성.

		while (true) {
			System.out.println("1.추가 2.리스트 3.수정 4.삭제 9.종료");
			System.out.print("선택>> ");

			int menu = -1;
			
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch(NumberFormatException e){
				System.out.println("숫자를 입력하세요.");
			}
			
			if (menu == 1) { //
//				Friend friend = new Friend();
				Friend friend = null;
				
				System.out.println("1.학교친구 2.회사친구 3.친구");
				System.out.print("선택>> ");
				int subMenu = scn.nextInt(); scn.nextLine();
				
				//공통적인 부분은 밖에 따로 설정해도 된다.
				System.out.println("이름 입력 >>> ");
				String name = scn.nextLine();
				System.out.println("연락처 입력 >>> ");
				String phoneNumber = scn.nextLine();
				
				if (subMenu == 1) {
					// 학교친구정보등록
//					System.out.println("이름 입력 >>> ");
//					String name = scn.nextLine();
//					System.out.println("연락처 입력 >>> ");
//					String phoneNumber = scn.nextLine();
					System.out.println("학교 입력 >>> ");
					String college = scn.nextLine();
					System.out.println("전공 입력 >>> ");
					String major = scn.nextLine();
					
					//부모클래스라서 값을 집어넣을 수 있다. -> 인스턴스만 변경하면 된다.
					friend = new UniFriend(name, phoneNumber, college, major);

				} else if (subMenu == 2) {
					// 회사친구등록
//					System.out.println("이름 입력 >>> ");
//					String name = scn.nextLine();
//					System.out.println("연락처 입력 >>> ");
//					String phoneNumber = scn.nextLine();
					System.out.println("회사명 입력 >>> ");
					String company = scn.nextLine();
					System.out.println("부서명 입력 >>> ");
					String department = scn.nextLine();
					
					friend = new CoFriend(name, phoneNumber, company, department);
					
				} else if(subMenu == 3){
					// 친구정보등록
//					System.out.println("이름 입력 >>> ");
//					String name = scn.nextLine();
//					System.out.println("연락처 입력 >>> ");
//					String phoneNumber = scn.nextLine();
					
					friend = new Friend(name, phoneNumber);

				}
				
				service.addFriend(friend);
				
			
			} else if (menu == 2) {
				Friend[] list = service.friendList();
				// 친구의 정보를 출력하는데 getInfo()를 사용해서 출력. for사용.
				for(int i =0; i < list.length; i++) {
					if(list[i] != null) {
						System.out.println(list[i].getInfo());
					}
				}
				

			} else if (menu == 3) {
				System.out.println("변경할 친구이름입력>> ");
				String name = scn.nextLine();
				System.out.println("변경할 연락처 입력>> ");
				String number = scn.nextLine();

				service.modFriend(name, number);

			} else if (menu == 4) {
				System.out.println("삭제할 친구의 연락처를 입력>> ");
				String phoneNo = scn.nextLine();

				service.delFriend(phoneNo); // phoneNo를 매개값으로 사용하도록 관련된 인터페이스와 클래스를 수정.

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("잘못된 메뉴입니다.");
			}
		}
		System.out.println("프로그램 종료.");
		scn.close();
	}
	
}
