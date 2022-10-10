package co.edu.collect;

import java.util.ArrayList;
import java.util.Scanner;

class Employ {
	String empId;
	String empName;
	int salary;

	public Employ(String empId, String empName, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "empId=" + empId + ", empName=" + empName + ", salary=" + salary;
	}
}

public class MorningCode {
	public static void main(String[] args) {
		// String tok = "Hello World Good";
		// Scanner scn = new Scanner(tok);

		// 가져올 값이 있는지 체크 후 모두 가져오기.
		// while(scn.hasNext())
		// System.out.println(scn.next());

		// 공백을 기준으로 문장을 나누어 새로운 배열에 넣어주겠다. : split
		// String[] toks = tok.split(" ");
		// for(String str : toks) {
		// System.out.println(str);
		// }

		// 문제 :
		Scanner scanner = new Scanner(System.in);
		// ArrayList에 저장.
		ArrayList<Employ> empl = new ArrayList<Employ>();

		while (true) {
			System.out.println("입력 >> ex) 100 홍길동 2500");
			String inputVal = scanner.nextLine();
			// 첫번째 값=> empId, 두번째 값 => empName, 세번째 값 => salary
			String[] sp = inputVal.split(" ");

			// 종료를 하고 싶으면 quit 종료.
			if (sp[0].equals("quit")) {
				break;
			}
			
			if(sp.length != 3) {
				System.out.println("다시 입력..");
				continue;	
			}
			
			// Employ클래스의 인스턴스 생성
			empl.add(new Employ(sp[0], sp[1], Integer.parseInt(sp[2])));
		}

		// 종료 후 for(반복문) 입력 값들 출력.
		for (Employ emps : empl) {
			System.out.println(emps.toString());
		}
	}
}
