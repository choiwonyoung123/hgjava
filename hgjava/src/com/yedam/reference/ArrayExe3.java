package com.yedam.reference;

import java.util.Scanner;

public class ArrayExe3 {
	public static void main(String[] args) {
		//=====친구찾기=====
		//Friend 클래스 초기화
		//클래스 활용해서 데이터를 가지는 객체 생성
		Friend f1 = new Friend();
		f1.name = "홍길동";
		f1.weight = 67.8;
		f1.score = 80;
		Friend f2 = new Friend();
		f2.name = "김길동";
		f2.weight = 77.8;
		f2.score = 86;
		Friend f3 = new Friend();
		f3.name = "김민석";
		f3.weight = 79.8;
		f3.score = 88;
		//새로 생성
		String name = "김말숙";
		double weight = 55.5;
		int score = 88;
		Friend f4 = new Friend();
		f4.name = name;
		f4.weight = weight;
		f4.score = score;
		
		//friends 배열 생성
		Friend[] friends = {f1, f2, f3};
		//friends 배열 값 초기화, 길이 재설정
		friends = new Friend[5];
		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;
		friends[3] = f4;
		
		Scanner scn = new Scanner(System.in);
		System.out.println("찾을 친구 >>> ");
		String fname = scn.nextLine();
		System.out.println("바꿀 점수 >>> ");
		int fscore = scn.nextInt();
		
		for(int i = 0; i < friends.length; i++) {
			//배열의 name 속성의 값 비교
			if(friends[i] != null && friends[i].name.equals(fname)) {
				//배열의 weight, score 속성 값 찾기p
				friends[i].score = fscore;
			}
		}
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] != null) {
				System.out.printf("%s의 몸무게는 %.1f, 점수는 %d\n", friends[i].name, friends[i].weight, friends[i].score);				
			}
		}
	}
}
