package com.yedam.collection.emp;

import java.util.Date;

//empNo, empName, hireDate, salary
public class Employee {
	
	
	//필드
	private int empNo;
	private String empName;
	private Date hireDate;
	private int salary;

	
	//생성자
	public Employee(int empNo, String empName, Date hireDate, int salary) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.hireDate = hireDate;
		this.salary = salary;
	}

	
	//메소드
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", hireDate=" + hireDate + ", salary=" + salary
				+ "]";
	}
	
	Date getHireDate() {
		return hireDate;
	}
	
}
