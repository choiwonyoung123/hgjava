package com.yedam.impl;

public class FlyerExe {
	public static void main(String[] args) {
		//비행기 객체
		Flyer flyer = new Airplane();
		flyer.takeOff();
		//헬리콥터 객체
		flyer = new Helecopter();
		flyer.takeOff();
		//해양비행기 객체
		flyer = new Seaplane();
		//드라이버객체
		Driver driver = new Driver();
		driver.drive(flyer);
	}
}
