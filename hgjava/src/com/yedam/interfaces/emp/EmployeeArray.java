package com.yedam.interfaces.emp;
//배열
import java.util.Scanner;

import com.yedam.classes.singleton.Employee;

//배열[] - Employee[]
public class EmployeeArray implements EmployeeList{
	//싱글톤
	private static EmployeeArray instance = new EmployeeArray();
	Employee[] list;
	int empNum;
	Scanner scn = new Scanner(System.in);
	private EmployeeArray() {
		
	}
	public static EmployeeArray getInstance() {
		return instance;
	}
	
	@Override
	public void init() {
		System.out.print("사원수입력:");
		int num = Integer.parseInt(scn.nextLine());
		list = new Employee[num];
		empNum = 0;
	}

	@Override
	public void input() {
		if(empNum == list.length) {
			System.out.println("입력초과");
			return;
		}
		System.out.printf("%d 사번입력", empNum);
		int no = scn.nextInt();
		
		System.out.print("이름입력:");
		String name = scn.next();
		
		System.out.print("급여입력:");
		int sal = scn.nextInt();
		//사원추가
		list[empNum++] = new Employee(no, name, sal);
	}

	@Override
	public String search(int empId) {
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				if(list[i].getEmployeeId() == empId) {
					return list[i].getName();
				}
			}
		}
		return "";
	}

	@Override
	public void print() {
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				
				System.out.printf("%4d %10s %7d\n", list[i].getEmployeeId(), list[i].getName(), list[i].getSalary());
			}
		}
	}

	@Override
	public int sum() {
		int result = 0;
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				result += list[i].getSalary();
			}
		}
		return result;
	}
}
