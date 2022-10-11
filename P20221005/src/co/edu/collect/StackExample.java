package co.edu.collect;

import java.util.Stack;

//20221011
//587page

class Coin {
	//필드
	private int val;
	
	//생성자
	public Coin(int val) {
		this.val = val;
	}
	
	public int getVel() {
		return val;
	}
}

public class StackExample {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<>();
		//추가
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(60));
		coinBox.push(new Coin(80));
		
		//출력
		//isEmpty() => 값이 있는지 비어있는지 확인, 값이 있으면 false 없으면 true?
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop(); //마지막 인스턴스부터
			System.out.println(coin.getVel());
		}
	}
}
