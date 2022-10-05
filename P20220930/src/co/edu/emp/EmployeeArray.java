package co.edu.emp;

import java.util.Scanner;

//배열 활용해서 정보 저장.
public class EmployeeArray implements EmployeeService {
	// 데이터가 저장될 공간 생성
	Employee[] list;
	// 필드는 int 초기값이 0;
	int idx = 0;

	Scanner scn = new Scanner(System.in);

	@Override
	public void init() {
		System.out.print("사원수 입력 >>> ");
		int cnt = Integer.parseInt(scn.nextLine());
		// Employee의 공간 지정해주기. 5개 인스턴스를저장할 수 있는 공간 생성
		list = new Employee[cnt];
	}

	@Override
	public void input() {
		if (idx >= list.length) {
			System.out.println("더 이상 입력 불가.");
			// input 메소드 종료
			return;
		}

		System.out.print("사번 >> ");
		int eId = Integer.parseInt(scn.nextLine());

		System.out.print("이름 >> ");
		String name = scn.nextLine();

		System.out.print("부서 Id >> ");
		int detpId = Integer.parseInt(scn.nextLine());

		System.out.print("급여 >> ");
		int sal = Integer.parseInt(scn.nextLine());

		System.out.print("이메일 >> ");
		String email = scn.nextLine();

		Employee emp = new Employee(eId, name, sal, detpId, email);

		// list라는 배열에 값 추가하여 순서대로 넣기 -> 0번째에 넣기
		list[idx++] = emp;
	}

	@Override
	public String search(int employeeId) {
		// 입력된 값 중에서 찾도록. list[5] = 실제로 입력된 인덱스 값 idx기준으로 반복실행하기
		//리턴변수는 상황에 맞춰 String 또는 int로 하기. -> 지금은 이름을 리턴하는 것이기 때문에 String
		String result = null;
		for (int i = 0; i < idx; i++) {
			if (list[i].getEmployeeId() == employeeId) {
				result = list[i].getName();
				break;
			}
		}
		return result;
	}

	@Override
	public void print() {
		for (int i = 0; i < idx; i++) {
//			System.out.printf("%5s %5s %5s\n", "사번", "이름", "급여");
			System.out.printf("%5d %10s %7d\n", list[i].getEmployeeId(), list[i].getName(), list[i].getSalary());
		}
	}

	@Override
	public int searchSal(int employeeId) {
		// 사원번호-> 급여
		int result = -1;
		for(int i=0; i <idx; i++) {
			if(list[i].getEmployeeId() == employeeId) {
				result = list[i].getSalary();
				break;
			}
		}
		return result;
	}
}
