package com.yedam.exceptions;

public class RuntimeExe {
	public static void main(String[] args) {
		//일반예외
		try {
			Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//실행예외
		String str = "ten";
		try {			
			int num = Integer.parseInt(str);
			System.out.println(num);
		}catch (NumberFormatException e) {
			System.out.println("숫자로 변경불가");
		}
		String str1 = null;
		try {			
			System.out.println(str1.toString());
		}catch (NullPointerException e) {
			System.out.println("참조값 없음");
			str1 = "10";
		}
		
		System.out.println("end of program..");
	}
}
