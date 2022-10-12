package co.edu.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;

public class EmpFileToJDBC {
	public static void main(String[] args) {
		String[] emps = null;
		EmployeeDAO dao = new EmployeeDAO();
		Employee employees = null;

		try (FileReader fr = new FileReader("C:/Temp/emplist.txt"); 
				BufferedReader br = new BufferedReader(fr);) 
		{
			while(true) {
				String emp = br.readLine();
				if(emp == null) {
					break;
				}
				emps = emp.split(" ");
				employees = new Employee(Integer.parseInt(emps[0]), emps[1], emps[2], emps[3], emps[4]);
				dao.insert(employees);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("completed.");
	}
}
