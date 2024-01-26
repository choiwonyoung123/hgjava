package com.yedam.thread.synchronize;


//user1, user2 작업공간
public class Calculator {
	
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	public synchronized void setMemory(int memory) {
		//현재스레드 이름 출력
		System.out.println(Thread.currentThread().getName());
		this.memory = memory;
		//스레드 출력 간격
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " > " + this.memory);
	}
}
