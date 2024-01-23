package com.yedam.interfaces;

//인터페이스 구현하는 클래스
public class MysqlDB implements DAO{
	//기능
	
	@Override
	public void insert() {
		System.out.println("[mysql] 입력");
	}
	public void update() {
		System.out.println("[mysql] 수정");
	}
	public void delete() {
		System.out.println("[mysql] 삭제");
	}
}
