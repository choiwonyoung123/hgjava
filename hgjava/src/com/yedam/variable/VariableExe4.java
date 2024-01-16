package com.yedam.variable;

public class VariableExe4 {
	public static void main(String[] args) { //
		// boolean > true, false
		boolean isTrue;
		isTrue = update(15);
		if(isTrue) {
			System.out.println(">참<");
		}
		else {
			System.out.println(">거짓<");
		}
		
		
		Member m1 = new Member(); // m1 인스턴스
		m1.name = "홍길동";
		m1.age = 20;
		m1.height = 167.8;
		
		Member m2 = new Member(); // m2 인스턴스
		m2.name = "김민수";
		m2.age = 23;
		m2.height = 172.5;
		
		isTrue = m1.height > m2.height; // 거짓
		isTrue = m1.age == m2.age; // 거짓
		isTrue = m1 == m2; // 거짓
		System.out.println(m1);
		System.out.println(m2);
		
		byte a = 10;
		int b = a; // 자동 형변환 byte > int
		
		double d1 = 10.0;
		double result = d1 + 20; // 자동 형변환 int > double
		System.out.println(result);
		
		int sum = 60;
		result = sum / 7;
		System.out.println(result);
		
		String str = "1" + 3;
		sum = Integer.parseInt("1") + 3;
		double sum2 = Double.parseDouble("1.234") + 4;
		System.out.println(str);
		System.out.println(sum);
		System.out.println(sum2);
	} //
	public static boolean update(int arg) { // boolean 메서드
		return arg % 2 == 0;
	} //
}
