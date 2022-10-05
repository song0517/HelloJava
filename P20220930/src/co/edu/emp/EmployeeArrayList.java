package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

//컬렉션을 활용해서 데이터 저장. -> ArrayList
public class EmployeeArrayList implements EmployeeService {
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
		int eId = readInt("사번 >>> ");

		System.out.print("이름 >>> ");
		String name = scn.nextLine();

		// 부서입력 & 예외처리(10,20,30이 아닐경우)
		int deptId = -1;
		while (true) {
			deptId = readInt("부서ID >>> ");
			try {
				validDept(deptId);
				break;
			} catch (InvalidDeptException e1) {
				System.out.println(e1.getMessage());
			}
		}

		int sal = readInt("급여 >>> ");

		System.out.print("이메일 >>> ");
		String email = scn.nextLine();

		Employee emp = new Employee(eId, name, sal, deptId, email);
		list.add(emp);
	}

	@Override
	public String search(int employeeId) {
		String result = null;
		// 첫번째 방법
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

		// 2번째 방법
		for (Employee emp : list) {
			if (emp.getEmployeeId() == employeeId) {
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
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%5d %10s %7d\n", list.get(i).getEmployeeId(), list.get(i).getName(),
					list.get(i).getSalary());
//			System.out.println(list.get(i).toString());
		}
	}

	@Override
	public int searchSal(int employeeId) {
		int result = -1;
		// 1번째
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).getEmployeeId() == employeeId) {
//				result = list.get(i).getSalary();
//				break;
//			}
//		}

		// 2번째
		for (Employee emp : list) {
			if (emp.getEmployeeId() == employeeId) {
				result = emp.getSalary();
				break;
			}
		}
		return result;
	}

	//10,20,30부서id처리 메소드
	public void validDept(int dept) throws InvalidDeptException {
		int validDept = dept % 10;
		if (validDept != 0 || dept > 30) {
			throw new InvalidDeptException("잘못된 부서정보입니다.");
		}
	}

	//숫자외 예외타입 작성 메소드
	public int readInt(String msg) {
		int result = -1;
		while (true) {
			System.out.println(msg);
			try {
				result = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
			}
		}
		return result;
	}
}
