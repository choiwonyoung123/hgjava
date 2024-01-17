package com.yedam.condition;

public class ForLoopExe1 {
	public static void main(String[] args) {
//		for(int i = 1; i <= 10; i+=2) {
//			System.out.println(i);
//			if(i > 5) {
//				break;
//			}
//		}
//		int sum = 0;
//		for(int n = 1; n <= 10; n++) {
//			if(n % 3 == 0) {				
//				sum += n;
//			}
//		}
//		System.out.println("누적값:"+sum);
		//달력 만들기
		System.out.printf("%3s", " ");
		for(int i = 1; i <= 31; i++) {
			System.out.printf("%3d", i);
			if(i % 7 == 6) {
				System.out.println();
			}
		}
	}
}
 