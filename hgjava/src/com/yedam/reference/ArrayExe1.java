package com.yedam.reference;

public class ArrayExe1 {
	public static void main(String[] args) {
		//선언
		int[] intAry = {10, 20, 30}; //각 요소는 int 타입
//		int intAry[] = {10, 20, 30};
		int[][] intArray = {{10, 20}, {30, 40},{50, 60}}; //배열안에 또 배열, 각 요소는 int 타입
//		int intArray[][] = {{10, 20}, {30, 40},{50, 60}};
		
		String[] strAry = new String[5];
//		String strAry[] = new String[5];
		strAry = new String[] {"hello", "world", "nice"};
		for(String elem : strAry) { //for 반복문 예시
			System.out.println(elem);
		}
	}
}
