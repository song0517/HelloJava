package co.edu.collect;

import java.util.Scanner;

public class ExcitingGame {
	public static void main(String[] args) {
		long gameStart = System.currentTimeMillis();
		String target = "necessary to create an applet and the classes an applet uses to communicate with its applet context";
		String[] targetAry = target.split(" ");
		Scanner scn = new Scanner(System.in);

		boolean check = true;

		while (true){
			System.out.print("입력 >>> ");
			String s = scn.nextLine();

			// 배열 사용
			for (int i = 0; i < targetAry.length; i++) {
				if (targetAry[i] != null && targetAry[i].equals(s)) {
					targetAry[i] = null;
				}
			}
			check = true;
			for (String str : targetAry) {
				if (str != null) {
					System.out.printf("%s ", str);
					check = false;
				}
			}
			long game = System.currentTimeMillis();
			
			if(((game - gameStart)/1000)%60 > 5) {
				System.out.println("시간초과");
				break;
			}
			
			if(check) {
				break;
			}
		}
		
		long gameEnd = System.currentTimeMillis();

		long sec = ((gameEnd - gameStart)/1000)%60; // 1*60*1000 + 30*1000 = 63000/60000분, 63000%60000초
		long min = (gameEnd - gameStart)/1000/60;
		
		System.out.println(min + "분" + sec + "초");
	}
}
