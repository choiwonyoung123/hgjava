package com.yedam.phonebook;

//사용자메뉴가 비정상적으로 처리될때
public class MenuChoiceException extends Exception{
	
	//필드
	int wrongChoice;
	
	//생성자
	public MenuChoiceException(int wrongChoice) {
		//메시지 초기화, getMessage()로 호출
		super("없는 메뉴번호입니다.");
		this.wrongChoice = wrongChoice;
	}
	
	//메소드
	public void showWrongChoice() {
		System.out.println(wrongChoice + "는 없는 메뉴번호입니다.");
	}
}
