package co.edu.nested;

//20221014

class People {
	int height;
	int weight;

	void showInfo() {
		System.out.println("showInfo");
	}
}

class Student extends People {
	int studNo;
}

public class AnonymousExample {
	public static void main(String[] args) {
		// 익명 상속 클래스, people클래스를 통해 필요할 때 생성하겠다아..
		People people = new People() {
			String color;

			// 부모가 가지고 있는 메소드 수정 시 오버라이딩
			@Override
			void showInfo() {
				System.out.println("익명 showInfo");
				//클래스 안에서만 메소드 사용가능
				showColor();
			}
			
			void showColor() {
				System.out.println(this.color);
			}
		};
		
		people.showInfo();
		
	}
}
