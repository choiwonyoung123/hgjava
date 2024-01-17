package com.yedam.condition;

public class IFCondition {
	public static void main(String[] args) {
		boolean isTrue = true;
		isTrue = isTrue != true;
		if(isTrue) {
			System.out.println("참값입니다.");
		}
		else {
			System.out.println("거짓값입니다.");
		}
		int score = 60;
		if(score >= 90) {
			System.out.println("a등급");
		}
		else if(score >= 80) {
			System.out.println("b등급");
		}
		else {
			System.out.println("c등급");
		}
		System.out.println("end of program...");
	}
}
