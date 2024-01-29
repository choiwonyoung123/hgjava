package com.yedam.phonebook;

import java.util.Scanner;

//사용자메뉴 출력, 스캐너 활용,
public class MenuViewer {
	
	public static Scanner keyboard = new Scanner(System.in);
	
	
	public static void showMenu() {
		System.out.println("<전화번호관리>");
		System.out.println("1.입력:");
		System.out.println("2.조회:");
		System.out.println("3.삭제:");
		System.out.println("4.종료:");
		
	}
}
