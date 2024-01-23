package com.yedam.classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExe {
	public static void main(String[] args) {
		final int num = 10;
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		cal.set(2024, 0, 1);
		//Calendar cal2 = Calendar.getInstance();
		//System.out.println(cal1 == cal2);
		//System.out.println(Calendar.YEAR);
		//System.out.println("year:" + cal.get(1));
		//System.out.println("year:" + cal.get(Calendar.YEAR));
		//System.out.println("year:" + cal.get(Calendar.DATE));
		//System.out.println("year:" + cal.get(Calendar.DAY_OF_WEEK));
		//System.out.println("lastdate:" + cal.getActualMaximum(Calendar.DATE));
		
		Date date = new Date(); //1900년부터 계산
		//date.setYear(123);
		//date.setMonth(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {			
			date = sdf.parse("2024-01-01"); //string > date 바꾸기
		}catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(date.getYear()+1900);
		System.out.println(date.getMonth());
		//System.out.println(date.getDate());

		
		//drawCalendar(2024, 6);
		drawCalendar(date);
	}
	//날짜계산
	static void drawCalendar(Date date) {
		//문자열로 넣어서 날짜계산
	}
	//날짜계산 - calendar 클래스
	static void drawCalendar(int year, int month) {
		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, year);
//		cal.set(Calendar.MONTH, month);
		cal.set(year, month-1, 1);
		int pos = cal.get(Calendar.DAY_OF_WEEK) - 1;
		int lastDate = cal.getActualMaximum(Calendar.DATE);
		System.out.println(" SUN MON TUE WED THU FRI SAT");
		//String[] days = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};
		for(int i = 0; i < pos; i++) {
			System.out.printf("%4s", " ");
		}
		for(int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			if(i % 7 == (7-pos)) {
				System.out.println();
			}
//			if(i % 7 == 0) {
//				System.out.println();
//			}
		}
		
		
		//System.out.println("day:" + cal.get(Calendar.DAY_OF_WEEK));
		//System.out.println("year:" + cal.get(Calendar.YEAR));
		//System.out.println("month:" + cal.get(Calendar.MONTH));
		//System.out.println("lastdate:" + cal.getActualMaximum(Calendar.DATE));
		//System.out.println(" SUN MON TUE WED THU FRI SAT");
	}
}
