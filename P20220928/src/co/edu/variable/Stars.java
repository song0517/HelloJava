package co.edu.variable;

public class Stars {
	public static void main(String[] args) {
		star(5);
	}

	public static void star(int a) {
		String s = "";
		for (int i = 1; i <= a; i++) {
			s = "";
			for (int j = 1; j < i; j++) {
				s += "*";
			}
			s += i;
			System.out.print(s);
			System.out.println();
		}
	}
}
