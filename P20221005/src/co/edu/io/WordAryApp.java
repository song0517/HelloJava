package co.edu.io;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//20221011
public class WordAryApp {
	public static void main(String[] args) throws Exception {
		//임의 문장을 10개씩 출력하고 타이핑해서 맞으면 사라지고 아니면 남아있는...
		Scanner scn = new Scanner(System.in);
		
		ArrayList<String> words = randomWords(1);
		for(String word : words) {
			System.out.println(word);
		}
		
		boolean check = true;
		
		while(true) {
			System.out.print("입력 >>> ");
			String inputVal = scn.nextLine();
			
			for(int i=0; i<words.size(); i++) {
				if(words.get(i) != null && words.get(i).equals(inputVal)) {
					words.remove(i);
				}
			}
			
//			check = true;
			for(String str : words) {
				if(str != null) {
					System.out.println(str);
//					check = false;
				}
			}
			
			//words가 모두 비었다면 끝내라.. -> isEmpty()
			if(words.isEmpty()) {
				System.out.println("끝");
				break;
			}
			
//			if(check) {
//				System.out.println("끝");
//				break;
//			}
		}
	}
	
	//ArrayList에 전체 문장을 담고 times수 만큼 리턴
	public static ArrayList<String> randomWords(int times) throws Exception{
		ArrayList<String> words = new ArrayList<String>();
		//파일 경로
		String path = "src/co/edu/io/wordAry.txt";
		//파일 객체의 매개값으로 넣기
		File file = new File(path);
		//스캐너 클래스 읽기용도
		Scanner scn = new Scanner(file);
		//값이 있는지 체크
		while(scn.hasNext()) {
			//한줄씩 입력
			String readStr = scn.nextLine();
			//문장만 가져오기.
			//따옴표 없애기 \", 공백없애기 trim()
			readStr = readStr.replaceAll("\"", "").trim();
//			System.out.println(readStr);
			//인덱스값부터 두번째 있는 위치까지 잘라내겠다. ,의 위치 사이의 값을 잘라서 words에 저장
			words.add(readStr.substring(0, readStr.indexOf(",")));
		}
		
		// 임의의 갯수 times 갯수만큼 반환하도록.
		ArrayList<String> randomWords = new ArrayList<String>();
		
//		while (randomWords.size() < times) {
//			int a = (int) (Math.random() * words.size());
//			randomWords.add(words.get(a));
//		}
		
		// 중복된 값 제거 : Set 사용
		Set<Integer> idxSet = new HashSet<>();
		while (idxSet.size() < times) {
			idxSet.add((int) (Math.random() * words.size()));
		}
		for(int idx : idxSet) {
			randomWords.add(words.get(idx));
		}
		
		scn.close();
		return randomWords;
	}
}
