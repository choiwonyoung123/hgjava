package com.yedam.interfaces.emp;

public class Employee {
	private int employeeId; //사번
	private String name; //이름
	private int departmentId; //부서번호
	private String departmentName; //부서명
	private int salary; //급여
	
	//생성자 - 객체 만들면 자동 실행
	public Employee() { //기본생성자
	}
	public Employee(int employeeId, String name) {
		
	}
	public Employee(int employeeId, String name, int salary) {
//		this.(employeeId, name, salary, 30);
	}
	public Employee(int employeeId, String name, int departmentId, String departmentName, int salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.salary = salary;
	}
}
