package com.yedam.operator;

import java.util.Scanner;

public class OperatorExe1 {
	public static void main(String[] args) {
//		int sum = (1 + 2) * 3;
//		sum = sum + 5;
//		sum += 5;
//		System.out.println(sum);
		
		int result = 0;
		Scanner scn = new Scanner(System.in);
		//정수입력
		//누적값
		while(true) {
			System.out.println("정수입력 >> ");
			String input = scn.nextLine();
			if(input.equals("quit")){
				break;
			}
			try {				
				result += Integer.parseInt(input);
			}
			catch (Exception e) {
				System.out.println("잘못된 값 입력...");
			}
		}
		System.out.printf("누적값 : %d\n", result);
		System.out.println("End of program...");
		
		
//		method1();
//		System.out.println("\nend of prog..");
	}
	public static void method1(){
		String str = "";
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("문자열입력 >> ");
			String input = scn.nextLine();
			if(input.equals("quit")){
				break;
			}
			str += input + " ";
		}
		System.out.println("입력값: " + str);
		System.out.printf("입력값: %s", str);
	}
}
