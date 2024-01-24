package com.yedam.api;

import java.util.ArrayList;
import java.util.List;

public class WrapperExe {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		//List<int> linst;
		list.add(new Integer(1));
		list.add(1);
		Double d1 = Double.valueOf("2.3");
		
		System.out.println(Math.abs(-10));
		System.out.println(Math.round(5.3));
	}
}
