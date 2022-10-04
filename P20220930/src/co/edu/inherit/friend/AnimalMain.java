package co.edu.inherit.friend;

public class AnimalMain {
	public static void main(String[] args) {
		//추상클래스는 new를 사용하여 인스턴스 생성이 불가하다.
		//Animal animal = new Animal();
		
		Animal cat = new Cat();
		Animal dog = new Dog();
		
		//똑같은 speak메소드이지만 인스턴스에따라 결과값은 다르게 나타난다.
		cat.speak();
		dog.speak();
	}
}
