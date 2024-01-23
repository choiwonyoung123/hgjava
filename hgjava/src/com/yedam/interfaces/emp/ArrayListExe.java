package com.yedam.interfaces.emp;

import java.util.ArrayList;

public class ArrayListExe {
	public static void main(String[] args) {
		//배열
		Employee[] employeeAry = new Employee[10];
		//배열에 객체 생성, 인덱스 번호 지정해서 추가
		employeeAry[0] = new Employee(1002, "홍길동");
		employeeAry[1] = new Employee(1003, "김길동");
		Employee emp = new Employee();
		employeeAry[2] = emp;
		employeeAry[2] = null;
		
		for(int i = 0; i < employeeAry.length; i++) {
			if(employeeAry[i] != null) {
				System.out.println(employeeAry[i].getName());
			}
		}
		
		//컬렉션
		ArrayList<Employee> employeeAryList = new ArrayList<Employee>();
		//메소드로 배열에 추가 및 삭제, 자동으로 다음 위치에 추가
		employeeAryList.add(new Employee(103, "최홍길"));
		employeeAryList.add(new Employee(104, "이만기"));
		employeeAryList.add(emp);
		employeeAryList.remove(2);
		
		for(int i = 0; i < employeeAryList.size(); i++) {
			System.out.println(employeeAryList.get(i).getName());
		}
	}
}
