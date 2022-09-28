package co.edu.variable;

import java.util.Scanner;
import java.lang.System;
// java.lang 이 베이스 패키지이기 때문에 따로 선언 안해줘도 된다.

public class GetSameVal {
	public static void main(String[] args) {
		//사용자 입력값을 저장. Scanner클래스, import로 선언 : 기본 패키지가 아닐 경우 선언을 해줘야 쓸 수 있다. java.util이라는 패키지에 소속되어 있다.
		Scanner scn = new Scanner(System.in); //사용자입력값을 저장.
		
		//사용자 입력을 한 후 엔터를 치면 입력값을 읽고 반환하겠다는 의미.
		System.out.println("이름을 입력하세요>>> ");
		String name = scn.nextLine();
//		System.out.println("입력값 : " + name);
		
		// 값을 입력하면 names배열에서 같은 몇 번째 위치에 있는지 출력, 없으면 없다는 안내 출력.
		String[] names = {"김현지", "김유리", "남미주", "송지은"};
		boolean isChecked = false;
		for(int i=0; i<names.length; i++) {
			if(names[i].equals(name)) {  //문자열비교는 문자열.equals(비교문자열)
				System.out.println((i+1) + "번째");
				isChecked = true;
			}
		}
		
		if(isChecked == false) {
			System.out.println("문자가 없습니다.");
		}
			
		System.out.println("입력값 : " + name);
		scn.close();
	}
}
