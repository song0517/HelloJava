package co.edu.emp;

//데이터 한건 처리 클래스
//사원번호, 이름, 부서....
public class Employee {
	// 사원번호, 사원이름, 부서번호, 부서명, 급여, 이메일
	private int employeeId; // 사번
	private String name; // 이름
	private int deptId; // 부서번호 10:인사, 20:개발 30:영업(기본값)
	private String deptName; // 부서명
	private int salary; // 급여
	private String email; // 이메일

	// 기본 생성자 -> 매개값이 없는 생성자
	public Employee() {
		this.deptId = 30;
		this.deptName = "영업";
	}

	// 매개값이 4개 있는 생성자
	public Employee(int employeeId, String name, int salary, int deptId) {
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.deptId = deptId;
		if (this.deptId == 10) {
			this.deptName = "인사";
		} else if (this.deptId == 20) {
			this.deptName = "개발";
		} else {
			this.deptName = "영업";
		}
	}

	// 매개값이 3개 있는 생성자
	public Employee(int employeeId, String name, int salary) {
		// 위에 있는 4개 생성자 호출
		this(employeeId, name, salary, 30);
	}

	// 매개값이 2개 있는 생성자
	public Employee(int employeeId, String name) {
		// 위에 있는 3개 생성자 호출, 사번과 이름을 넣었을 경우 급여를 입력하지 않을 경우 0으로 초기값
		this(employeeId, name, 0);
	}

	// 매개값이 5개 있는 생성자
	public Employee(int employeeId, String name, int salary, int deptId, String email) {
		this(employeeId, name, salary, deptId);
		this.email = email;
	}

// 사번
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

// 이름
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

// 부서번호
	public int getDeptId() {
		return deptId;
	}
	
	public void setDeptId(int deptId) {
		this.deptId = deptId;
		//아이디에 따라 부서이름 배정
		if (this.deptId == 10) {
			this.deptName = "인사";
		} else if (this.deptId == 20) {
			this.deptName = "개발";
		} else {
			this.deptName = "영업";
		}
	}

// 부서이름
	public String getDeptName() {
		return deptName;
	}
//	public void setDeptName(String deptName) {
//		this.deptName = deptName;
//	}

// 급여
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

// 이메일
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
