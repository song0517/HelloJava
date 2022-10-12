package co.edu.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EmpMain {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = null;

		Scanner scn = new Scanner(System.in);
		

		// 메뉴 => 1.사원등록(insert) 2.한건조회(getEmp) 3.수정 4.삭제 5.목록조회 6.일괄등록 9.종료
		while (true) {
			System.out.println("1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 6.일괄등록 9.종료");
			System.out.print("입력 >>> ");
			int menu = scn.nextInt();
			scn.nextLine();

			if (menu == 1) {
				System.out.print("사원 아이디>>> ");
				int empId = scn.nextInt();
				scn.nextLine();
				System.out.println("사원 이름>>> ");
				String lastName = scn.nextLine();
				System.out.println("사원 이메일>>> ");
				String email = scn.nextLine();
				System.out.println("사원 입사일>>> ");
				String hireDate = scn.nextLine();
				System.out.println("사원 직무>>> ");
				String jobId = scn.nextLine();
				emp = new Employee(empId, lastName, email, hireDate, jobId);
				dao.insert(emp);

			} else if (menu == 2) {
				System.out.print("조회하고 싶은 사원 아이디>>> ");
				int empId = scn.nextInt();
				System.out.println(dao.getEmp(empId));

			} else if (menu == 3) {
				System.out.println("수정하고 싶은 사원 아이디>>> ");
				int empId = scn.nextInt();
				scn.nextLine();

				System.out.println("사원 이메일>>> ");
				String email = scn.nextLine();

				System.out.println("사원 입사일>>> ");
				String hireDate = scn.nextLine();

				System.out.println("사원 직무>>> ");
				String jobId = scn.nextLine();

				emp = new Employee(empId, null, email, hireDate, jobId);

				dao.update(emp);

			} else if (menu == 4) {
				System.out.println("삭제하고 싶은 사원 아이디>>> ");
				int empId = scn.nextInt();
				if (dao.delete(empId)) {
					System.out.println("정상적으로 삭제");
				} else {
					System.out.println("삭제할 데이터 없음");
				}
			} else if (menu == 5) {
				List<Employee> employees = dao.search();

				for (Employee emp1 : employees) {
					System.out.println(emp1);
				}
			} else if (menu == 6) {
				String[] emps = null;

				try (FileReader fr = new FileReader("C:/Temp/emplist.txt"); 
						BufferedReader br = new BufferedReader(fr);) 
				{
					while(true) {
						String emp2 = br.readLine();
						if(emp2 == null) {
							break;
						}
						emps = emp2.split(" ");
						emp = new Employee(Integer.parseInt(emps[0]), emps[1], emps[2], emps[3], emps[4]);
						dao.insert(emp);
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("completed.");
				
			} else if (menu == 9) {
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴번호입니다.");
			}
		}
		scn.close();
	}
}
