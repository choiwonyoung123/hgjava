package com.yedam.classes.inherit;

//친구정보 저장, 조회, 수정, 삭제
public class FriendApp {
	//배열 필드 생성
	private Friend[] friends;
	
	//생성자
	public FriendApp() {
		friends = new Friend[10];
	}
	
	//메서드 - CRUD
	//반환타입, 메소드명, 매개변수, 함수내용
	//등록
	public boolean add(Friend fnd) { //매개변수로 friend 타입
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] == null) {
				friends[i] = fnd;
				return true;
			}
		}
		return false;
	}
	//조회 - 이름
	private int idx = 0;
	public Friend[] list(String name) { //반환타입이 여러 값이어서 배열로 선언
		Friend[] list = new Friend[10]; //값을 담을 배열 생성
		for(int i = 0; i < friends.length; i++) {			
			if(friends[i] != null) {
				//입력값이 배열에 있으면 해당 배열 리턴
				if(friends[i].getName().equals(name) || name.equals("")) {
					list[idx++] = friends[i];
				}
				//입력값이 공백이면 모든 배열 리턴
//				if(name.equals("")) {
//					list[i] = friends[i];
//				}
			}
		}
		return list;
	}
	//단건조회 - 전화번호
	public Friend getFriend(String phone) { //반환타입이 한 개라서 클래스 타입으로 선언
		for(int i = 0; i < friends.length; i++) {			
			if(friends[i] != null) {
				if(friends[i].getPhone().equals(phone)) {
					return friends[i];
				}
			}
		}
		return null;
	}
	//수정 - 전화번호, 회사 > 회사와 부서, 학교 > 학교와 전공
	public boolean modify(String phone, String info1, String info2) {
		for(int i = 0; i < friends.length; i++) {			
			if(friends[i] != null) {
				if(friends[i].getPhone().equals(phone)) {
					friends[i].changeInfo(info1, info2);
					return true;
				}
			}
		}
		return false;
	}
	//삭제 - 전화번호
	public boolean remove(String phone) {
		for(int i = 0; i < friends.length; i++) {			
			if(friends[i] != null) {
				if(friends[i].getPhone().equals(phone)) {
					friends[i] = null;
					return true;
				}
			}
		}
		return false;
	}
}
