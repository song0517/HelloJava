package co.dev;

import java.util.ArrayList;

//221014
public class StudExample {
	public static void main(String[] args) {
		Student stud = new Student(101, "홍길동", 80);
		String name1 = stud.getStudName();
		int score1 = stud.getScore();
		
		ArrayList<Student> studList = new ArrayList<Student>();
		studList.add(stud);
		studList.add(new Student(102, "김현수", 88));
		
		studList.add(0, new Student(103, "박문수", 78));
		
		//김현수 뒤에 담고 싶다...
		Student hong = new Student(201, "홍수환", 90);
		for(int i=0; i<studList.size(); i++) {
			if(studList.get(i).getStudName().equals("김현수")) {
				studList.add(i, hong);
				break;
			}
		}
		
		// 출력
		for(int i = 0; i<studList.size(); i++) {
			System.out.println(studList.get(i).getStudName());
		}
		
		// 학생번호 기준으로 정렬
		ArrayList<Student> sortAry = new ArrayList<Student>();
		
		for(int i=0; i<studList.size(); i++) {
			for(int j=0; j<i; j++) {
//				if(studList.get(i).getStudNo())) {
//									}
			}
		}
	}
}
