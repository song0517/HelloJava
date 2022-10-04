package co.edu.inherit.friend;

public class FriendMain {
	public static void main(String[] args) {
		
		//final은 값을 변경하지 못하도록 설정하는 것, 고정된 값만 사용가능, 변수 또는 클래스 앞에 사용 가능
		final String constVar = "Hello";
		//constVar = "World"; //변수.(Const Variable)
		
		FriendExe app = new FriendExe();
		app.exe();
	}
}
