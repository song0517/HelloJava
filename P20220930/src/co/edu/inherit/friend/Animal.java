package co.edu.inherit.friend;

//20221004 추상클래스
public abstract class Animal {
	private String kind;
	
	public Animal() {};
	
	public Animal(String kind) {
		this.kind = kind;
	}
	
	public void move(String kind) {
		System.out.println(kind + "움직인다!");
	}
	
	//추상메소드 : 자식클래스에서 반드시 구현하도록 강제의무부여.
	public abstract void eat();
	public abstract void speak();
}
