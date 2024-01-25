package com.yedam.collection;

import java.util.Stack;

public class StackExe {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("홍길동");
		stack.push("박길동");
		stack.push("김길동");
		stack.push("이길동");
		stack.pop();
		while(!stack.isEmpty()) {
			String result = stack.pop();
			System.out.println(result);
		}
	}
}
