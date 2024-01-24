package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str = "Hello";
		str = new String("Hello");
		//문자열 > 바이트
		byte[] bytes = str.getBytes();
		for(byte b : bytes) {
			System.out.println(b);
		}
		//직접 배열 만들기
		str = new String(new byte[] {72, 101, 108, 108, 111});
		//문자열의 위치 찾기
		int pos = str.indexOf("l");
		System.out.println("l은 " + pos + "번 위치에 있음");
		//특정 위치 문자 찾기
		char chr = str.charAt(0);
		System.out.println(chr);
		
		String lc = str.toLowerCase();
		System.out.println(lc);
		String uc = str.toUpperCase();
		System.out.println(uc);
		
		str = new String("merryChristmas!");
		String subs1 = str.substring(6);
		System.out.println(subs1);
		String subs2 = str.substring(1);
		System.out.println(subs2);
		String subs3 = str.substring(7,12);
		System.out.println(subs3);
		
		System.out.println(str.charAt(7));
		byte[] bytes2 = str.getBytes();
		for(byte b1 : bytes2) {
			System.out.println(b1);
		}
		System.out.println(str.indexOf("me"));
		System.out.println(str.replace("!", "?"));
		System.out.println(str.substring(0,5));
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase().equals(str.toUpperCase()));
		System.out.println(str.toLowerCase().equalsIgnoreCase(str.toUpperCase()));
		
		str = new String(" mouse ");
		System.out.println(str);
		System.out.println(str.trim());
		
		String val = String.valueOf(10.0);
		double val2 = 10.0;
		System.out.println(val2);
		
	}
}
