package com.yedam.collection.emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		List<Employee> storage = new ArrayList<>();
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.조회(입사일자) 9.종료");
			//입력 >> "23-03-01"
			int menu = Integer.parseInt(scn.nextLine());
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			switch(menu) {
			case 1:
				System.out.print("사번-이름-입사일자-급여 입력:");
				String empInfo = scn.nextLine();
				//공백 구분자로 문자열 저장
				String[] empInfoAry = empInfo.split(" ");
				try {
					//컬렉션에 추가
					storage.add(new Employee(Integer.parseInt(empInfoAry[0]), empInfoAry[1], sdf.parse(empInfoAry[2]), Integer.parseInt(empInfoAry[3])));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					//e.printStackTrace();
				}
				System.out.println("등록완료");
				break;
			case 2:
				Date empInfo2 = null;
				while(true) {
					System.out.print("조회할 기준 입사일자 입력:");
					try {
						empInfo2 = sdf.parse(scn.nextLine());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				for(int i = 0; i < storage.size(); i++) {
					Date date = storage.get(i).getHireDate();
					if(storage.get(i).getHireDate().after(empInfo2) || storage.get(i).getHireDate().equals(empInfo2)) {
						System.out.println(storage.get(i).toString());
					}
				}
				break;
			case 9:
				run = false;
				System.out.println("프로그램 종료");
			}
		}
		System.out.println("end of program..");
		
		
	}
	void method() {
		//입력 >> "101 홍길동 23-05-08 100"
		String val = "101 홍길동 23-05-08 100";
		//공백 구분자로 문자열 배열에 담기
		//val.split(" ");
		String[] valAry = val.split(" ");
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		for(String value : valAry) {
			System.out.println(value);
		}		
		try {
			new Employee(Integer.parseInt(valAry[0]), valAry[1], sdf.parse(valAry[2]), Integer.parseInt(valAry[3]));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
