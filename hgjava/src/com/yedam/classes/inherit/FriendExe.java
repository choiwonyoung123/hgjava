package com.yedam.classes.inherit;

import java.util.Scanner;

//사용자입력, 처리결과 출력
public class FriendExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		//인스턴스 생성 >> 접근 가능
		FriendApp app = new FriendApp();
		
		while(run) {
			
			System.out.println("메뉴: 1.등록  2.조회  3.수정  4.삭제  9.종료");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			//등록 - 이름, 연락처, (학교, 전공), (회사, 부서)
			case 1: 
				
				System.out.println("1.친구  2.회사  3.학교");
				int subMenu = Integer.parseInt(scn.nextLine());
				
				System.out.print("이름입력:");
				String name = scn.nextLine();
				
				System.out.print("전화번호입력:");
				String phone = scn.nextLine();
				
				//부모클래스타입 변수선언
				Friend friend = null;
				if(subMenu == 1) {
					//부모인스턴스 생성 >> 접근 가능
					friend = new Friend();
					//setter 호출
					friend.setName(name);
					friend.setPhone(phone);
				}
				else if(subMenu == 2) {
					//자식인스턴스 생성 >> 접근 가능
					CompFriend cfriend = new CompFriend();
					//setter 호출
					cfriend.setName(name);
					cfriend.setPhone(phone);
					System.out.print("회사입력:");
					String company = scn.nextLine();
					System.out.print("부서입력:");
					String dept = scn.nextLine();
					//setter 호출
					cfriend.setCompany(company);
					cfriend.setDept(dept);
					//부모타입 변수에 자식타입 변수 할당
					friend = cfriend;
				}
				else if(subMenu == 3) {
					//자식인스턴스 생성 >> 접근 가능
					UnivFriend ufriend = new UnivFriend();
					//setter 호출
					ufriend.setName(name);
					ufriend.setPhone(phone);
					System.out.print("학교입력:");
					String univ = scn.nextLine();
					System.out.print("전공입력:");
					String major = scn.nextLine();
					//setter 호출
					ufriend.setUniv(univ);
					ufriend.setMajor(major);
					//부모타입 변수에 자식타입 변수 할당
					friend = ufriend;
				}
				if(app.add(friend)) {
					System.out.println("정상등록");
				}
				else {
					System.out.println("등록실패");
				}
				break;
			//목록 - 이름
			case 2:
				System.out.print("조회할 이름입력:");
				String fname = scn.nextLine();
				//메서드 실행한 결과를 담을 변수 생성
				Friend[] list = app.list(fname);
				for(int i = 0; i <list.length; i++) {
					if(list[i] != null) {
						//배열 출력
						System.out.println(list[i].toString());
					}
				}
				break;
			//수정
			case 3:
//				friend = new Friend();
				System.out.print("바꿀정보: 1.회사  2.학교");
				int subMenu2 = Integer.parseInt(scn.nextLine());
				if(subMenu2 == 1) {
					System.out.print("바꿀 전화번호 입력");
					String fphone = scn.nextLine();
					System.out.print("바꿀 회사 입력");
					String finfo1 = scn.nextLine();
					System.out.print("바꿀 부서 입력");
					String finfo2 = scn.nextLine();
					if(app.modify(fphone, finfo1, finfo2)) {
						System.out.println("수정완료");
					}
				}
				else if(subMenu2 == 2){
					System.out.print("바꿀 전화번호 입력");
					String fphone = scn.nextLine();
					System.out.print("바꿀 학교 입력");
					String finfo1 = scn.nextLine();
					System.out.print("바꿀 전공 입력");
					String finfo2 = scn.nextLine();
					if(app.modify(fphone, finfo1, finfo2)) {
						System.out.println("수정완료");
					}
				}
				else {
					System.out.println("1과 2 중에서 입력");
				}
				break;
				
			//삭제
			case 4:
			//종료
			case 9:
				System.out.println("종료");
				run = false;
			}
		}
		System.out.println("end of program..");
	}
}
