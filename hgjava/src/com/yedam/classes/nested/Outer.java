package com.yedam.classes.nested;

public class Outer {
	//필드
	String field1;
	
	//중첩 클래스
	class NestClass {
		//필드
		String field2;
		
		//메소드
		void method2() {
			System.out.println("method2()");
		}
	}
	//정적멤버 클래스
	static class StaticClass{
		static String field3;
		static void method3() {
			System.out.println("method3()");
			//NestClass nest = new NestClass();
		}
	}

	//메소드
	void method1() {
		NestClass nest = new NestClass();
		nest.field2 = "안녕";
		System.out.println(nest.field2);
		nest.method2();
		
		StaticClass.method3();
	}
}
