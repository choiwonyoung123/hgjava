package com.yedam.classes.abstracts;

public class AnimalExe {
	public static void main(String[] args) {
		//Animal animal = new Animal();
		//추상클래스 Animal 선언 - 자식클래스 모두 사용 가능
		Animal animal = null;
		animal = new Bird("제비");
		animal.eat();
		animal.sleep();
		
		Bird bird = new Bird("참새");
		bird.eat();
		bird.sleep();
		//추상클래스 Animal 배열 선언 - 자식클래스 모두 사용 가능
		Animal[] animals = new Animal[10];
	}
}
