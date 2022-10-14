package co.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManage {

	File file = new File("c:/Temp/studentList.txt");
	ArrayList<Student> studentList = new ArrayList<Student>();

	// 싱글톤 인스턴스 생성.
	private static StudentManage instance = new StudentManage();

	private StudentManage() {

	}

	public static StudentManage getInstance() {
		return instance;
	}

	// 등록.
	public void add(Student student) {
		studentList.add(student);
	}

	// 삭제.
	public void del(int studNo) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i) != null && studentList.get(i).getStudNo() == studNo) {
				studentList.remove(i);
				System.out.println("<<삭제되었습니다>>");
			} else {
				System.out.println("<<해당정보가 없습니다.>>");
			}
		}
	}

	// 목록(입력순서).
	public void list() {
		System.out.println("-------------------------------------");
		System.out.printf("%s %4s %4s %4s %3s %4s\n", "학번", "이름", "나이", "영어", "수학", "총점");
		System.out.println("-------------------------------------");

		for (int i = 0; i < studentList.size(); i++) {
			int sum = studentList.get(i).getEngScore() + studentList.get(i).getMathScore();
			System.out.printf("%d %4s %4d %4d %4d %5d", studentList.get(i).getStudNo(),
					studentList.get(i).getStudName(), studentList.get(i).getStudAge(), studentList.get(i).getEngScore(),
					studentList.get(i).getMathScore(), sum);
			System.out.println();
		}
	}

	// 순위(총점순서).
	public void ord() {
		List<Student> sortSt = new ArrayList<Student>();

		for (int i = 0; i < studentList.size(); i++) {
			sortSt.add(studentList.get(i));
		}

		for (int i = 0; i < studentList.size(); i++) {
			for (int j = i; j < studentList.size(); j++) {
				int sum = studentList.get(i).getEngScore() + studentList.get(i).getMathScore();
				int sum2 = studentList.get(j).getEngScore() + studentList.get(j).getMathScore();

				if (sum > sum2) {
					sortSt.remove(j);
					sortSt.add(i, studentList.get(j));
				}
			}
		}

		for (Student st : sortSt) {
			int sum = st.getEngScore() + st.getMathScore();
			System.out.println(st.getStudNo() + " " + st.getStudName() + " " + st.getStudAge() + " " + st.getEngScore()
					+ " " + st.getMathScore() + " " + sum);
		}
	}

	// 저장된 파일을 읽어오기.
	public void readFromFile() {
		try {
			FileReader fr = new FileReader(file); //
			BufferedReader br = new BufferedReader(fr);//

			String studentInfo = null;
			String[] itemAry = null;

			while (true) {
				studentInfo = br.readLine();
				if (studentInfo == null) { // 파일의 끝부분이면 종료.
					break;
				}
				itemAry = studentInfo.split(" ");
				int no = Integer.parseInt(itemAry[0]);
				String name = itemAry[1];
				int age = Integer.parseInt(itemAry[2]);
				int eng = Integer.parseInt(itemAry[3]);
				int math = Integer.parseInt(itemAry[4]);
				Student student = new Student(no, name, age, eng, math);
				studentList.add(student);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("읽을 파일이 없습니다.");
		}
	} // 입력스트림

	// 입력된 내용을 파일에 저장하기.
	public void storeToFile() {
		try {
			FileWriter fw = new FileWriter(file);

			for (Student student : studentList) {
				fw.write(student.getStudNo() + " " + student.getStudName() + " " + student.getStudAge() + " "
						+ student.getEngScore() + " " + student.getMathScore() + "\n");
			}

			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // 출력스트림

}
