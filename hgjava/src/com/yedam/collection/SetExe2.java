package com.yedam.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe2 {
	public static void main(String[] args) {
		Set<Member> members = new HashSet<>();
		members.add(new Member(1, "홍길동"));
		members.add(new Member(2, "김길동"));
		members.add(new Member(3, "박길동"));
		members.add(new Member(3, "박길동"));
		members.remove(new Member(2, "김길동"));
		System.out.println(members);
		System.out.println(members.size());
		//반복된 요소 골라냄, 선택
		Iterator<Member> iter = members.iterator();
		while(iter.hasNext()) {
			Member member = iter.next();
			System.out.println(member);
		}
	}
}
