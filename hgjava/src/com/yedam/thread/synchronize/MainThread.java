package com.yedam.thread.synchronize;

public class MainThread {
	public static void main(String[] args) {
		//memory 필드를 user1, user2 접근
		Calculator calculator = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
	}
}
