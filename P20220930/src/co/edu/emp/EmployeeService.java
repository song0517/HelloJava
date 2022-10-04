package co.edu.emp;

//기능만 정의 -> 추가 수정 삭제 조회..(CRUD 위주)
public interface EmployeeService {
	// 초기화(init)
	public void init();

	// 추가
	public void input();

	// 조회 : 아이디를 입력하면 이름을 리턴해주는 매소드
	public String search(int employeeId);
	
	// 전체 사원정보 출력
	public void print();
	
	
}
