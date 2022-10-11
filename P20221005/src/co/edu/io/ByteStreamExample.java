package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//20221011
//595page~
//byte기반
public class ByteStreamExample {
	public static void main(String[] args) {
		try {
			fileCopy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// byte단위로 읽고 쓰기, 파일복사하기.
	public static void fileCopy() throws IOException {
		//읽기
		FileInputStream fis = new FileInputStream("C:/Temp/origin.jpg");
		//출력 : copy로 새로 만들기
		FileOutputStream fos = new FileOutputStream("C:/Temp/copy.jpg");
		//100바이트씩 실행
		byte[] buf = new byte[100];
		
		
		// 시간출력
		long start = System.currentTimeMillis();
		
		while(true) {
			//한 바이트씩 읽기
//			int bytes = fis.read();
			
			//buf만큼 읽기
			int bytes = fis.read(buf);
			if(bytes == -1) {
				break;
			}
			//읽고 쓰고 작업 반복.
//			fos.write(bytes);
			//배열의 크기만큼 버퍼에 저장하고 한번에 저장.
			fos.write(buf);
		}
		fos.close();
		fis.close();
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		System.out.println("complete.");
	}
	
	// 내가 지정한만큼 출력
	// 메인에 예외 던져주기.
	public static void writeBuf() throws IOException {
		byte[] arr = new byte[] {10, 20, 30};
		OutputStream os = new FileOutputStream("C:/Temp/data2.dat");
		//한번에 배열의 크기만큼 저장
		os.write(arr);
		os.close();
		
		System.out.println("complete.");
	}
	
	//배열의 크기만큼 읽기
	public static void readBuf() throws IOException {
		InputStream is = new FileInputStream("C:/Temp/data2.dat");
		//buf의 크기만큼 2byte씩 읽겠답.
		//arr부분을 두번씩 읽는다는 의미...(10,20), (30, ''), byte[2]는 2byte씩 읽어들이겠다는 의미(기존에는 1byte)
		byte[] buf = new byte[2];
		
		while(true) {
			int bytes = is.read(buf); //배열에 선언된 크기만큼 한번에 읽어들이겠다.
			if(bytes == -1) {
				break;
			}
			
			for(int i=0; i<bytes; i++) {
				System.out.print(buf[i] + " ");
			}
			System.out.println();
		}
		System.out.println("complete.");
		is.close();
	}

	public static void read() {
		// 입력 스트림
		// data1.dat에 있는 파일을 읽어옴...
		try {
			InputStream is = new FileInputStream("C:/Temp/data1.dat");

			while (true) {
				// 1byte씩 읽기 => read();, 더 이상 읽을 바이트가 없으면 -1 반환
				int bytes = is.read();
				if (bytes == -1) {
					break;
				}
				System.out.println(bytes);
			}
			
			is.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("complete.");
	}

	public static void write() {
		// 바이트 기반 출력 스트림
		// 파일안에 저장될 값...
		try {
			OutputStream os = new FileOutputStream("C:/Temp/data1.dat");
			// write(byte b)
			byte a = 10;
			byte b = 20;

			os.write(a);
			os.write(b);

			// resource 반환(끝)
			os.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("complete.");
	}
}
