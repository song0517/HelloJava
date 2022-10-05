package co.edu.api;

class Student {
	String name;
	int age;
	
	//name과 age가 같으면 동일...
	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj);
	}
}

public class ObjectExe {
	public static void main(String[] args) {
		Object obj = new Object();
		Object obj2 = new Object();
		
		//obj == obj2
		System.out.println(obj.equals(obj2));
		
		Student s1 = new Student();
		Student s2 = new Student();
		
		System.out.println(s1.equals(s2));
	}
}
