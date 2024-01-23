package com.yedam.classes.abstracts;

//추상클래스
public abstract class Animal {
	//필드
	private String name;
	
	//생성자
	public Animal() {
		
	}
	public Animal(String name) {
		this.name = name;
	}
	
	//메서드
	public void eat() {
		System.out.println("[Animal] 음식을 먹습니다.");
	}
	//추상메서드 - 구현부분x - 자식클래스에서 재정의 필요
	public abstract void sleep();
	
}
