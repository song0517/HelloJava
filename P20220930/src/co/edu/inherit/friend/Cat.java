package co.edu.inherit.friend;

public class Cat extends Animal{

	//Animal클래스가 가지고 있는 추상메소드를 반드시 구현해주어야된다.
	@Override
	public void eat() {
		System.out.println("고양이가 먹이를 먹습니다.");
	}

	@Override
	public void speak() {
		System.out.println("야옹냐옹");
	}
	
}
