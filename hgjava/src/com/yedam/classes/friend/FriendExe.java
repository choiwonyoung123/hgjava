package com.yedam.classes.friend;

import java.util.Scanner;

public class FriendExe {
	public static void main(String[] args) {
		//메뉴 출력, 실행
		//메뉴: 1.등록, 2.목록, 3.수정, 4.삭제, 9.종료
		//사용자입력, 처리결과 출력
		Scanner scn = new Scanner(System.in);
		//배열 생성자 객체 생성
		FriendApp app = new FriendApp();
		UserApp uapp = new UserApp();
		
		while(true) {			
			System.out.println("아이디입력>>");
			String id = scn.nextLine();
			System.out.println("비밀번호입력>>");
			String pw = scn.nextLine();
			User user = uapp.login(id, pw);
			if(user != null) {
				System.out.printf("%s님 로그인 성공\n", user.getName());
				break;
			}
			System.out.println("아이디와 비밀번호를 다시 입력하세요.");
		}
		
		boolean run = true;
		
		String name = "";
		String tel = "";
		int age = 0;
		
		while(run) {
			System.out.println("메뉴: 1.등록  2.목록  3.수정  4.삭제  9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			//등록
			case 1:
				System.out.println("이름입력>>");
				name = scn.nextLine();
				System.out.println("연락처입력>>");
				tel = scn.nextLine();
				System.out.println("나이입력>>");
				age = Integer.parseInt(scn.nextLine());
				Friend fri = new Friend(name, tel, age);
				if(app.add(fri)) {
					System.out.println("입력완료");
				}
				else {
					System.out.println("입력실패");
				}
				break;
			//목록
			case 2:
				Friend[] list = app.list();
				for(int i = 0; i < list.length; i++) {
					if(list[i] != null) {						
						list[i].showInfo();
					}
				}
				System.out.println("목록확인");
				break;
			case 3:
			case 4:
			case 9:
			}
		}
		System.out.println("end of program..");
	}
}
