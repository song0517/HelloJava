package co.edu.complex;

import java.util.Scanner;

public class ObjectExe {
	public static void main(String[] args) {
		String s1 = "홍길동";
		int i1 = 20;
		double d1 = 162.3;

		// 인스턴스 생성, 생성자 함수, 비어있는 공간을 먼저 생성한 후 -> class이름 변수이름 = new class이름();
		// new가 Person의 실체를 만들고 주소값을 p1에 담기.
		Person p1 = new Person();
		p1.name = "김민기";
		p1.age = 22;
		p1.height = 172.3;
		System.out.println(p1);

		Person p2 = new Person();
		p2.name = "김경미";
		p2.age = 23;
		p2.height = 163.2;

		Person p3 = new Person();
		p3.name = "주소영";
		p3.age = 22;
		p3.height = 172.3;
		System.out.println(p3);

		System.out.println("이름: " + p1.name);
		System.out.println("나이: " + p1.age);
		System.out.println("키: " + p1.height);

		// 배열에 담고 원하는 값 출력하기.
		Person[] persons = { p1, p2, p3 };
		System.out.println(persons[1].name);
		System.out.println(persons[1].age);
		System.out.println(persons[1].height);

		// 데이터값 바꾸는 방법.
		// persons[2].name = "송지은";
		//p3.name = "송지은";

		// p1변수값과 persons[0]값을 비교.
		//System.out.println(persons[0] == p1);
		
		// 김경미 이름을 찾아서 나이를 22살로 바꾸기.
		// 반복 for ==(O,X) => equals
		for (int i = 0; i < persons.length; i++) {
			if(persons[i].name == "김경미") {
				persons[i].age = 22;
			}
			System.out.println((i + 1) + "번째 이름: " + persons[i].name + ", 나이: " + persons[i].age);
		}
		
		 
		//문자열 리트럴, 고정된 값을 코드 안에 넣는 것 
		//String kim = "김경미";
//		System.out.println(persons[1].name == kim);
		
		//나이를 변경할 이름을 입력받아 입력받은 나이로 바꾸어주기.
		Scanner scn = new Scanner(System.in);
		System.out.println("변경할 이름 >>> ");
		String name = scn.nextLine();
		System.out.println("변경할 나이 >>> ");
		int age = scn.nextInt();
		
		for(int i=0; i<persons.length; i++) {
			if(persons[i].name.equals(name)) {
				persons[i].age = age;
			}
			System.out.println((i + 1) + "번째 이름: " + persons[i].name + ", 나이: " + persons[i].age);
		}

		
//		for (int i = 0; i < persons.length; i++) {
//			System.out.println((i + 1) + "번째 이름: " + persons[i].name + ", 나이: " + persons[i].age);
//		}
		
	}
}
