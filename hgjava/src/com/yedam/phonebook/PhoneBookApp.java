package com.yedam.phonebook;

//연락처 관리, 열거형 타입,
public class PhoneBookApp {
	public static void main(String[] args) {
		PhoneBookManager manager = PhoneBookManager.getInstance();
		UserManager umanager = UserManager.getInstance();
		int menu = 1;
		
		boolean run = true;
		while(run) {					
			System.out.println("<로그인>");
			if(umanager.userCheck()) {
				System.out.println("로그인성공");
				run = false;
			}
			else {
				System.out.println("종료");
			}
			manager.storeToFile();
			break;
		}
		
		while(true) {
			try {						
				MenuViewer.showMenu();
				//값입력
				menu = MenuViewer.keyboard.nextInt();
				//엔터
				MenuViewer.keyboard.nextLine();
				if(menu < InitMenu.INPUT || menu > InitMenu.EXIT) {
					//예외 실행 throw new
					throw new MenuChoiceException(menu);
				}
				
				if(menu == InitMenu.INPUT) {
					manager.inputData();
				}
				else if(menu == InitMenu.SEARCH) {
					manager.searchData();
				}
				else if(menu == InitMenu.DELETE) {
					manager.deleteData();
				}
				else if(menu == InitMenu.EXIT) {
					System.out.println("종료(저장)");
					manager.storeToFile();
					break;
				}
			} catch(MenuChoiceException e) {
				//예외 메소드 호출
				e.showWrongChoice();
			}
		}
		
		System.out.println("end of prog..");
	}
}
