package com.yedam.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		StudentApp app = new StudentApp();
		
		while(run) {
			System.out.println("1.등록 2.목록 9.종료");
			System.out.print("선택:");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			//등록
			case 1:
				System.out.print("<번호 이름 점수> 입력:");
				String stdInfo = scn.nextLine();
				String[] stdInfoAry = stdInfo.split(" ");
				Student std = new Student(Integer.parseInt(stdInfoAry[0]), stdInfoAry[1], Integer.parseInt(stdInfoAry[2]));
				app.add(std);
				break;
			//목록
			case 2:
				List<Student> list = app.list();
				for(Student std1 : list) {
					System.out.println(std1.toString());
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
	}//end of main
	static void read() {
		List<Student> storage = new ArrayList<>();
		//storage.add(new Student(201, "유길동", 80));
		//storage.add(new Student(202, "이길동", 81));
		//storage.add(new Student(203, "김길동", 82));
		//storage.add(new Student(204, "박길동", 83));
		try {
			FileReader fr = new FileReader("C:/temp/text.dat");
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String read = br.readLine(); //한라인씩 읽기, 번호-이름-점수
				if(read == null) {
					break;
				}
				String[] readAry = read.split(" ");
				Student std = new Student(Integer.parseInt(readAry[0]), readAry[1], Integer.parseInt(readAry[2]));
				storage.add(std);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//컬렉션정보 출력
		for(Student std : storage) {
			System.out.println(std.toString());
		}
	}
	static void write() {
		//text.dat파일 읽기 > student컬렉션 저장
				List<Student> storage = new ArrayList<>();
				//storage.add(new Student(201, "유길동", 80));
				//storage.add(new Student(202, "이길동", 81));
				//storage.add(new Student(203, "김길동", 82));
				//storage.add(new Student(204, "박길동", 83));
				//컬렉션정보 출력
				try {
					FileWriter fw = new FileWriter("C:/temp/text.dat");
					BufferedWriter bw = new BufferedWriter(fw);
					for(Student std : storage) {
						String str = std.getSno() +  " " + std.getSname() + " " + std.getScore();
						bw.write(str + "\n");
					}
					bw.flush();
					fw.flush();
					bw.close();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}
