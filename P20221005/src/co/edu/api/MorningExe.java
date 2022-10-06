package co.edu.api;

public class MorningExe {
	public static void main(String[] args) {
		int s = 1;
		for (int i = 4; i > 0; i--) {
			for (int n = 0; n < (5 - i); n++) {
				System.out.printf("%3d", s);
				s = s + 1;
			}
			for (int j = 0; j < (i - 1); j++) {
				System.out.printf("%3s", "");
			}
			System.out.println();
		}
		System.out.println();
		
		int x=1;
		for (int i = 4; i > 0; i--) {
			for (int j = 0; j < (i - 1); j++) {
				System.out.printf("%3s", "");
			}
			for (int n = 0; n < (5 - i); n++) {
				System.out.printf("%3d", x);
				x = x + 1;
			}
			System.out.println();
		}
	}
}
