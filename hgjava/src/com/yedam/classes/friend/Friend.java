package com.yedam.classes.friend;
//데이터 관리
//친구이름, 연락처, 나이 관리
public class Friend {
	//필드
	String fname;
	String ftel;
	int fage;
	
	
	//생성자
	public Friend() {
		
	}
	public Friend(String name) {
		this.fname = name;
	}
	public Friend(String name, String tel) {
		this.fname = name;
		this.ftel = tel;
	}
	public Friend(String name, String tel, int age) {
		super();
		this.fname = name;
		this.ftel = tel;
		this.fage = age;
	}
	
	
	//메서드
	public void showInfo() {
		System.out.printf("이름:%s  연락처:%s  나이:%d\n", this.fname, this.ftel, this.fage);
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFtel() {
		return ftel;
	}
	public void setFtel(String ftel) {
		this.ftel = ftel;
	}
	public int getFage() {
		return fage;
	}
	public void setFage(int fage) {
		this.fage = fage;
	}
}
