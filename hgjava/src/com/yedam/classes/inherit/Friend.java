package com.yedam.classes.inherit;

import lombok.Data; //getter setter 생성자 등등 정의

//이름, 연락처 >> Friend
//이름, 연락처, 학교, 전공 >> UnivFriend
//이름, 연락처, 회사, 부서 >> CompFriend
// @data + ctrl + space
@Data
public class Friend extends Object {
	//필드
	private String name;
	private String phone;
	
	//오버라이딩 - 재정의 위한 임의의 메서드
	public void changeInfo(String info1, String info2) {
		return;
	}
	@Override
	public String toString() {
		return "이름은 " + name + ", 연락처는 " + phone;
	}
}
