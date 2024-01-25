package com.yedam.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExe {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "홍길동");
		map.put(2, "김길동");
		map.put(3, "박길동");
		map.put(4, "박길동");
		System.out.println(map);
		System.out.println(map.size());
		
		//set 객체로 담아서 리턴
		Set<Integer> keyset = map.keySet();
		//반복자
		Iterator<Integer> iter = keyset.iterator();
		while(iter.hasNext()) {
			Integer key = iter.next();
			//키에 해당하는 값 반환
			String val = map.get(key);
			System.out.println(val);
		}
		
		
		Set<Entry<Integer, String>> entry = map.entrySet();
		Iterator<Entry<Integer, String>> eiter = entry.iterator();
		while(eiter.hasNext()) {
			Entry<Integer, String> ent = eiter.next();
			System.out.println(ent);
			System.out.println(ent.getKey());
			System.out.println(ent.getValue());
		}
	} 
}
