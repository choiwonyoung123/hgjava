package com.yedam.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentApp {
	//초기화 text.dat > 컬렉션에 저장
	//추가 > 컬렉션 추가
	//목록
	//종료 > 컬렉션 파일저장
	
	List<Student> storage = new ArrayList<>();
	
	
	public StudentApp() {
		init();
	}
	//값 읽어서 컬렉션에 추가
	//초기화 - 컬렉션에 저장
	public void init() {
		try {	
			FileReader fr = new FileReader("C:/temp/text.dat");
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				String read = br.readLine(); //한라인씩 읽기, 번호-이름-점수
				if(read == null) {
					break;
				}
				String[] readAry = read.split(" ");
				try {					
					Student std = new Student(Integer.parseInt(readAry[0]), readAry[1], Integer.parseInt(readAry[2]));
					storage.add(std);
				}
				catch (Exception e) {
					
				}
			}
			
			br.close();
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//추가
	public boolean add(Student std) {
		return storage.add(std);
	}
	//목록반환
	public List<Student> list(){
		return storage;
	}
	//종료
	public void save() {
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
