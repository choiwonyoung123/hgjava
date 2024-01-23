package com.yedam.classes;

//담임선생님
public class HighStudent extends Student{
	private String teacher;
	//생성자
	public HighStudent(String sno, String name) {
		//부모생성자 호출
		super(sno, name);
	}
	public HighStudent(String sno, String name, int score, String teacher) {
		super(sno, name, score);
		this.teacher = teacher;
	}
	//getter setter
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	//부모메서드 재정의 - 오버라이딩
	public void showInfo() {
		//자식클래스 teacher 추가
		System.out.printf("학생번호는 %s, 이름은 %s, 점수는 %d, 선생님은 %s입니다.\n", this.getSno(), this.getSname(), this.getScore(), this.teacher);
	}
}
