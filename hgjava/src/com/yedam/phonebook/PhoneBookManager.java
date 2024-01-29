package com.yedam.phonebook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 생성자초기화 - 기능 - 등록, 검색, 삭제, 종료(파일저장)
public class PhoneBookManager {
	//파일 객체 생성
	private File dataFile = new File("C:/temp/phonebook.dat");
	HashSet<PhoneInfo> storage = new HashSet<>();
	
	//싱글톤
	private static PhoneBookManager instance;
	//private static PhoneBookManager instance new PhoneBookManager();
	
	//생성자
	//생성자 호출시 파일 호출해서 데이터 초기화
	private PhoneBookManager() {
		readFromFile();
		
	}
	public static PhoneBookManager getInstance() {
		if(instance == null) {
			//새로운 인스턴스 객체 생성
			instance = new PhoneBookManager();
		}
		return instance;
	}
	
	
	
	
	//일반친구 메소드
	private PhoneInfo getFriendInfo() {
		System.out.print("이름입력:");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("연락처입력:");
		String phone = MenuViewer.keyboard.nextLine();
		return new PhoneInfo(name, phone);
	}
	//회사친구 메소드
	private PhoneInfo getCompanyFriendInfo() {
		System.out.print("이름입력:");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("연락처입력:");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("회사입력:");
		String company = MenuViewer.keyboard.nextLine();
		return new PhoneCompanyInfo(name, phone, company);
	}
	//학교친구 메소드
	private PhoneInfo getUnivFriendInfo() {
		System.out.print("이름입력:");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("연락처입력:");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("전공입력:");
		String major = MenuViewer.keyboard.nextLine();
		System.out.print("학년입력:");
		int year = MenuViewer.keyboard.nextInt();
		return new PhoneUnivInfo(name, phone, major, year);
	}
	//추가기능
	public void inputData() {
		System.out.println("=======구분=======");
		System.out.println("1.일반 2.회사 3.학교");
		System.out.print("친구유형 선택:");
		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		PhoneInfo info = null;
		switch(choice) {
		case InputSelect.NORMAL:
			info = getFriendInfo();
			break;
		case InputSelect.COMPANY:
			info = getCompanyFriendInfo();
			break;
		case InputSelect.UNIV:
			info = getUnivFriendInfo();
		}
		if(storage.add(info)) {
			System.out.println("등록완료");
		}
		else {
			System.out.println("등록실패");
		}
	}
	
	
	
	//삭제기능
	public void deleteData() {
		System.out.print("삭제할 이름입력:");
		//값입력 - 엔터
		String input = MenuViewer.keyboard.nextLine();
		Iterator<PhoneInfo> iter = storage.iterator();
		while(iter.hasNext()) {
			PhoneInfo str = iter.next();
			if(str.getName().equals(input)) {				
				iter.remove();
				System.out.println("삭제완료");
			}
		}
	}
	
	
	//검색기능
	public void searchData() {
		System.out.print("검색할 이름입력:");
		//값입력 - 엔터
		String input = MenuViewer.keyboard.nextLine();
		Iterator<PhoneInfo> iter = storage.iterator();
		while(iter.hasNext()) {
			PhoneInfo str = iter.next();
			if(str.getName().equals(input)) {	
				System.out.println(str.toString());
			}
		}
	}
	
	
	//메소드
	//데이터 초기화
	public void readFromFile() {
		if(dataFile.exists() == false) {
			return;
		}
		try {
			FileReader fr = new FileReader(dataFile);
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			PhoneInfo info = null;
			while((str = br.readLine()) != null) {
				String[] record = str.split(",");
				int type = Integer.parseInt(record[0]);
				switch(type) {
				case InputSelect.NORMAL:
					info = new PhoneInfo(record[1], record[2]);
					break;
				case InputSelect.COMPANY:
					info = new PhoneCompanyInfo(record[1], record[2], record[3]);
					break;
				case InputSelect.UNIV:
					info = new PhoneUnivInfo(record[1], record[2], record[3], Integer.parseInt(record[4]));
				}
				storage.add(info);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//입력값 파일에 저장
	public void storeToFile() {
		try {
			FileWriter fr = new FileWriter(dataFile);
			Iterator<PhoneInfo> iter = storage.iterator();
			while(iter.hasNext()) {
				PhoneInfo info = iter.next();
				//toString 활용
				fr.write(info.toString() + "\n");
			}
			fr.flush();
			fr.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
