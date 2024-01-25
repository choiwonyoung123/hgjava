package com.yedam.classes.nested;

class Parent{
	String name;
	
	void showName() {
		System.out.println(name);
	}
}

interface Runnable{
	void run(String name); //함수형 인터페이스 - 구현하는 메소드 하나만 존재
}

public class AnonymousExe {
	public static void main(String[] args) {
		//runnable2 = () -> System.out.println("달립니다");
		Runnable runnable1 = new Runnable() { //익명구현객체
			@Override
			public void run(String name) {
				System.out.println(name + "달립니다");
				
			}
		};
		runnable1.run("김길동");
		Runnable runnable = (String name) -> System.out.println(name + "달립니다");
		runnable.run("홍길동");
		
		Parent parent = new Parent() { //익명자식객체
			int age;
			
			void showInfo(String name, int age) {
				this.name = name;
				this.age = age;
				System.out.println(name + age);
			}
			
			@Override
			void showName() {
				showInfo("홍길동", 20);
				//System.out.println(name);
			}
		};
		parent.showName();
		//자식메소드
		//parent.showInfo();
	}
}	
