package co.edu.emp.list;

import java.util.Calendar;

//기능만 제공
//static가 없으면 MethodCalendar를 쓰기위한 인스턴스필요 -> CalendarApp에 코드작성.
public class MethodCalendar {
	//정적인 타입으로 인스턴스 생성, 정적인 타입으로 메소드 생성
	private static MethodCalendar instance = new MethodCalendar();
	private MethodCalendar() {}
	public static MethodCalendar getInstance() {
		return instance;
	}
	
	public void makeCal(int year, int month) {
		System.out.println("      >>> " + year + "년 " + month + "월 <<<");
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		//배열에 들어있는 갯수만큼 for 반복, for(요소를 받아놓기 위한 변수 : 배열 이름)
		for(String day : days) {
			//%자리수s, %4s->4글자로 고정해서 day에서 가져오는 요소보다 남은 자리수 공백 지정,, 뒤에 가져오는 값이 문자일 경우 's', 숫자일 경우 'd'
			System.out.printf("%4s", day);
		}
		System.out.println();
		
		//1일의 위치지정.
		for(int i=0; i<getFirstDay(year, month); i++) {
			System.out.printf("%4s", " ");
		}
		//날짜 출력
		for(int i=1; i<=getLastDate(year, month); i++) {
			System.out.printf("%4d", i);
			if((i+getFirstDay(year, month)) % 7 ==0) {
				System.out.println();
			}
		}
	} // end of makeCal()
	
	//월 정보를 입력하면 1일의 요일정보를 출력
	public int getFirstDay(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1 , 1);
		//1일의 요일 구하기.
		return cal.get(Calendar.DAY_OF_WEEK) -1; 
		}// end of getFirstDay(int month)
	
	// 월 정보를 입력하면 해당 월의 마지막 날짜 구하기
	public int getLastDate(int year, int month) {
		 Calendar cal = Calendar.getInstance();
		 cal.set(year, month-1, 1);
		 return cal.getActualMaximum(Calendar.DATE);
	}// end of getLastDate(int month)
	
} // end of class.
