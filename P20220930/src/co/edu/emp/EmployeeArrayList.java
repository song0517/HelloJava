package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

//컬렉션을 활용해서 데이터 저장. -> ArrayList
public class EmployeeArrayList implements EmployeeService{
	ArrayList<Employee> list;
	int idx = 0;
	Scanner scn = new Scanner(System.in);

	@Override
	public void init() {
		list = new ArrayList<Employee>();
		System.out.println("초기화 완료.");
	}

	@Override
	public void input() {
		System.out.print("사번 >>> ");
		int eId = Integer.parseInt(scn.nextLine());
		
		System.out.print("이름 >>> ");
		String name = scn.nextLine();
		
		System.out.print("부서 Id >>> ");
		int deptId = Integer.parseInt(scn.nextLine());
		
		System.out.print("급여 >>> ");
		int sal = Integer.parseInt(scn.nextLine());
		
		System.out.print("이메일 >>> ");
		String email = scn.nextLine();
		
		Employee emp = new Employee(eId, name, sal, deptId, email);
		list.add(emp);
	}

	@Override
	public String search(int employeeId) {
		String result = null;
	//첫번째 방법
//		for(int i=0; i<list.size(); i++) {
////			if(list.get(i).getEmployeeId() == employeeId) {
////				result = list.get(i).getName();
////				break;
////			}
//			//Employee에 있는 한 건을 emp에 담기...?
//			Employee emp = list.get(i);
//			if(emp.getEmployeeId() == employeeId) {
//				result = emp.getName();
//				break;
//			}
//		}
		
	//2번째 방법
		for(Employee emp : list) {
			if(emp.getEmployeeId() == employeeId) {
				result = emp.getName();
				break;
			}
		}
		return result;
	}

	@Override
	public void print() {
		System.out.printf("%5s %10s %7s\n", "사원번호", "이름 ", "급여  ");
		System.out.println("==================================");
		for(int i=0; i<list.size(); i++) {
			System.out.printf("%5d %10s %7d\n", list.get(i).getEmployeeId(), list.get(i).getName(), list.get(i).getSalary());
//			System.out.println(list.get(i).toString());
		}
	}

	@Override
	public int searchSal(int employeeId) {
		int result = -1;
	//1번째
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).getEmployeeId() == employeeId) {
//				result = list.get(i).getSalary();
//				break;
//			}
//		}
		
	//2번째
		for(Employee emp : list) {
			if(emp.getEmployeeId() == employeeId) {
				result = emp.getSalary();
				break;
			}
		}
		return result;
	}
}
