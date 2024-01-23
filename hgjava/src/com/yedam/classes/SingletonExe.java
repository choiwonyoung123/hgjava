package com.yedam.classes;

public class SingletonExe {
	public static void main(String[] args) {
		//싱글톤은 new로 객체를 생성할수 없음
		//Singleton s1 = new Singleton();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		//인스턴스 객체의 주소값 동일
		System.out.println(s2 == s3);
	}
}
