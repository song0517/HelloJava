package co.edu.common;

//DB연결 확인
public class MainExe {
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.getConnect();
	}
}
