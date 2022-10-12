package co.edu.collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Employee {
	int empId;
	String name;
	int salary;

	public Employee(int empId, String name, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	// 동일한 객체인지 아닌지 비교하는 코드 : hashCode, equlas
	// 비교하는 타입과 반환되는 타입이 같아야된다.
	@Override
	public int hashCode() {
		return empId;
	}

	// Object클래스 타입 가져와서 비교.
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			// 비교대상으로 들어온 매개값을 강제로 형변환(casting), target이 가지고 있는 아이디 값이랑 비교 대상이 가지고 있는 아이디
			// 값이랑 비교
			// Employee에 있는 타입 그대로 적용
			Employee target = (Employee) obj;
			return (this.empId == target.empId && this.name.equals(target.name) && this.salary == target.salary);
		} else {
			return false;
		}
	}
}

public class SetExample {
	public static void main(String[] args) {
		// Set에는 Employee인스턴스만 담겠다.
		Set<Employee> employees = new HashSet<Employee>();
		employees.add(new Employee(100, "홍길동", 1000));
		employees.add(new Employee(200, "박유식", 2000));
		employees.add(new Employee(300, "최윤기", 3000));
		employees.add(new Employee(100, "김길동", 4000));

		// 제거, 같다는 기준이 사원번호이기 때문에 사원번호를 기준으로 삭제
//		employees.remove(new Employee(100, "박길동", 5000));
		employees.remove(new Employee(100, "김길동", 4000));

		System.out.println(employees.size());

		// 반복자 사용해서 출력하기.
		Iterator<Employee> iter = employees.iterator();
		while (iter.hasNext()) {
			Employee emp = iter.next();
			System.out.printf("사번은 %d, 이름은 %s, 급여는 %d\n", emp.empId, emp.name, emp.salary);

		}

		// 중복 하용 x = set사용
		Set<Integer> set = new HashSet<Integer>();

		while (set.size() < 7) {
			set.add((int) (Math.random() * 45) + 1);
		}
		for(int n : set) {
			System.out.print(n + ", ");
		}

//		// 중복 저장 불가
//		int[] lotto = new int[7];
//		for(int i=0; i<lotto.length; i++) {
//			int temp = (int) (Math.random() * 7) + 1;
//			//현재 인덱스 값보다 적은 위치에 temp와 같은 값이 있는지 체크.
//			boolean exists = false;
//			for(int j=0; j<i; j++) {
//				// 같은 값이 있으면
//				if(lotto[j] == temp) {
//					exists = true;
//				}
//			}
//			if(exists) {
//				i--;
//				continue;
//			}
//			lotto[i] = temp;
//		}
//		
//		for(int n : lotto) {
//			System.out.printf("%d " , n);
//		}
	}
}
