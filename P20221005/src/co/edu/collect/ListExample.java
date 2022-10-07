package co.edu.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListExample {
	public static void main(String[] args) {
		ArrayList<String> strs = new ArrayList<String>();
		//추가.
		strs.add("홍길동");
		strs.add("김민식");
		strs.add("박유식");
		
		//삭제
		strs.remove(0);
		strs.remove("박유식");
		
		//특정위치 추가
		strs.add(0, "최기분");
		
		//크기확인
		System.out.println("collect의 크기 : " + strs.size());
		
		//반복해서 값 들고오기
		for(String str : strs) {
			System.out.println(str);
		}
		for(int i=0; i<strs.size(); i++) {
			System.out.printf("%d번째의 값은 %s\n", i, strs.get(i));
		}
		
		//반복자를 생성
		//반복자에서 가져온것을 itr에 저장 후 hasNext()를 통해 가져올 값이 있는지 확인한 후 true일 경우 반복문 실행
		Iterator<String> itr = strs.iterator();
		while(itr.hasNext()){
			String result = itr.next();
			System.out.println(result);
		}
		
		//100만건 넣기 시간차이
		ArrayList<Integer> inAry = new ArrayList<Integer>();
		long start = System.nanoTime(); //현재시점을 나노타임으로 나타내기
		for(int i=0; i<1000000; i++) {
			inAry.add(i);
		}
		long end = System.nanoTime(); //끝나는 시점 나노타임으로 나타내기
		System.out.println("ary: " + (end-start));
		
		start = System.nanoTime();
		LinkedList<Integer> lnAry = new LinkedList<Integer>();
		for(int i=0; i<1000000; i++) {
			lnAry.add(i);
		}
		end = System.nanoTime();
		System.out.println("lna: " + (end-start));
	}
}
