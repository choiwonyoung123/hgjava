package com.yedam.classes;
//실행용 클래스
public class StudentExe {
	public static void main(String[] args) {
		
		
		
		//생성자로 인스턴스 객체 생성
//		Student s1 = new Student();
		
		//필드값 초기화
//		s1.sno = "S001";
//		s1.sname = "홍길동";
//		s1.score = 80;
//		s1.height = 178.9;
		
		//필드값 출력
		//System.out.println(s1.sno);
		
		//생성자 호출
		Student s1 = new Student("S001", "홍길동", 80, 178.9);
		
		//메서드 호출
		s1.showInfo();
		
		//메서드 호출
		s1.setHeight(-100);
		System.out.println(s1.getHeight());
		
		
		
		//생성자 호출
		Student s2 = new Student("S002", "김길동");
		//점수필드 초기화
		s2.score = 85;
		//메서드 호출
		s2.showInfo();
		
		
		
		//생성자 호출
		Student s3 = new Student("S003", "박길동", 90);
		//메서드 호출
		s3.showInfo();
		
		
		
	}
}
