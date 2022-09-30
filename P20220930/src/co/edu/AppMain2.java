package co.edu;

public class AppMain2 {
	public static void main(String[] args) {
		
		//static : 인스턴스가 하나 안만들어져도 메모리상에서 사용가능, 클래스이름.메소드이름
		Student.staticMethod();
		
		Math.random();
		Math.round(.5);
		
		//학생1
		Student s1 = new Student();
//		프로그램에러는 아닌데 warning 부자연스럽다는 뜻
//		s1.staticMethod();
		
		s1.setStdNo("111-111");
		s1.setStdName("홍길동");
		s1.setStdMajor("컴퓨터공학");
		s1.setAge(20);
		
		System.out.println(s1.getStdNo()); //초기값 null
		System.out.println(s1.getAge()); //초기값 0;
		System.out.println(s1.showInfo());
		
		System.out.println("여기는 >>>" + s1);
		
		//학생2
		Student s2 = new Student();
		s2.setStdName("김민숙");
		s2.setStdNo("111-222");
		s2.setStdMajor("경영학과");
		System.out.println(s2.showInfo());
		
		//취미부분
		String[] hob = {"독서", "자전거"};
		s1.setHobbies(hob);
		s1.addHobby("노래");
		System.out.println(s1.getStdName() +"의 " + s1.getHobb());
		
		String[] hob2 = {"게임"};
		s2.setHobbies(hob2);
		s2.addHobby("걷기");
		System.out.println(s2.getStdName() +"의 " + s2.getHobb());
		
		// 생성자 부분, new : 생성자를 호출하겠습니다아.
		Student s3 = new Student();
		System.out.println(s3.getStdName());
		System.out.println(s3.getStdNo());
		System.out.println(s3.showInfo());
		
		Student s4 = new Student("111-234", "주소영");
		System.out.println(s4.showInfo());
		
		Student s5 = new Student("222-222", "송지은", "역사학과");
		System.out.println(s5.showInfo());
		
	}
}
