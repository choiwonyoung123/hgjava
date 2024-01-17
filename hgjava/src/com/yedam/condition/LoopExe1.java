package com.yedam.condition;

import java.util.Scanner;

public class LoopExe1 {
	public static void main(String[] args) {
		//구구단
//		int num = 5;
//		System.out.printf("구구단 %d단 출력\n", num);
//		for(int i = 1; i <= 9; i++) {
//			System.out.printf("%d * %d = %d\n", num, i, (num*i));
//		}
		
//		for(int i = 2; i <= 9; i++) {
//			System.out.printf("구구단 %d단\n", i);
//			for(int j = 1; j <= 9; j++) {
//				System.out.printf("%d * %d = %d\n", i, j, i*j);
//			}
//			System.out.println();
//		}

		
		//구구단 가로 출력
//		method1();
		
		
		//별
//		String star = "";
//		Scanner scn = new Scanner(System.in);
//		System.out.printf("숫자를 입력:");
//		int input = scn.nextInt();
//		for(int i = 1; i <= input; i++) {
//			star += "*";
//			System.out.println(star);
//		}
		for(int i = 2; i <= 100; i++) {
			for(int j = 1; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void method1() {
		for(int i = 1; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.printf("%d * %d = %d\t", j, i, j*i);
//				System.out.printf("%2d * %2d = %2d", j, i, j*i);
			}
			System.out.println();
		}
	}
}
