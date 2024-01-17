package com.yedam.todo;

import java.util.Scanner;

public class Todo0117 {
	public static void main(String[] args) {
		String[] name = new String[3];
		String[] tel = new String[3];
		
		Scanner scn = new Scanner(System.in);
		for(int i = 0; i < 3; i++) {
			System.out.println("이름을 입력 >> ");
			name[i] = scn.nextLine();
			System.out.println("연락처를 입력 >> ");
			tel[i] = scn.nextLine();
		}
	}
}
