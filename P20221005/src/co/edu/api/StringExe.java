package co.edu.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringExe {
	public static void main(String[] args) {
//		String fileName = "src/co/edu/api/Data.txt";
		String fileName = "src/co/edu/api/Birth.txt";
		File file = new File(fileName);

//		String searchKey = "자바";
//		String searchKey = "자 바";
//		//공란제거(replace)
//		searchKey = searchKey.replace(" ", "");

		Scanner scn = null;
		try {
			scn = new Scanner(file);
			while (true) {
				String str = scn.nextLine();
				if (str == null)
					break;

//				if (str.indexOf(searchKey) != -1) {
//					System.out.println(str);
//				}
				
				//남자입니다. 여자입니다.
//				str = str.replace("-", "");
//				str = str.replace(" ", "");
//				
//				char sex = str.charAt(6);
//				switch (sex) {
//				case '1':
//				case '3':
//					System.out.println("남자 입니다.");
//					break;
//				case '2':
//				case '4':
//					System.out.println("여자 입니다.");
//					break;
//				}
				if(str.replace("-", "").charAt(6) % 2 == 1) {
					System.out.println("남자 입니다.");
				} else if(str.replace("-", "").charAt(6) % 2 == 0){
					System.out.println("여자 입니다.");
				} else { //년도, 월, 일 정보가 잘못되면 잘못된 번호로 인식(13월은 없다..)
					System.out.println("잘못된 번호입니다.");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {

		}

		System.out.println("end of prog.");
	}
}
