package com.yedam.reference;

public class RefExe1 {
	public static void main(String[] args) {
		//참조타입,참조변수
		
		int n1 = 100;
		int n2 = 100;
		System.out.println(n1 == n2);
		
		String str1 = new String("홍길동");
		String str2 = new String("홍길동");
		//서로 다른 주소값
		System.out.println(str1 == str2);
		//서로 같은 값
		System.out.println(str1.equals(str2));
		
		int[] intAry = new int[10];
		intAry = null;
		//배열의 주소값 출력
		System.out.println(intAry);
		
		
	}
}
