package com.yedam.variable;

public class VariableExe1 {
	public void sum() {
		int n2;
	}
	public static void main(String[] args) {
		int n1 = 100000;
		int n2 = 200000;
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(Integer.MAX_VALUE); // 대문자 > 클래스
		System.out.println("최원영");
		System.out.println("최원영");
		Math.random(); // 0~1 사이 임의의 실수
		double n3 = Math.random(); // 0~1 사이 임의의 실수
		double n4 = Math.random()*45; // 1~45 사이 임의의 실수
		System.out.println(n3);
		System.out.println(n4);
		int n5 = (int) (Math.random()*45); // int 형변환
		System.out.println(n5);
		String str = "홍길동"; // 대문자 > 클래스
		System.out.println(str);
		byte b1 = -128; // 8비트 - 바이트 > -128~127까지
		System.out.println(b1);
		System.out.println(Short.MAX_VALUE); // 대문자 > 클래스
		short s1 = 32767;
		short s2 = (short)(s1 - 30); // 연산자는 정수 타입
		int i1 = (int) (s1 - 30); // 연산자는 정수 타입
		double d1 = 40;
		double d2 = (double) 40;
	}
}
