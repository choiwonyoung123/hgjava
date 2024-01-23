package com.yedam.interfaces.emp;
//컬렉션
import java.util.ArrayList;
import java.util.Scanner;

import com.yedam.classes.singleton.Employee;

//ArrayList<Employee> - 컬렉션
public class EmployeeArrayList implements EmployeeList{

	private static EmployeeArrayList instance = new EmployeeArrayList();
	ArrayList<Employee> list;
	Scanner scn = new Scanner(System.in);
	
	
	private EmployeeArrayList() {
		
	}
	public static EmployeeArrayList getInstance() {
		return instance;
	}
	
	@Override
	public void init() {
		list = new ArrayList<Employee>();
		System.out.println("초기화완료");
	}

	@Override
	public void input() {
		System.out.printf("%d 사번입력", list.size());
		int no = scn.nextInt();
		
		System.out.print("이름입력:");
		String name = scn.next();
		
		System.out.print("급여입력:");
		int sal = scn.nextInt();
		
		list.add(new Employee(no, name, sal));
	}

	@Override
	public String search(int empId) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getEmployeeId() == empId) {
				return list.get(i).getName();
			}
		}
		return "";
	}

	@Override
	public void print() {
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("%4d %10s %7d\n", list.get(i).getEmployeeId(), list.get(i).getName(), list.get(i).getSalary());
		}
	}

	@Override
	public int sum() {
		int result = 0;
		for(int i = 0; i < list.size(); i++) {
			result += list.get(i).getSalary();
		}
		return result;
	}
	
}
