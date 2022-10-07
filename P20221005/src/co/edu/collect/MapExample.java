package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		// key:Integer, val:String, 선언을 각자 해주어야된다.
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "홍길동");
		map.put(200, "김기영");
		map.put(300, "박문식");
		//같은 키 값이 있으면 덮어쓰기해버린다!
		map.put(300, "윤문식");
		
		//삭제
		map.remove(300);
		
		//map의 사이즈
		System.out.println("컬렉션크기 : " + map.size());
		//해당 키값의 값이 출력
		System.out.println("val : " +map.get(300));
		
		System.out.println();
		
		// 반복자 생성., 키 값만 가져오기
		Set<Integer> keySet = map.keySet(); //키만 새로운 set컬렉션에 저장.
		for(Integer key : keySet) {
			System.out.println("키: " + key + ", 값: " + map.get(key));
		}
		
		System.out.println();
		
		// 키와 값 모두 가져오기.
		Set<Entry<Integer, String>> entSet = map.entrySet();
		for(Entry<Integer, String> ent : entSet) {
			System.out.println("키: " + ent.getKey() + ", 값: " + ent.getValue());
		}
	}
}
