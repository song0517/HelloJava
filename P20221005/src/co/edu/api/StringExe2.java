package co.edu.api;

import java.io.IOException;

public class StringExe2 {
	public static void main(String[] args) {
//		System.out.println("abcDEF".toUpperCase());
		while (true) {
			try {
				int bytes = System.in.read(); // abd -> 아스키코드로 읽어옴.. 65(A)~90(Z), 97(a)~122(z)
				
				if (bytes == 122) {
					break;
				}
					changeCapital(bytes);

				System.out.println("입력값: " + bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void changeCapital(int bytes) {
		// 대문자는 소문자로, 소문자는 대문자로
		// aBcD => AbCd 97:65 (차이는 32)
		if(bytes >= 97) {
			bytes -= 32;
		} else if(bytes <= 90){
			bytes += 32;
		}
		
		
	
}
}
