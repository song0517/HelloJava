package co.edu.inherit.friend;

import java.util.ArrayList;

public class ArrayExam {
	public static void main(String[] args) {
		String[] flowers = new String[3];
		flowers[0]="장미";
		flowers[1]="해바라기";
		flowers[2]="무궁화";
//		flowers[3] = "목련";
		
		//flowers2 선언
		String[] flowers2 = new String[6];
		flowers2[0]=flowers[0];
		

		for(String str : flowers2) {
			if(str != null) {
				System.out.println(str);
			}
		}
		
		
		//배열의 크기 고정 => 컬렉션(ArrayList);
		ArrayList flowers3 = new ArrayList();  //따로 크기를 지정안하면 10개의 공간을 차지. 10씩 공간이 늘어난다.
		flowers3.add("장미"); //첫번째 위치 장미저장.
		flowers3.add("해바라기");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
//		flowers3.add(123);
		
		//Object 모든 클래스의 최상위 클래스  -> 모든 변수타입을 지정할 수 있다, 단 형변환이 필요하다.
		for(Object str : flowers3) {
			String result = (String) str;
			System.out.println(result);
		}
		
		//ArrayList를 통해 배열을 선언하여 인덱스를 이용해서 값을 출력하고 싶을 경우 size()를 사용
		//컬렉션의 크기 : size();
		for(int i=0; i<flowers3.size(); i++) {
			String result = (String) flowers3.get(i);
			System.out.println(result);
		}
	}
}
