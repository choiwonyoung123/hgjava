package com.yedam.api;

public class StringTest {
	public static void main(String[] args) {
		//성별
		String[] jumins = {"999999-1234567", "888888-2345678", "7777771234567", "666666 2345678", "000000-1234567", "0000002345678"};
		for(String ssn : jumins) {
			checkGender(ssn);
		}
		
		//2번 길동 몇번?
		String[] names = {"박길동", "홍길동", "박민수", "김민수", "홍민수", "장길동", "길동은"};
		int cnt = 0;
		for(String gd : names) {
			if(gd.substring(1).equals("길동")) {
				cnt++;
			}
		}
		System.out.println("길동은 " + cnt + "번 나왔습니다.");
		
	}
	
	
	
	static void checkGender(String ssn) {
		//입력값, 뒷자리구분
		int leng = ssn.length();
		if(leng == 13) {
			if(ssn.charAt(0) != 0) {				
				if(ssn.substring(6).indexOf("1") == 0) {
					System.out.println("남자");
				}
				else if(ssn.substring(6).indexOf("2") == 0) {
					System.out.println("여자");
				}
			}
			else {
				if(ssn.substring(6).indexOf("3") == 0) {
					System.out.println("남자");
				}
				else if(ssn.substring(6).indexOf("4") == 0) {
					System.out.println("여자");
				}
			}
		}
		else if(leng == 14) {
			if(ssn.charAt(0) != 0) {				
				if(ssn.substring(7).indexOf("1") == 0) {
					System.out.println("남자");
				}
				else if(ssn.substring(7).indexOf("2") == 0) {
					System.out.println("여자");
				}
			}
			else {
				if(ssn.substring(7).indexOf("3") == 0) {
					System.out.println("남자");
				}
				else if(ssn.substring(7).indexOf("4") == 0) {
					System.out.println("여자");
				}
			}
		}
		else {
			System.out.println("주민등록번호가 맞지 않습니다.");
		}
	}
}
