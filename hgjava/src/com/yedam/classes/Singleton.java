package com.yedam.classes;

//전체프로그램에서 인스턴스 하나만 생성
public class Singleton {
	// 1. 생성자 private 선언
	// 2. 싱글톤 타입의 필드 선언
	// 3. 인스턴스 반환하는 메서드 getInstance()
	
	private static Singleton instance = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return instance;
	}
}
