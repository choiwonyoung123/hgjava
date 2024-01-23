package com.yedam.interfaces;

public class OracleDB implements DAO{
	//기능
	@Override
	public void insert() {
		System.out.println("[oracle] 입력");
	}
	public void update() {
		System.out.println("[oracle] 수정");
	}
	public void delete() {
		System.out.println("[oracle] 삭제");
	}
}
