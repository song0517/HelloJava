package co.edu;

public class SingletonMain {
	public static void main(String[] args) {
		// 1) Student
		Student s1 = new Student();
		Student s2 = new Student();
		
		// 2) Singleton, new 사용못해서 getInstance로 선언
		Singleton sg1 = Singleton.getInstance(); 
		Singleton sg2 = Singleton.getInstance(); 
		
		// 각각 인스턴스가 다르다
		System.out.println(s1 == s2);
		// sg1이 가지고 있던 인스턴스가 sg2가 그대로 가지고 있다. 여러개의 인스턴스를 사용해야 될 때....인스턴스가 동일하다.
		System.out.println(sg1 == sg2);
	}
}
