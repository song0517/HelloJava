package co.edu;

//하나의 실행클래스와 하나 이상의 라이브러리클래스가 필요.
public class AppMain {
	public static void main(String[] args) {
		// Object가 -> class가되고 이 클래스를 기반으로 -> 속성과기능을 담고 있는 실체인 인스턴스(Instance)를 만들어야된다.
		/*
		 * Person class 관련 Person kim = new Person(); //인스턴스생성 kim.name = "김민기"; kim.age
		 * = 20; kim.sleep(); kim.eat("사과");
		 * 
		 * Person lee = new Person(); lee.name = "이순신"; lee.age = 25; lee.sleep();
		 * lee.eat("피자"); //System.out.println(kim);
		 */

		Student stud1 = new Student();
		/*stud1.stdNo = "2428-259";
		stud1.stdName = "송지은";
		stud1.stdMajor = "IT";
		*/
		
		//메소드이름을 이용해서 추가.
		stud1.setStdNo("2428-259");
		stud1.setStdName("송지은");
		stud1.setStdMajor("IT");
		stud1.study();
		stud1.game("로스트");
		stud1.sleep();

		System.out.println();

		Student stud2 = new Student();
		/*stud2.stdNo = "2468-500";
		stud2.stdName = "홍길동";
		stud2.stdMajor = "경영학과";*/
		stud2.setStdNo("2468-500");
		stud2.setStdName("홍길동");
		stud2.setStdMajor("경영학과");
		stud2.study();
		stud2.game("메이플");
		stud2.sleep();

		Student stud3 = new Student();
		System.out.println();

		// 배열을 사용해서 한공간에 저장
		Student[] students;
		students = new Student[] { stud1, stud2, stud3 };
		//배열에 있는 요소들 만큼 반복하겠다. stud에 요소들을 불러들어서 반복한다.
		/*
		for (Student stud : students) {
			System.out.println("학번 : " + stud.get + ",학생 이름: " + stud.stdName);
		}
		*/
		//private를 이용했을 경우 메소드이름을 통해 출력
		for (Student stud : students) {
			System.out.println("학번 : " + stud.getStdNo() + ",학생 이름: " + stud.getStdName());
		}
		
		//상속 : 부모클래스에 있는 속성과 메소드도 함께 사용가능하다.
		WorkMan wman = new WorkMan();
		wman.name = "직장인";
		wman.age = 30;
		
		StudMan sman = new StudMan();
		sman.school = "고등학교";
		sman.height = 164.3;
	}
}
