package com.yedam.classes.singleton;

import java.util.Scanner;

public class EmployeeList {
	//기능 싱글톤
	
	
	
	//필드
	private static EmployeeList instance = new EmployeeList();
	//사원배열 필드
	Employee[] list;
	Scanner scn = new Scanner(System.in);
	//현재 사원수
	int empNum = 0;
	
	
	
	//생성자
	private EmployeeList() {
		
	}
	
	
	
	//메서드
	public static EmployeeList getInstance() {
		return instance;
	}
	//추가기능
	public void init() {
		System.out.print("사원수입력:");
		int num = Integer.parseInt(scn.nextLine());
		list = new Employee[num];
		//empNum = num;
	}
	//사원정보입력기능
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
	public void print() {
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				
				System.out.printf("%4d %10s %7d\n", list[i].getEmployeeId(), list[i].getName(), list[i].getSalary());
			}
		}
	}
	//사번에 해당하는 이름 출력
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
