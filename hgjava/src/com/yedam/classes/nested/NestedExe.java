package com.yedam.classes.nested;

import java.util.Map;

public class NestedExe {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.method1();
		
		//인스턴스 생성, 중첩 클래스
		Outer.NestClass nest = outer.new NestClass();
		
		
		nest.field2 = "반갑습니다";
		System.out.println(nest.field2);
		nest.method2();
		
		Map.Entry<String, Integer> entry;
	}
}
