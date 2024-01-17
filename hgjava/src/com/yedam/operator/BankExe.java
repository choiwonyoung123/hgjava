package com.yedam.operator;

import java.util.Scanner;

public class BankExe {
	public static void main(String[] args) {
		// 입금, 출금, 잔고, 종료
		Scanner scn = new Scanner(System.in);
		int balance = 0;
		boolean run = true;
		
		while(run) {
			System.out.println("[1.입금 2.출금 3.잔고 4.종료] 중 선택:");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
				case 1:
					System.out.println("입금할 금액을 입력하세요:");
					int input = Integer.parseInt(scn.nextLine());
					if(balance + input > 100000) {
						System.out.println("100000원을 초과해서 입금할 수 없습니다.");
						break;
					}
					else {
						balance += input;
						System.out.println("입금 완료.");
						
					}
					break;
				case 2:
					System.out.println("출금할 금액을 입력하세요.");
					int output = Integer.parseInt(scn.nextLine());
					if(balance - output < 0) {
						System.out.println("0원 미만으로 출금할 수 없습니다.");
						break;
					}
					else {						
						balance -= output;
						System.out.println("출금 완료.");
					}
					break;
				case 3:
					System.out.println("잔액 = "+balance+"원");
					break;
				case 4:
					run = false;
					break;
			}
		}
		System.out.println("End of program...");
	}
}
