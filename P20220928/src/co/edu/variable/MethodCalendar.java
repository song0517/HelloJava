package co.edu.variable;

public class MethodCalendar {
	public static void main(String[] args) {
		//호출을 의미
		makeCal(9);
	}
	
	//반복문을 가지고 달력 출력
	//static는 정적메소드는 클래스.makeCal이라고 하면 실행.
	public static void makeCal(int month) {
		System.out.println("        >>> " + month + " 월 <<<");
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		//배열에 들어있는 갯수만큼 for 반복, for(요소를 받아놓기 위한 변수 : 배열 이름)
		for(String day : days) {
			//%자리수s, %4s->4글자로 고정해서 day에서 가져오는 요소보다 남은 자리수 공백 지정,, 뒤에 가져오는 값이 문자일 경우 's', 숫자일 경우 'd'
			System.out.printf("%4s", day);
		}
		System.out.println();
		
		//1일의 위치지정.
		for(int i=0; i<getFirstDay(month); i++) {
			System.out.printf("%4s", " ");
		}
		//날짜 출력
		for(int i=1; i<=getLastDate(month); i++) {
			System.out.printf("%4d", i);
			if((i+getFirstDay(month)) % 7 ==0) {
				System.out.println();
			}
		}
		
	} // end of makeCal()
	
	public static int getFirstDay(int month) {
		if(month == 9) {
			return 4;
		} else if(month == 8) {
			return 1;
		} else if(month == 7) {
			return 5;
		} else if(month == 6) {
			return 3;
		}
			return 0;
		}// end of getFirstDay(int month)
	
	public static int getLastDate(int month) {
		switch(month) {
			case 9 : 
				return 30;
					
			case 8 : 
				return 31;
				
			case 7 :
				return 31;
				
			case 6 :
				return 30;
			
			default : 
				return 30;
			 		 
		}
	}// end of getLastDate(int month)
	
} // end of class.
