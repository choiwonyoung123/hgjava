package com.yedam.classes.abstracts;

public class Bird extends Animal{
	 
	public Bird(String name) {
		super(name);
	}
	//추상메서드 사용하려면 재정의 필요
	@Override
	public void sleep() {
		System.out.println("[bird]가 잠을 잡니다.");
	}
}
