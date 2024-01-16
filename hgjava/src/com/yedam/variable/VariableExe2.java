package com.yedam.variable;

import java.util.Scanner;

public class VariableExe2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		System.out.println("이름을 입력>>");
//		System.out.println("나이를 입력>>");
//		String result = scn.nextLine();
//		int result = scn.nextInt();
//		System.out.println("당신의 이름은 " + result +"입니다.");
//		System.out.println("당신의 나이는 " + result +"입니다.");
		
		
		System.out.println("이름을 입력 >> ");
		String name = scn.nextLine();
		System.out.println("전화번호를 입력 >> ");
		String phone = scn.nextLine();
//		System.out.println("이름은 " + name);
//		System.out.println("전화번호는 " + phone);
		System.out.println("이름:" + name + " 전화번호:" + phone);
		System.out.println("영어점수를 입력 >> ");
		int eng = scn.nextInt();
		System.out.println("수학점수를 입력 >> ");
		int mat = scn.nextInt();
		int sum = eng + mat;
//		System.out.println("영어점수: " + eng + "점");
//		System.out.println("수학점수: " + mat + "점");
//		System.out.println("총합점수: " + sum + "점");
		System.out.println("영어:" + eng + " 수학점수:" + mat + " 종합점수:" + sum);
		scn.close();
	}
}
