package com.yedam.condition;

public class ArrayExe1 {
	public static void main(String[] args) {
//		int[] intAry = {10, 20, 30}; // 정수 배열
//		intAry = new int[]{10, 20, 30, 40, 50};
////		intAry = new int[10];
//		System.out.println(intAry[4]);
////		intAry[3] = 40;
////		System.out.println(intAry);
//		String[] strAry = {"hong", "kim", "park"}; // 문자열 배열	
//		System.out.println(strAry[0]);
//		System.out.println(strAry.length);
//		strAry[2] = "jang";
//		System.out.println(strAry[2]);
//		for(int i = 0; i < 10; i++) {			
//			System.out.println(intAry[i]);
//		}
//		String[] days = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};
//		for(int i = 0; i < days.length; i++) {
//			System.out.printf("%4s", days[i]);
//		}
		
		
		int[] intAry = {};
		for(int i = 0; i < 10; i++) {
			intAry[i] = (int)(Math.random() * 10);
		}
		int sum2, sum3;
		sum2 = sum3 = 0;
		for(int i = 0; i < 10; i++) {
			System.out.println(intAry[i]);
			if(intAry[i] % 2 == 0 && intAry[i] % 3 == 0) {
				sum2 += intAry[i];
				sum3 += intAry[i];
			}
			if(intAry[i] % 2 == 0) {
				sum2 += intAry[i];
			}
			if(intAry[i] % 3 == 0) {
				sum3 += intAry[i];
			}
		}
		System.out.printf("2의배수:%d", sum2);
		System.out.printf("2의배수:%d", sum3);
	}
}
