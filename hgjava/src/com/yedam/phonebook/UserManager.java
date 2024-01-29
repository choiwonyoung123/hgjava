package com.yedam.phonebook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;

//기능은 c:/temp/userList.txt에 저장된 아이디 비번 이용
//사용자권한
//3번 인증 실패하면 프로그램 종료
public class UserManager {
	private File loginFile = new File("C:/temp/login.txt");
	HashSet<UserManager> loginstorage = new HashSet<>();
	private static UserManager instance;
	
	private String userId;
	private String userPw;
	
	private UserManager() {
		readFromFile();	
	}
	public static UserManager getInstance() {
		if(instance == null) {
			//새로운 인스턴스 객체 생성
			instance = new UserManager();
		}
		return instance;
	}
	
	
	
	//생성자
	public UserManager(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}
	//게터세터
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	//로그인기능
	public boolean userCheck() {
		System.out.print("아이디입력:");
		String userInputId = MenuViewer.keyboard.nextLine();
		System.out.print("비밀번호입력:");
		String userInputPw = MenuViewer.keyboard.nextLine();
		Iterator<UserManager> iter = loginstorage.iterator();
		while(iter.hasNext()) {
			UserManager str = iter.next();
			if(str.getUserId().equals(userInputId) && str.getUserPw().equals(userInputPw)) {				
				return true;
			}
			else {		
				break;
			}
		}
		return false;
	}
	public void readFromFile() {
		if(loginFile.exists() == false) {
			return;
		}
		try {
			FileReader fr = new FileReader(loginFile);
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			UserManager info = null;
			while((str = br.readLine()) != null) {
				String[] record = str.split(" ");
				info = new UserManager(record[0], record[1]);
				loginstorage.add(info);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
