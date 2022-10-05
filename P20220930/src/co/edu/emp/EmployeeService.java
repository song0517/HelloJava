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
	
	//급여정보가져오기 메소드, 사원아이디에 해당되는 급여정보 반환
	//리턴타입은 void말고 데이터타입으로 지정(int, String..)
	public int searchSal(int employeeId);
	
}
