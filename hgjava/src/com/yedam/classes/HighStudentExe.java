package com.yedam.classes;

public class HighStudentExe {
	public static void main(String[] args) {
		//객체 생성
		HighStudent hiStd = new HighStudent("T001", "홍길동", 90, "김쌤");
		//Student 클래스에서 상속받아 getSno()메서드 호출 가능
		System.out.println(hiStd.getSno());
		System.out.println(hiStd.getTeacher());
		hiStd.showInfo();
		System.out.println("--------------------------");
		//부모클래스 참조변수에 자식클래스 인스턴스 대입
		//클래스 타입 형변환 안해도 가능
		//부모클래스 >> 자식클래스 형변환 불필요
		Student std = (Student) new HighStudent("T002", "박길동", 80, "김쌤");
		if(std instanceof HighStudent) {			
			//자식타입을 부모타입으로 형변환
			//자식클래스 >> 부모클래스 형변환 필요
			HighStudent hstd = (HighStudent)std;
			//형변환 통해서 변수 사용가능
			System.out.println(hstd.getTeacher());
		}
		System.out.println("--------------------------");
		Student std1 = new Student("S003", "박석민", 80);
		if(std instanceof HighStudent) {			
			//변수에 할당하는 타입이 부모타입이라서 오류
			HighStudent hstd1 = (HighStudent)std1;
			
			System.out.println(hstd1.getSno());
			System.out.println(hstd1.getTeacher());
		}
		System.out.println("--------------------------");
		Student[] students = new Student[10];
		students[0] = new Student("S001", "홍길동", 90);
		//자식타입이 부모타입으로 자동 형변환
		students[1] = hiStd;
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null){
				students[i].showInfo();
			}
		}
		//작은 타입의 값을 큰 타입의 값으로 형변환 가능
		//자식클래스의 값을 부모클래스의 값으로 대입 가능
		long ln1 = 10;
		int n1 = (int)ln1;
	}
}
