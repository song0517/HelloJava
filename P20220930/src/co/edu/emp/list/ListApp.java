package co.edu.emp.list;

import java.util.ArrayList;

import co.edu.emp.Employee;

public class ListApp {
	public static void main(String[] args) {
	// 배열보다는 컬렉션(ArrayList(인덱스 위치로 접근), HashSet(중복된 값을 처리하지 않음), HashMap(키와 value로 처리))
	// 배열선언
		String[] strAry = new String[10];
		
	// ArrayList -> 따로 선언을 하지 않을 경우 오브젝트타입으로 값을 저장 및 처리
	// Object <- 모든클래스
		ArrayList list2 = new ArrayList();
		
	// 원하는 타입을 지정해줄 때 < >안에 타입을 정해주면 된다.
	// 선언을 해줄때 <String>을 입력해주면 문자열 타입만 저장 가능하다는 규칙이 생성
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("Employee");
		
		for(int i=0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	// 정수타입 선언
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(100);
		
	// Employee 타입만 가능
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(100, "홍길동", 1000));
		empList.add(new Employee(200, "김민수", 2000));
		empList.add(new Employee(300, "박인기", 3000));
		empList.add(new Employee(400, "황석용", 4000));
		
		String result = null;
		int salary = 0;
		for(int i=0; i<empList.size(); i++) {
			if(empList.get(i).getEmployeeId() == 200) {
				result = empList.get(i).getName();
				salary = empList.get(i).getSalary();
			}
		}
		System.out.println("이름은 " + result +"이고, 급여는 " + salary + "입니다.");
		
	}
}
