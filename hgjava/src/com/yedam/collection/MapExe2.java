package com.yedam.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExe2 {
	public static void main(String[] args) {
		Map<Member, Integer> map = new HashMap<>();
		map.put(new Member(1, "홍길동"), 900);
		map.put(new Member(2, "박길동"), 1200);
		map.put(new Member(3, "김길동"), 1000);
		map.put(new Member(4, "이길동"), 1400);
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(new Member(1, "홍길동"));
		System.out.println(map.get(new Member(1, "홍길동")));
		System.out.println(map.containsKey(new Member(1, "홍길동")));
		System.out.println(map.containsValue(900));
		
		//포인트 1000점 이상 이름 출력
		Set<Map.Entry<Member, Integer>> entryset = map.entrySet();
		Iterator<Map.Entry<Member, Integer>> entryiter = entryset.iterator();
		while(entryiter.hasNext()) {
			Map.Entry<Member, Integer> entry = entryiter.next();
			if(entry.getValue() > 1000) {
				System.out.println(entry.getKey().getName());
			}
		}
	}
}
