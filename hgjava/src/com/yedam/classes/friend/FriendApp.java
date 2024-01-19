package com.yedam.classes.friend;
//기능관리
//기능 - 등록, 수정, 삭제, 목록, 단건조회
public class FriendApp {
	
	//필드 - 친구정보 배열
	Friend[] friends;
	
	
	//생성자
	public FriendApp() {
		friends = new Friend[10];
	}
	
	
	//메서드
	
	//등록기능
	public boolean add(Friend fri) {
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] == null) {
				friends[i] = fri;
				return true;
			}
		}
		return false;
	}
	//목록기능
	public Friend[] list() {
		return friends;
	}
}
