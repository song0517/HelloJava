package co.edu.api;

import java.io.IOException;

public class StringExe2 {
	public static void main(String[] args) {
//		System.out.println("abcDEF".toUpperCase());
		String output = "";
		char tmp;

		byte[] bytes = new byte[100];

		while (true) {
			try {
				int by = System.in.read(bytes); // abd -> 아스키코드로 읽어옴.. 65(A)~90(Z), 97(a)~122(z)
				String str = new String(bytes, 0, by - 2);

				if (by == 122) {
					break;
				}
				changeCapital(str);
				//System.out.println("입력값: " + str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void changeCapital(String str) { // 대문자는 소문자로, 소문자는 대문자로 // aBcD
		// aBcD=> AbCd 97:65 (차이는 32) 
		String input = "";
		String output = "";
		input = str;
		char tmp;

		for (int i = 0; i < input.length(); i++) {
			tmp = input.charAt(i);

			if ((65 <= tmp) && (tmp <= 90)) {
				output += input.valueOf(tmp).toLowerCase();
			} else if ((97 <= tmp) && (tmp <= 122)) {
				output += input.valueOf(tmp).toUpperCase();
			} else {
				output += (char) tmp;
			}
		}
		System.out.println("반환된 문자열 : " + output);
	}
}
