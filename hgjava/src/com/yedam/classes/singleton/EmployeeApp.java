package com.yedam.classes.singleton;

import java.util.Scanner;

public class EmployeeApp {
	public static void main(String[] args) {
		EmployeeList app = EmployeeList.getInstance();
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int menu = 0;
		
		while(run) {
			System.out.println("[1.사원수  2.사원입력  3.사원리스트  4.검색  5.급여합계  9.종류]");
			System.out.print("메뉴선택");
			menu = scn.nextInt();
			
			if(menu == 1) {
				app.init();
			}
			else if(menu == 2) {
				app.input();
			}
			else if(menu == 3) {
				app.print();
			}
			else if(menu == 4) {
				System.out.print("조회할 사번입력:");
				int no = scn.nextInt();
				String name = app.search(no);
				if(name.equals("")){
					System.out.println("조회할 사원이 없습니다.");
				}
				else {
					System.out.println("이름:" + name);
				}
			}
			else if(menu == 5){
				System.out.printf("급여합계:%d\n", app.sum());
			}
			else if(menu == 9) {
				run = false;
				System.out.println("종료..");
			}
			else {
				System.out.println("잘못된 번호입니다.");
			}
		}
		System.out.println("end of program..");
	}
}
