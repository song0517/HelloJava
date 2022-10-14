package co.edu.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//20221011
// 문자기반(2byte) 스트림 생성. Reader / Writer
public class CharStreamExample {
	public static void main(String[] args) {
		read();
	}
	
	public static void read() {
		try {
			FileReader reader = new FileReader("C:/Temp/addr.txt");
//			FileReader reader = new FileReader("src/co/edu/io/ByteStreamExample.java");
			
			while(true) {
				int bytes = reader.read();
				
				if(bytes == -1) {
					break;
				}
				// 정수타입을 char타입으로 바꾸기
				System.out.print((char) bytes);
			}
			reader.close();
			System.out.println("completed.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write() {
		Scanner scn = new Scanner(System.in);
		
		// 출력 스트림
		try {
			FileWriter fw = new FileWriter("C:/Temp/addr.txt");

			while (true) {
				System.out.print(">> ");
				String temp = scn.nextLine();
				if (temp.equals("quit")) {
					break;
				}

				fw.write(temp + "\n");
			}

			fw.close();
			scn.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("completed.");
	}
}
