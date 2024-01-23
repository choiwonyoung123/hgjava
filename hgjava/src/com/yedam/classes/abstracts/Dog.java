package com.yedam.classes.abstracts;

public class Dog extends Animal{
	//추상메서드 사용하려면 재정의 필요
	@Override
	public void sleep() {
		System.out.println("[dog]가 잠을 잡니다.");
	}
}
