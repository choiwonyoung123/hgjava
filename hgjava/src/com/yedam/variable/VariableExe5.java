package com.yedam.variable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class VariableExe5 {
	public static void main(String[] args) throws FileNotFoundException {
		//표준입출력
		InputStream is = new FileInputStream("test.txt");
		Scanner scn = new Scanner(is); //텍스트 파일 읽기
		String name = scn.nextLine(); // next > 한 라인씩 읽기, 문서 내에서 계속 다음줄 잇기
		int age = scn.nextInt();
		double height = scn.nextDouble();
		System.out.println("이름은 " + name + ", 나이는 " + age + "세, 키는 " + height + "입니다.");
		scn.close();
		
		System.out.printf("이름은 %s, 나이는 %d세, 키는 %.1f입니다.", name, age, height);
		
		String str = "이름은 %s, 나이는 %d세, 키는 %.1f입니다.";
		System.out.print("\n");
		System.out.printf(str, name, age, height);
	}
}
