package com.yedam.impl;

public class Helecopter extends Airplane{
	//재정의 또는 상속받은 것 사용
	@Override
	public void takeOff() {
		System.out.println("[Helecopter] - 이륙");
	}
	@Override
	public void fly() {
		System.out.println("[Helecopter] - 비행");
	}
	@Override
	public void land() {
		System.out.println("[Helecopter] - 착륙");
	}
}
