package co.edu.inherit.dbinterface;
//20221004 인터페이스
public class MysqlDAO implements DaoService{

	@Override
	public void insert() {
		System.out.println("mysql 저장");
	}
	@Override
	public void modify() {
		System.out.println("mysql 수정");
	}
	@Override
	public void remove() {
		System.out.println("mysql 삭제");
	}
	@Override
	public void search() {
		System.out.println("mysql 조회");
	}
	
	//인터페이스 없이 했을 경우
//	public void insert() {
//		System.out.println("mysql 저장");
//	}
//	
//	public void search() {
//		System.out.println("mysql 조회");
//	}
//	
//	public void delect() {
//		System.out.println("mysql 삭제");
//	}
//	
//	public void update() {
//		System.out.println("mysql 수정");
//	}
	
	
}
