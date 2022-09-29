package co.edu.variable;

public class MethodExample {
	public static void main(String[] args) {
		int result = getArea(20,15);
		System.out.println("전체 너비는 " + result);
		
		int[] intAry = {23, 45, 12};
		result = sumAry(intAry);
		System.out.println("intAry 배열요소의 합계는 " + result);
		
		/*
			int[] intAry2 = {22, 33, 44, 55};
			result =sumAry(intAry2);
			System.out.println("intAry2 배열요소의 합계는 " + result);
		*/
		
		// 실수를 담을 수 있는 데이터 타입 : float, double(기본)
		double d1 = 23.4567;
		double d2 = 12.34;
//		double d3 = d1 + d2;
		double d3 = divide(d1, d2);
		System.out.println("두 수를 나눈 결과는 " +d3);
		
		//나눌때 0이 있을 경우.
		d3 = divide(3, 0);
		System.out.println("두 수를 나는 결과는 " + d3);
		
		/*
		 * double 사용해서 계산 double result = (double)n1 / n2; 메소드 부분.
		d3 = divide(3, 2);
		System.out.println("두 수를 나는 결과는 " + d3);
		*/
		
	}
	
	// 1) 가로, 세로의 정수 타입을 넣어주면 넓이를 구하는 메소드. 
	public static int getArea(int w, int h) {
		int sp = w * h;
		return sp;
	}
	
	// 2) 배열요소의 각 값의 합을 구하는 메소드, ary 배열이름을 사용하겠다...
	public static int sumAry(int[] ary) {
		int sum = 0;
		for(int i=0; i<ary.length; i++) {
			sum += ary[i];
		}
		return sum;
	}
	
	// 3) 두수의 나눈 결과를 반환.
	public static double divide(double n1, double n2) {
		double result = n1 / n2;
		return result;
	}
	
	// 4) 두수를 나누는 작업. 매개변수를 int 타입으로 지정
	public static double divide(int n1, int n2){
		// 유형 : byte(1byte), short(2byte), int(4byte), long(8byte)
		//       float(4), double(8)
		//소수점도 함께 나오도록 출력, 두 값 중 큰 타입에 따라서 연산 ex) 3/2=>1.5
		//내부적으로 int를 long 타입으로 자동형변환이 되어서 처리, int n1은 long n1이 된다.
		//double타입이 long보다 크기 때문에 n1 또는 n2 중 하나면 double타입으로 지정을 할 경우 자동형변환이 되어 소수점 아래까지의 결과값이 출력이 될 수 있다.
		if(n2 == 0) {
			return 0;
		}
		double result = n1 / n2;
		//double result = (double)n1 / n2;  
		return result;
	}
}
