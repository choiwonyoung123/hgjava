package com.yedam.thread;


class PrintThread2 extends Thread{
	@Override
	public void run() {
		while(true) {
			System.out.println("실행중..");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				break; //스레드 종료 위한 코드 작성
			}
		}
		System.out.println("실행종료..");
	}
}
//////////////////////////////////////////////////////////////////////
public class InterruptExe {
	public static void main(String[] args) {
		PrintThread2 thread = new PrintThread2();
		thread.start();
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
		//예외 발생
		thread.interrupt();
	}
}
