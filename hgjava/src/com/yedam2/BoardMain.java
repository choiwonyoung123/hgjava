package com.yedam2;

import java.util.Scanner;

//메인 클래스
public class BoardMain {
	public static void main(String[] args) {
		BoardApp app = BoardApp.getInstance();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("메뉴 >> 1.추가 2.수정 3.조회 4.목록 5.삭제 6.종료");
			int menu = scn.nextInt();
			switch(menu) {
			//추가
			case 1:
				app.register();
				break;
			//수정
			case 2:
				app.modify();
				break;
			//조회
			case 3:
				app.search();
				break;
			//목록
			case 4:
				app.list();
				break;
			//삭제
			case 5:
				app.remove();
				break;
			//종료
			case 6:
				System.out.println("종료");
				app.storeToFile();
				run = false;
			}
		}
		System.out.println("end of program...");
	}
}
