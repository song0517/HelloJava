package co.edu.collect;
//20221011
//588page

import java.util.LinkedList;
import java.util.Queue;

public class QueExample {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();
		//추가
		que.offer("Hong");
		que.offer("Park");
		que.offer("choi");
		
		//출력
		while(!que.isEmpty()) {
			System.out.println(que.poll());
		}
	}
}
