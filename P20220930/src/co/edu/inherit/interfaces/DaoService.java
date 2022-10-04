package co.edu.inherit.interfaces;

public interface DaoService {
	//필드X, 생성자X
	// 메소드는 모두 추상메소드
	//필드대신 상수값을정의(변하지 않는 값)\
	
	//앞에 abstract를 붙이지 않아도 모두 추상메소드이다.
	public void insert();
	public void search();
	public void delete();
}
