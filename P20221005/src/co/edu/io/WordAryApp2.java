package co.edu.io;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordAryApp2 {
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		
		ArrayList<String> words = randomWords(10);
		for(String word : words) {
			System.out.println(word);
		}
		
	}
	
	public static ArrayList<String> randomWords(int times) throws Exception {
		ArrayList<String> words = new ArrayList<String>();
		
		String path = "src/co/edu/io/wordAry.txt";
		File file = new File(path);
		Scanner scn = new Scanner(file);
		
		while(scn.hasNext()) {
			String readStr = scn.nextLine();
			readStr = readStr.replaceAll("\"", "").trim();
			words.add(readStr.substring(0, readStr.indexOf(",")));
		}
		
		ArrayList<String> randomWords = new ArrayList<String>();
		
		Set<Integer> idxSet = new HashSet<>();
		while(idxSet.size() < times) {
			idxSet.add((int) (Math.random() * words.size()));
		}
		for(int idx : idxSet) {
			randomWords.add(words.get(idx));
		}
		
		scn.close();
		return randomWords;
	}
}
