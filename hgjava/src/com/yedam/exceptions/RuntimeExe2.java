package com.yedam.exceptions;

public class RuntimeExe2 {
	public static void main(String[] args) {
		//실행예외
		String str = "10";
		str = null;
		//두가지 한번에 예외처리
		//catch (Exception e) 상위 클래스, 예외처리 중에서 가장 아래에 작성
		try {
			str = "ten";
			System.out.println(str.toString()); //널포인트 예외
			int num = Integer.parseInt(str); //넘버포맷 예외
		}catch(NullPointerException ne1) {
			//ne1.printStackTrace();
			System.out.println("참조값 없음");
		}catch(NumberFormatException ne2) {
			//ne2.printStackTrace();
			System.out.println("숫자값 아님");
		}catch(Exception e) {
			System.out.println("알수없는 예외");
		}
		System.out.println("end of program..");
	}
}
