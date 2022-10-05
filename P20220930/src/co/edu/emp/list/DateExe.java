package co.edu.emp.list;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateExe {
	//날짜, 시간 제공
	public static void main(String[] args) {
		Date today = new Date();
//		today.setYear(2022);
//		today.setMonth(11);
		String ymd = "2022-10-05 13:14:15";
		//2022-10-05, 날짜 포멧 
		//현재시간
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(today));
		
		//날짜형식으로 되어있는 것을 형식 바꾸기...예외처리... -> 프로그램이 강제로 종료되지 않도록 예외처리해주기.
		//에러발생했을 경우 catch안에 있는 구문을 실행하겠다..;
		try {
			today = sdf.parse(ymd);
			System.out.println(today);
		} catch (ParseException e) {
			e.printStackTrace();
		} //end of try-catch
		
		// 날짜(LocalDate), 시간(LocalTime) => LocalDateTime
		LocalDateTime day = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh시mm분ss초");
//		day.format(dtf);
		day = LocalDateTime.of(2022, 10, 5, 10, 20, 30);
		System.out.println(day.format(dtf));
	}
}
