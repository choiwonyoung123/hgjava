package com.yedam.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		names.add("이영표");
		names.add("손흥민");
		names.add("박지성");
		//names.remove("손흥민");
		System.out.println(names.size());
		System.out.println(names);
		
		Iterator<String> iter = names.iterator();
		while(iter.hasNext()) {
			String result = iter.next();
			System.out.println(result);
		}
		
		for(String name : names) {
			System.out.println(name);
		}
		
		int[] numbers = {10, 20, 30, 20};
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < numbers.length; i++) {
			set.add(numbers[i]);
		}
		for(int num : set) {
			System.out.println(num);
		}
	}
}
