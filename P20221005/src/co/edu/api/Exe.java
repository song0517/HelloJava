package co.edu.api;

import java.util.Scanner;

public class Exe {
	public static void main(String[] args) {
		String input = "";
		String output = "";
		char tmp;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("문자 입력 >>> ");
		input = scanner.nextLine();
		
		for(int i =0; i<input.length(); i++) {
			tmp = input.charAt(i);
			
			if((65 <= tmp) && (tmp <= 90)) {
				output += input.valueOf(tmp).toLowerCase();
			} else if((97 <= tmp)  && (tmp<=122)) {
				output += input.valueOf(tmp).toUpperCase();
			} else {
				output += (char)tmp;
			}
		}
		System.out.println("반환된 문자열 : " + output);
	}
}	
