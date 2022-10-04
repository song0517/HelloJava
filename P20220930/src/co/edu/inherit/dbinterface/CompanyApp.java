package co.edu.inherit.dbinterface;

//20221004 인터페이스
public class CompanyApp {
	public static void main(String[] args) {
		// 추가, 수정, 삭제, 조회 기능
//		MysqlDAO dao = new MysqlDAO();
//		dao.insert();
//		dao.update();
//		dao.search();
//		dao.delect();

		// 인터페이스 없는 상태로 데이터 교환할 경우의 예시, 이름이 다 바뀐다.
//		OracleDAO dao = new OracleDAO();
//		dao.add();
//		dao.modify();
//		dao.finde();
//		dao.remove();

		// 인터페이스를 구현하는 클래스
		DaoService dao = new MysqlDAO(); // ver1.0
		// 인터페이스를 사용할 경우 코드 수정없이 인터페이스를 사용해서 간단하게 교환하기 -> 할당하는 인스턴스만 바꿔주면 된다.
		// 인터페이스를 두는 이유는 메소드만 알고있으면 뒤에 어떠한 구현객체가 할당되었는지 신경쓰지 않아도 괜찮다...?
		dao = new OracleDAO(); // ver2.0
		dao.insert();
		dao.modify();
		dao.search();
		dao.remove();
		
		System.out.println();

		// 익명구현객체 : 클래스이름을 선언할 필요없이 기능만 설정, 인터페이스를 구현하는 코드만 존재
		// 중괄호 안에 인터페이스가 가지고 있는 추상메소드를 구현하면 된다.
		// 인터페이스에 정해진 규칙에 따라 그대로 정해주기.
		DaoService anonym = new DaoService() {

			@Override
			public void insert() {
				System.out.println("익명db 입력.");
			}

			@Override
			public void modify() {
				System.out.println("익명db 수정.");
			}

			@Override
			public void remove() {
				System.out.println("익명db 삭제.");
			}

			@Override
			public void search() {
				System.out.println("익명db 조회.");
			}
		};
		
		anonym.insert();
		anonym.modify();
		anonym.remove();
		anonym.search();
	}
}
