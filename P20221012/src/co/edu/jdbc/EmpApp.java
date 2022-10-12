package co.edu.jdbc;

//20221012
import java.util.List;

public class EmpApp {
	public static void main(String[] args) {
		EmployeeDAO empDao = new EmployeeDAO();
		
		//입력
		int empId = 600;
		String lastName = "Hong";
		String email = "hongkil@email";
		String jobId = "ST_MAN";
		String hireDate = "2021-05-11";
		Employee emp1 = new Employee(empId, lastName, email, hireDate, jobId);
		
//		empDao.insert(emp1);
		empDao.update(emp1);
//		empDao.delete(empId);
//		System.out.println(empDao.getEmp(empId));;
		
		
		//조회
		List<Employee> employees = empDao.search();
		
		for(Employee emp : employees) {
			System.out.println(emp);
		}
	}
}
