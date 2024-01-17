package com.yedam.condition;

import java.util.Scanner;

public class WhileLoopExe1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int random = (int)(Math.random()*1000) + 1;
		int cnt = 0;
		while(true) {
			System.out.println("갑 입력 >> ");
			int input = scn.nextInt();
			if(random > input) {
				System.out.println("임의의 값은 입력한 값보다 큰 수입니다!");
				cnt++;
			}
			else if(random < input) {
				System.out.println("임의의 값은 입력한 값보다 작은 수입니다!");
				cnt++;
			}
			else if(random == input) {
				System.out.printf("임의의 값은 %d입니다!\n",random);
				cnt++;
				if(cnt <= 10) {					
					System.out.printf("%d번 만에 맞추셨습니다!!!\n", cnt);
				}
				else {
					System.out.printf("%d번 만에 맞추셨습니다ㅠㅠㅠ\n", cnt);
				}
				break;
			}
//			System.out.println("틀린값!");
		}
		System.out.println("end of program...");
	}
}
