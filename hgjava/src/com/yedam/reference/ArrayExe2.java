package com.yedam.reference;

import java.util.Scanner;

public class ArrayExe2 {
	public static void main(String[] args) {
		//친구찾기
//		Scanner scn = new Scanner(System.in);
//		System.out.println("친구입력>>>");
//		String input = scn.nextLine();
		//자료
		String[] friends = {"홍길동", "김민수", "박석민", "최홍만", "김길동"};
		double[] dblAry = {67.3, 72.5, 88.3, 79.3, 90.4};
		int[] scores = new int[5];
		scores[0] = 78;
		scores[1] = 82;
		scores[2] = 95;
		scores[3] = 90;
		scores[4] = 91;
		//계산
		int max = 0;
		String name = "";
		double weight = 0;
		for(int i = 0; i < scores.length; i++) {
			if(max < scores[i]) {
				name = friends[i];
				weight = dblAry[i];
				max = scores[i];
			}
		}
		System.out.printf("최고 점수인 사람의 이름:%s, 몸무게:%.1f", name, weight);
	}
	public static void method1() {
		int[] scores = new int[10];		
		scores[3] = 40;
		scores[5] = 60;
		scores = new int[5];		
		scores[0] = 78;
		scores[1] = 82;
		scores[2] = 77;
		scores[3] = 90;
		scores[4] = 85;
//		for(int i = 0; i < scores.length; i++) {
//			System.out.println("scores[" + i + "]=> " + scores[i]);
//		}
		int cnt = 0;
		for(int i = 0; i < scores.length; i++) {
//			if(scores[i] > 80) {
//				System.out.println("첫 번째 80이상 값은 " + scores[i] + "입니다.");
//				break;
//			}
			if(scores[i] >= 80) {
				cnt++;
			}
		}
		System.out.println("80점 이상인 학생은 " + cnt + "명 입니다.");
	}
	public static void method2(){
		
//		double avg = 0;
//		double sum = 0;
//		for(int i = 0; i < dblAry.length; i++) {
//			sum += dblAry[i];
//		}
//		avg = sum / dblAry.length;
//		System.out.println("친구들의 평균 몸무게는 " + Math.floor(avg) + "입니다.");
//	    System.out.printf("친구들의 평균 몸무게는 %.1f입니다.", avg);
		
		//최대값
		double[] dblAry = {67.3, 72.5, 88.3, 79.3, 90.4};
		double max = 0;
		for(int i = 1; i < dblAry.length; i++) {
	        if(max < dblAry[i]) {
			    max = dblAry[i];
		    }
		}
		System.out.println("배열 중에서 최대값은 " + max + "입니다.");
	}
	public static void method3() {
		//친구찾기
				Scanner scn = new Scanner(System.in);
				System.out.println("친구입력>>>");
				String name = scn.nextLine();
				//자료
				String[] friends = {"홍길동", "김민수", "박석민", "최홍만", "김길동"};
				//계산
				boolean isExist = false;
				for(int i = 0; i < friends.length; i++) {
					if(name.equals(friends[i])) {
						System.out.println(name + "은(는) " + (i+1) + "번째에 있습니다.");
						isExist = true;
					}
				}
				if(isExist == false) {
					System.out.println("찾는 친구가 없습니다.");
				}
	}
	public static void method4() {
		//친구 요소찾기
		Scanner scn = new Scanner(System.in);
		System.out.println("친구입력>>>");
		String name = scn.nextLine();
		//자료
		String[] friends = {"홍길동", "김민수", "박석민", "최홍만", "김길동"};
		double[] dblAry = {67.3, 72.5, 88.3, 79.3, 90.4};
		int[] scores = new int[5];
		scores[0] = 78;
		scores[1] = 82;
		scores[2] = 95;
		scores[3] = 90;
		scores[4] = 91;
		//계산
		boolean isExist = false;
		for(int i = 0; i < friends.length; i++) {
			if(name.equals(friends[i])) {
				System.out.printf("%d번째 %s은(는) 몸무게가 %.1f이고 점수는 %d점입니다.", i, friends[i], dblAry[i], scores[i]);
				isExist = true;
			}
		}
		if(isExist == false) {
			System.out.println("찾는 친구가 없습니다.");
		}
	}
}
