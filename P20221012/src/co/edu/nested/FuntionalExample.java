package co.edu.nested;

import java.util.List;
import java.util.function.Consumer;

import co.edu.jdbc.Employee;
import co.edu.jdbc.EmployeeDAO;

//221014
public class FuntionalExample {
	public static void main(String[] args) {

		Consumer<String> consumer = (String t) -> System.out.println(t + "는 흥미롭습니다.");

		consumer.accept("자바");

		// 함수적 프로그래밍 -> 데이터 처리.
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> list = dao.search();

		// 시냇물이 흘러가는 느낌, 데이터가 흘러간다. : list에 있는 데이터를 하나씩 흘러보내는 stream을 만들겠다.
		// Consumer타입을 구현하는
		// forEach : 반복문을 매개값으로 람다식표현법을 사용하겠다..., 어떤 데이터의 기능을 사용하고 싶을 경우
		// db에서 가져온것을 stream으로 만들고 그것을 구현하겠다.. : 익명구현객체
		// 반복하면서 기능 수행..
		list.stream().forEach((t) -> System.out.println(t.toString()));
		
		//삭제, 수정 등 따로 클래스를 생성하지 않고 익명클래스, 람다식표현법을 이용해서 기능을 수행할 수 있도록 하는것...?
	}
}
