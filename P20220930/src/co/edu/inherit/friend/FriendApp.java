package co.edu.inherit.friend;

public class FriendApp {
	public static void main(String[] args) {
		// 일반 친구 정보.
		Friend frnd = new Friend("홍길동", "010-1111-2222");
//		frnd.setName("홍길동");
//		frnd.setPhone("010-1111-2222");

		//대학친구정보
		UnivFriend univFrnd = new UnivFriend("김민규", "010-2222-3333", "대구대", "역사학과");
		//회사친구정보
		ComFriend comFrnd = new ComFriend("유재석", "010-4545-4545", "MBC", "미디어부서");

		// 부모타입으로 배열 생성
		// 상속의 관계일경우 배열을 통해 저장하기 쉽다.
		// 부모클래스의 참조값을 담도록 배열 생성 -> 자식클래스 인스턴스 모두 담을 수 있다.
		Friend[] friends = new Friend[5];
		friends[0] = frnd;
		friends[1] = univFrnd;
		friends[2] = comFrnd;

		for (Friend friend : friends) {
			if (friend != null) {
				System.out.println(friend.showInfo());
			}
		}
	}
}
