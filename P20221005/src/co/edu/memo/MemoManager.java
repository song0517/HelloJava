package co.edu.memo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//20221011
public class MemoManager {
	// 조회, 입력, 삭제

	// 정보를 임시로 담아놓기 위함 컬렉션.
	List<Memo> memoStorage = new ArrayList<>();
	// 읽고 쓰는 용도
	File file = new File("C:/Temp/memobook.dat");
	// 입력
	Scanner scn = new Scanner(System.in);

	// 싱글톤 방식
	private static MemoManager instance = new MemoManager();

	// 실행을 하면 파일 읽어오기 먼저 샐행이 되도록
	private MemoManager() {
		readFromFile();
	}

	public static MemoManager getInstance() {
		return instance;
	}

	// 추가
	public void inputData() {
		System.out.print("번호 입력 >>> ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.print("날짜 입력 >>> ");
		String date = scn.nextLine();
		System.out.print("내용 입력 >>> ");
		String content = scn.nextLine();

		memoStorage.add(new Memo(no, date, content));
	}

	// 조회 -> 날짜 기준으로 모든 내용 출력
	public void searchData() {
		System.out.print("날짜 입력 >>> ");
		String sDate = scn.nextLine();

		boolean exists = false;
		for (int i = 0; i < memoStorage.size(); i++) {
			if (sDate.equals(memoStorage.get(i).getDate())) {
				System.out.println(memoStorage.get(i).toString());
				exists = true;
			}
		}

		if (!exists) {
			System.out.println("해당날짜의 메모가 없습니다.");
		}
	}

	// 삭제 -> 번호 입력하면 한건 삭제.
	public void deletData() {
		System.out.print("번호 입력 >>> ");
		int sNo = Integer.parseInt(scn.nextLine());

		boolean check = false;

		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i) != null && memoStorage.get(i).getNo() == sNo) {
				memoStorage.remove(i);
				System.out.println("삭제 완료");
				check = true;
			}
		}

		if (!check) {
			System.out.println("해당 번호의 메모가 없습니다.");
		}
	}

	// 프로그램실행이 되면 파일을 읽어서 데이터를 memoStorage에 담기.
	public void readFromFile() {
		// try with resource : 따로 클로즈 작업을 명시하지 않아도 클로즈
		try (FileInputStream fis = new FileInputStream(file); 
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			memoStorage = (List<Memo>) ois.readObject();

		} catch (Exception e) {
//			e.printStackTrace();
			return;
		}
	}

	// 종료하면 파일저장.
	public void storeToFile() {
		try (FileOutputStream fos = new FileOutputStream(file); 
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(memoStorage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
