package co.edu.api;

import java.util.ArrayList;
import java.util.List;

//내용물을 담기위한 박스
//<T> : 타입파라메타, 어떤 타입인지는 모르겠지만 object처럼 모든 타입을 사용하고 클래스를 사용하는 시점에 정하겠다.
class Box<T> {
	T obj;
	void set(T obj) {
		this.obj = obj;
	}
	T get() {
		return obj;
	}
}

class Member { 
	private String name;
	private String id;
	private int point;
	
	//생성자
	public Member(String name, String id, int point) {
		super();
		this.name = name;
		this.id = id;
		this.point = point;
	}
	
	//get set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}

class Employee {
	private String empName;
	private String empId;
	private int salary;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", salary=" + salary + "]";
	}
	
	
}

public class StringExe3 {
	public static void main(String[] args) {
		
		Box<String> box = new Box<String>();
		box.set("Hello");
		//String에 제한되어 오류 발생...
//		box.set(200);
//		String result = (String) box.get();
//		Integer result = (Integer) box.get();
		String result = box.get();
		System.out.println(result);
		
		//제너릴..? <데이터타입> 정해서 해당 타입에 맞는 값만 사용가능하도록 설정
		String[] stAry;
//		List<String> list;
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		
		//컬렉션 : 데이터를 받아 넘기도록 하는 역할..?
		List<Member> members = new ArrayList<Member>();
		members.add(new Member("홍길동", "hong", 10000));
		members.add(new Member("김민기", "kim", 20000));
		members.add(new Member("박인기", "park", 3000));
		
		//멤버클래스에 각각의 값들을 employee클래스 타입으로 바꿔서 employees로 바꿔주기...
		List<Employee> employees = changeType(members);
		for(Employee emp : employees) {
			System.out.println("이름:" + emp.getEmpName() + ", 아이디: " + emp.getEmpId() + ", 급여: " + emp.getSalary());
//			System.out.println(emp.toString());
		}
	}
	
	//Member타입의 collect에 들어온것을 Employee타입으로 바꾸기
	public static List<Employee> changeType(List<Member> collect) {
		// 3 -> 3
		List<Employee> empls = new ArrayList<Employee>();
		
		//자바스크립트에 for of와 같다.
		for(Member member : collect) {
			//인스턴스, 객체생성..
			Employee emp = new Employee();
			emp.setEmpId(member.getId());
			emp.setEmpName(member.getName());
			emp.setSalary(member.getPoint());
			
			empls.add(emp);	
		}
		return empls;
	}
}
