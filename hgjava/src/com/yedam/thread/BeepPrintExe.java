package com.yedam.thread;

import java.awt.Toolkit;

//소리출력, 문자출력
//싱글스레드
public class BeepPrintExe {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
//		for(int i = 0; i < 5; i++) {
//			toolkit.beep();
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		//Thread thread = new Thread(new BeepTask());
		Thread thread = new BeepThread();
		//새로운 스레드실행 start호출 > run실행
		thread.start();
		
		//메인 스레드실행
		for(int i = 0; i < 5; i++) {
			System.out.println("print");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
