package com.yedam.classes;

public class StudentApp {
	
	
	//배열 생성
	static Student[] students;
	
	
	//생성자 정의
	public StudentApp() {
		//배열 선언
		students = new Student[10];
	}
	
	
	//메서드 정의
	//등록 기능
	public static boolean add(Student std) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = std;
				return true;
			}
		}
		return false;
	}
	
	//목록 기능
	public static Student[] list() {
		return students; //여러건 리턴
	}
	
	//수정 기능 - 학생번호 입력받아 점수 바꾸기
	public static boolean modify(String sno, int score) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getSno().equals(sno)) {
				students[i].setScore(score);
				return true;
			}
		}
		return false;
	}
	
	//삭제 기능(학생번호)
	public static boolean remove(String sno) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getSno().equals(sno)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}
	
	//조회 기능(학생번호)
	public static Student get(String sno) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getSno().equals(sno)) {
				return students[i]; //한건 리턴
			}
		}
		return null;
	}
}
