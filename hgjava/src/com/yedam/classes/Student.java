package com.yedam.classes;
//라이브러리용 클래스
//속성 = 학생번호, 이름, 점수, 키
//기능 = 소개(학생번호, 이름, 점수)
public class Student {
	
	
	
	//필드 정의
	String sno;
	String sname;
	int score;
	double height;
	private boolean onSchool;
	
	
	
	//생성자
	public Student() {
//		this.sno="S001";
	}
	//생성자 매개변수 - 학생번호, 이름 입력
	public Student(String no, String name) {
		sno = no;
		sname = name;
	}
	//생성자 매개변수 - 학생번호, 이름, 점수 입력
	public Student(String no, String name, int score) {
		//this(no, name);
		sno = no;
		sname = name;
		this.score = score;
	}
	//우클릭 - source - generate constructor using fields - 생성자 자동 생성
	public Student(String sno, String sname, int score, double height) {
		super();
		//this(sno, sname, score);
		this.sno = sno;
		this.sname = sname;
		this.score = score;
		this.height = height;
	}
	
	
	
	//메서드
	//필드를 명확히 하기 위해 this. 을 붙이기도 함
	void showInfo() {
		System.out.printf("학생번호는 %s, 이름은 %s, 점수는 %d입니다.\n", sno, sname, score);
	}
	String showInfoStr() {
		return "번호는 " + sno;
	}
	//키 값 설정 메서드
	//키 리턴 메서드
	//private > public
	//우클릭 - source - generator setters and getters
	public void setHeight(double height) {
		if(height < 0) {
			this.height = 160;
		}
		else {
			this.height = height;
		}
	}
	public double getHeight() {
		return this.height;
	}
	
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSname() {
		return this.sname;
	}
	
	
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return this.score;
	}
	
	
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSno() {
		return this.sno;
	}
	
	public boolean isOnSchool() {
		return onSchool;
	}
	public void setOnSchool(boolean onSchool) {
		this.onSchool = onSchool;
	}
	
}
