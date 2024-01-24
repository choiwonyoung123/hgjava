package com.yedam.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassExe {
	public static void main(String[] args) throws FileNotFoundException {
		Class cls = String.class;
		String str = "";
		cls = str.getClass();
		try {			
			//cls = Class.forName("java.lang.String");
			cls = Class.forName("com.yedam.api.Member");
		}catch (ClassNotFoundException e) {
			
		}
		//해당클래스 메소드
		Method[] methods = cls.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method.getName());
		}
		//해당클래스 필드
		Field[] fields = cls.getDeclaredFields();
		for(Field Field : fields) {
			System.out.println(Field.getName());
		}
		//경로 정보
		String path = cls.getResource("ObjectExe.class").getPath();
		System.out.println(path);
		
		String path1 = cls.getResource("../HelloWorld.class").getPath();
		System.out.println(path1);
		
		String path2 = cls.getResource("sample.txt").getPath();
		System.out.println(path2);
		Scanner scn = new Scanner(new File(path2));
		System.out.println(scn.nextLine());
	}
}
