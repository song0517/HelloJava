package co.edu.inherit.interfaces;

public class DaoMain {
	public static void main(String[] args) {
		EmpServiceImpl service = new EmpServiceImpl();
		service.setDb("인사");
		
		service.insert();
		service.delete();
		service.search();
		
		System.out.println();
		
		DeptServiceImpl service2 = new DeptServiceImpl();
		
		service2.insert();
		service2.delete();
		service2.search();
		
		System.out.println();
		
		//구현 클래스, 어디에 인터페이스가 연결되어 있을 경우 호출가능
		//각각 다른 인스턴스의 값이 있을 경우 각각의 메소드가 출력
		//어떤 인스턴스 할당과 상관없이 인터페이스 메소드만 호출하면 실행이 된다.
		DaoService dao = new EmpServiceImpl();
		dao = new DeptServiceImpl();
		dao.insert();
		dao.search();
		dao.delete();
	}
}
