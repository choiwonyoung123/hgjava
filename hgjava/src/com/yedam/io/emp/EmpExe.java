package com.yedam.io.emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class EmpExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		EmpApp app = new EmpApp();
		
		while(run) {
			System.out.println("1.등록 2.목록 9.종료");
			System.out.print("선택:");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			//등록
			case 1:
				System.out.print("<사원번호 사원이름 입사일자 급여> 입력:");
				String stdInfo = scn.nextLine();
				String[] stdInfoAry = stdInfo.split(" ");
				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
				Employee emp = null;
				try {
					emp = new Employee(Integer.parseInt(stdInfoAry[0]), stdInfoAry[1], sdf.parse(stdInfoAry[2]),Integer.parseInt(stdInfoAry[3]));
				} catch (Exception e) {
					System.out.println("날짜포맷 오류");
				}
				if(app.add(emp)){
					System.out.println("등록완료");
				}
				else {
					System.out.println("등록실패");
				}
				break;
			//목록
			case 2:
				List<Employee> list = app.list();
				for(Employee emp1 : list) {
					System.out.println(emp1.toString());
				}
				break;
			//종료
			case 9:
				System.out.println("프로그램 종료..");
				app.save();
				run = false;
			}
		}
		System.out.println("end of program...");
	}
}
