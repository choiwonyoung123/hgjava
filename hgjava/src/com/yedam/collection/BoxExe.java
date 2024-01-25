package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

public class BoxExe {
	public static void main(String[] args) {
		//Box box = new Box();
		//타입 지정
		Box<String> box1 = new Box<String>();
		box1.setObj("hong");
		String  result = box1.getObj();
		System.out.println(result);
		
		List<Integer> list = new ArrayList<>();
	}
}
