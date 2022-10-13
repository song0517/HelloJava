package co.edu.api;

import java.util.HashSet;
import java.util.Set;

//Object가 가지고 있는 메소드 살펴보기...?

class Student {
	String name;
	int age;
	
	@Override
	public String toString() {
		return "학생의 이름은 " + name + ", 나이는 " + age + "살입니다.";
	}
	
	// 인스턴스가 할당되면 만들어진 객체가 가지고 있는 독특한 값(유니코드)을 16진수(해시코드)로 표현.. -> 동일한 값이면 동일하게 나타나겠다..?
	// 역할 : Set 컬렉션 -> 동일한 인스턴스는 담아주지않는 함수 역할
	@Override
	public int hashCode() {
		return age;
	}

	// name별, age별 비교하여 같으면 true를 리턴.
	// 부모클래스가 가지고 있는 메소드를 자식클래스에서 재정의 = Override
	@Override
	public boolean equals(Object obj) {
		// Student의 인스턴스 이면 비교...->obj가
		// c3은 Student의 인스턴스가 아니기 때문에 바로 false 실행.
		if (!(obj instanceof Student)) {
			return false;
		}
		Student str = (Student) obj;
//		return super.equals(obj);
		
		if (this.name.equals(str.name) && this.age == str.age)
			return true;

		return false;
	}
	
}

//모든 클래스의 최상위 Object.
public class ObjectExe {
	public static void main(String[] args) {
		Object obj = new Object();
		Object obj2 = new Object();
		// obj == obj2
		System.out.println(obj.equals(obj2));
		
		System.out.println();

		Student s1 = new Student();
		s1.name = "Hong";
		s1.age = 10;
		Student s2 = new Student();
		s2.name = "Hong";
		s2.age = 10;
		String s3 = "Hong";

		System.out.println(s1.equals(s3));
		System.out.println(s1.toString());
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println();
		
		// Set 컬렉션 : 인터페이스  -> 구현클래스 통해서 인스턴스 생성., 중복된 값은 가지지 않겠다는 특징
		//<Integer> : 정수타입만 가능...
		Set<Integer> set = new HashSet<Integer>();
		set.add(new Integer(100));
		set.add(new Integer(110));
		set.add(new Integer(100));
		
		System.out.println("컬렉션의 크기 : " + set.size());
		
		// Set 컬렉션에 Student 인스턴스 저장시 논리적으로 동일한 인스턴스 판단.
		// hasCode(), equals() => 기준.
		Set<Student> students = new HashSet<Student>();
		students.add(s1);
		students.add(s2);
		System.out.println("컬렉션의 크기 : " + students.size());
		
		for(Student st : students) {
			System.out.println(st);
		}
		
	}
}
