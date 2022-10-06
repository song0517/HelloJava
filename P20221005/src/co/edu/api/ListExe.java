package co.edu.api;

import java.util.ArrayList;

public class ListExe {
	public static void main(String[] args) {
		int[] intAry = new int[5];
		ArrayList<Integer> list = new ArrayList<Integer>();
		//자동 박싱..
		list.add(100);
		
		int a = 5;
		
		Integer b = 10;  //int => Integer.(자동으로 클래스..박싱...)
		a=b; //언박싱
		
	}
}
