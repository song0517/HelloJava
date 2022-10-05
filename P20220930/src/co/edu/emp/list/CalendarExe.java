package co.edu.emp.list;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		//날짜제공
		//캘린더 인스턴스 생성
		Calendar today = Calendar.getInstance();
		//2022년 10월 1일이라는 뜻, 날짜 지정
		today.set(2020, 1, 1);
		//요일 정보 보기(Day_of_week)-> 토요일이라는 의미, 1은 일요일
		System.out.println("요일정보 : " + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("날짜정보 : " + today.get(Calendar.DATE));
		//1월은 -> 0, 정확한 값을 위해 +1 필요
		System.out.println("월정보 : " + (today.get(Calendar.MONTH)+1));
		System.out.println("월 마지막 날짜 정보 : " + today.getActualMaximum(Calendar.DATE));
	}
}
