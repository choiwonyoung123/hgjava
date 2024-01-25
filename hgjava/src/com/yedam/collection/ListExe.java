package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

public class ListExe {
	public static void main(String[] args) {
		//객체 생성
		List<String> names = new ArrayList<>();
		names.add("홍길동");
		System.out.println(names.size()); //컬렉션 크기
		names.add("김민석");
		System.out.println(names.get(1)); //요소 가져오기
		names.add(1, "이민수");
		System.out.println(names);
		names.add(1, "박민우");
		System.out.println(names);
		names.set(1, "김민우");
		System.out.println(names); //요소 바꾸기
		names.remove(1);
		System.out.println(names); //요소 삭제
		//names.clear();
		//System.out.println(names.get(0));
		if(names.size() > 2) {
			//System.out.println(names.get(1));
		}
		for(String name : names) {
			System.out.println(name);
		}
		
		List<Member> members = new ArrayList<>();
		//생성자
		members.add(new Member(1, "홍길동"));
		members.add(new Member(2, "김민석"));
		members.add(new Member(3, "이충희"));
		
		for(int i = 0; i < members.size(); i++) {
			Member member = members.get(i);
			String name = members.get(i).getName();
			int id = members.get(i).getMid();
			System.out.printf("이름:%s 아이디:%d\n", name, id);
			System.out.printf("%s\n", members.get(i).toString());
		}
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getName().equals("김민석")) {
				members.set(i, new Member(4, "김길동"));
				System.out.println(members);
			}
		}
	}
}
