package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

//20221011
// 모든 예외를 던지겠답
public class EmpObjectExam {
	public static void main(String[] args) throws Exception {

		// C:/Temp/emp.dat 읽어들이는 기능 생성
		// 이전에 저장했던 값 계속 누적
		FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		// 읽어들이는거 저장 -> Object클래스타입을 ArrayList<Emp>클래스타입으로 불러오기
		ArrayList<Emp> empList = (ArrayList<Emp>) ois.readObject();
		ois.close();
		fis.close();

		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("1.사원 등록 2.목록출력 3.삭제 4.종료");
			System.out.println("선택 >>> ");

			int menu = scn.nextInt();
			scn.nextLine();
			String[] empAry = null;

			if (menu == 1) {
				// 사원번호, 이름, 부서 입력
				// 1. 하나씩 스캔
//				System.out.println("사원 id 입력 >>> ");
//				int id = scn.nextInt(); scn.nextLine();
//				System.out.println("사원 이름 입력 >>> ");
//				String name = scn.nextLine();
//				System.out.println("사원 부서 입력 >>> ");
//				String dept = scn.nextLine();
//				empList.add(new Emp(id, name, dept));

				// 2. split 이용
				System.out.println("ex)100 홍길동 인사 => 빈칸으로 구분지어 주세요.");
				System.out.print(">> ");
				String empVal = scn.nextLine();
				empAry = empVal.split(" ");
				Emp emp = new Emp(Integer.parseInt(empAry[0]), empAry[1], empAry[2]);
				empList.add(emp);
				System.out.println("입력완료.");

				// 3. 미정...
//				System.out.print(">> ");
//				String empVal = scn.nextLine();
//				int idx = 0;
//				
//				while (scn.hasNext()) {
//					empAry[idx++] = scn.next();
//				}
//				empAry = empVal.split(" ");
//				Emp emp = new Emp(Integer.parseInt(empAry[0]), empAry[1], empAry[2]);

			} else if (menu == 2) {
				// 목록 출력
				for (Emp emp : empList) {
					System.out.println(emp.toString());
				}

			} else if(menu == 3) { 
				//삭제
				System.out.print("삭제하고 싶은 사원 id >>> ");
				int id = scn.nextInt();
				
				for(int i=0; i<empList.size(); i++) {
					if(empList.get(i) != null && empList.get(i).id==id)
					empList.remove(i);
				}
				System.out.println("삭제완료.");
				
			} else if (menu == 4) {
				// 컬렉션에 있던 ObjectOutputStream을 활용해서 C:/Temp/emp.dat 저장하고 종료.
				try (FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
						ObjectOutputStream oos = new ObjectOutputStream(fos);) {

					oos.writeObject(empList);

				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("종료합니다.");
				break;
				
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		}
	}
}
