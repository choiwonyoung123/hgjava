package com.yedam.classes;

import java.util.Scanner;

public class MainExe {
	//스캐너 선언
	static Scanner scn = new Scanner(System.in);
	//정적변수 선언,초기화
	static String sno = "", sname = "";
	static int score = 0;
	static double height = 0;
	//StudentApp 인스턴스 생성
	static StudentApp app = new StudentApp();
	
	//등록
	public static void insert() {
		System.out.println("학생번호:");
		sno = scn.nextLine();
		System.out.println("학생이름:");
		sname = scn.nextLine();
		System.out.println("학생점수:");
		score = Integer.parseInt(scn.nextLine());
		System.out.println("학생키:");
		height = Double.parseDouble(scn.nextLine());
		
		//Student 인스턴스 생성, 매개변수 지정
		Student std = new Student(sno, sname, score, height);
		//메서드 호출 >> 등록기능 메서드의 리턴 값이 참이면
		if(StudentApp.add(std)) {
			System.out.println("입력 성공");
		}
		else {
			System.out.println("입력 실패");
		}
	}
	//목록
	public static void list() {
		//Student 타입의 변수 선언, 목록기능 메서드 호출
		Student[] list = StudentApp.list();
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				//메서드 호출 >> 목록기능의 리턴 값인 배열을 받아서 출력
				list[i].showInfo();
			}
		}
		System.out.println("조회완료");
	}
	//수정
	public static void update() {
		System.out.println("바꿀 학생번호:");
		sno = scn.nextLine();
		while(true) {					
			System.out.println("바꿀 학생점수:");
			score = Integer.parseInt(scn.nextLine());
			if(score < 0) {
				System.out.println("바꿀 학생점수는 0보다 커야 합니다.");
				continue;
			}
			break;
		}
		//메서드 호출 >> 수정기능의 리턴 값이 참이면 
		if(StudentApp.modify(sno, score)) {
			System.out.println("수정완료");
		}
		else {
			System.out.println("잘못된 학생번호입니다.");
		}
	}
	//삭제
	public static void delete() {
		System.out.println("삭제할 학생번호:");
		sno = scn.nextLine();
		//메서드 호출 >> 삭제기능의 리턴 값이 참이면
		if(StudentApp.remove(sno)) {
			System.out.println("삭제완료");
		}
		else {
			System.out.println("잘못된 학생번호입니다.");
		}
	}
	//조회
	public static void search() {
		System.out.println("조회할 학생번호:");
		sno = scn.nextLine();
		//메서드 호출 >> 조회기능의 리턴 값이 널이면
		if(StudentApp.get(sno) == null) {
			System.out.println("잘못된 학생번호입니다.");
		}
		else {
			//Student 타입의 onelist 변수 선언, 조회기능의 리턴 값 할당
			Student onelist = StudentApp.get(sno);
			if(onelist != null) {
				//onelist 값을 출력
				onelist.showInfo();
			}
			else {
				System.out.println("조회한 학생정보가 없습니다.");
			}
		}
	}
	
	//메인
	public static void main(String[] args) {
		//인스턴스 생성
//		static StudentApp app = new StudentApp();
		//반복문
		boolean run = true;
		while(run) {
			System.out.println("1.등록  2.목록  3.수정  4.삭제  5.조회  6.분석  9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			//등록하기
			case 1:
				insert();
				break;
			//목록출력
			case 2:
				list();
				break;
			//수정하기	
			case 3:
				update();
				break;
			//삭제하기
			case 4:
				delete();
				break;
			//조회하기
			case 5:
				search();
				break;
			//종료하기
			case 9:
				run = false;
				System.out.println("종료합니다..");
			}
		}
		System.out.println("END OF PROGRAM..");
	}
}
