package com.yedam.classes.singleton;

public class Employee {
	//필드
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
	public Employee(int employeeId, String name, int salary, int departmentId) {
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.departmentId = departmentId;
		if(departmentId == 10) {
			departmentName = "인사";
		}
		else if(departmentId == 20) {
			departmentName = "개발";
		}
		else {
			departmentName = "영업";
		}
	}
	public Employee(int employeeId, String name, int salary) {
		this(employeeId, name, salary, 30); //매개변수 없으면 기본값 지정
	}
	
	//메서드
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
