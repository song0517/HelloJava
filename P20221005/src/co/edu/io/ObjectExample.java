package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

// 20221011
//ObjectOutputStream을 사용하기 위해서는 Serializable을 구현하는 클래스 implements사용해야 가능 : implements Serializable
class Emp implements Serializable {
	int id;
	String name;
	String dept;

	public Emp(int id, String name, String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "사원id: " + id + ", 이름: " + name + ", 부서: " + dept;
	}
}

public class ObjectExample {
	public static void main(String[] args) {

		// try구문 안에 선언과 close를 모두 함께 실행
		try (FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
				ObjectInputStream oos = new ObjectInputStream(fis);) {
			// object 타입을 arraylist타입으로 변환
			ArrayList<Emp> list = (ArrayList<Emp>) oos.readObject();

			for (Emp emp : list) {
				System.out.println(emp.toString());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void writeObj() {
		// 입출력 스트림 -> Class 인스턴스 생성 -> 파일 입출력으로 저장.
		// ObjectInputStream, ObjectOutputStream : Object 기반.
		// Class 인스턴스 생성
		ArrayList<Emp> empList = new ArrayList<>();
		empList.add(new Emp(100, "홍길동", "인사"));
		empList.add(new Emp(200, "김민식", "개발"));
		empList.add(new Emp(300, "이유진", "총무"));

		// 파일 입출력으로 저장.
		try (FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
				// 보조스트림 : 기본스트림 매개값을 받아서 사용
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			// object타입을 쉽게 write할수 있다.
			oos.writeObject(empList);

//			//역방향, 안할경우 파일이 열리지 않는다., try() : 괄호 안에 output을 사용할 경우 close따로 지정안해도 된다.
//			oos.close();
//			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("completed.");
	}
}
