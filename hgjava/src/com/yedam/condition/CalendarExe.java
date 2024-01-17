package com.yedam.condition;

import java.util.Scanner;

public class CalendarExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.printf("월을 입력:");
		int month = scn.nextInt();
        //int month = 3;
		//변수 - 월의 1이 위치하는
		//변수 - 월의 마지막날짜
		int lastDate = 31;
		int pos = 1;
		switch(month) {
			case 1: pos = 1; lastDate = 31; break;
			case 2: pos = 4; lastDate = 29; break;
			case 3: pos = 5; lastDate = 31; break;
			case 4: pos = 1; lastDate = 30; break;
			case 5: pos = 3; lastDate = 31; break;
			case 6: pos = 6; lastDate = 30; break;
			case 7: pos = 1; lastDate = 31; break;
			case 8: pos = 4; lastDate = 31; break;
			case 9: pos = 0; lastDate = 30; break;
			case 10: pos = 2; lastDate = 31; break;
			case 11: pos = 5; lastDate = 30; break;
			case 12: pos = 0; lastDate = 31; break;
		}
		//월 변경될때마다 마지막날계산
		System.out.println(" SUN MON TUE WED THU FRI SAT");
		for(int i = 0; i < pos; i++) {
			System.out.printf("%4s", " ");
		}
//		System.out.printf("%4s", " ");
		for(int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			if(i % 7 == (7-pos)) {
				System.out.println();
			}
//			if(i % 7 == 0) {
//				System.out.println();
//			}
		}
		System.out.println("\n======end of programs...======");
	}
}
