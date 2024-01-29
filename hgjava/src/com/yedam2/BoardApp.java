package com.yedam2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


//<<기능 구현 클래스>>
public class BoardApp {
	Scanner scn = new Scanner(System.in);
	//<<인스턴스>>
	private static BoardApp instance;
	public static BoardApp getInstance() {
		if(instance == null) {
			instance = new BoardApp();
		}
		return instance;
	}
	//<<파일>>
	private File boardFile = new File("C:/temp/boardList.dat");
	List<Board> boardList = new ArrayList<>();
	private BoardApp() {
		readFromFile();
	}
	//<<파일 읽기, 초기화>>
	public void readFromFile() {
		if(boardFile.exists() == false) {
			return;
		}
		try {
			FileReader fr = new FileReader(boardFile);
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			Board info = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while((str = br.readLine()) != null) {
				String[] record = str.split(",");
				info = new Board(Integer.parseInt(record[0]), record[1], record[2], record[3], sdf.parse(record[4]));
				boardList.add(info);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//<<파일 저장 및 종료기능>>
	public void storeToFile() {
		try {
			FileWriter fr = new FileWriter(boardFile);
			Iterator<Board> iter = boardList.iterator();
			while(iter.hasNext()) {
				Board info = iter.next();
				fr.write(info.toString() + "\n");
			}
			fr.flush();
			fr.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	//<<추가기능>>
	public boolean register() {
		System.out.println("\"게시글번호,제목,내용,작성자,작성일자\" 양식으로 입력");
		String textInfo = scn.nextLine();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] textInfoAry = textInfo.split(",");
		Board Info = null;
		try {
			boardList.add(new Board(Integer.parseInt(textInfoAry[0]), textInfoAry[1], textInfoAry[2], textInfoAry[3], sdf.parse(textInfoAry[4])));
			System.out.println("등록완료");
			return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	//<<수정기능>>
	public void modify() {
		System.out.print("수정할이름 입력:");
		String modifyName = scn.nextLine();
		System.out.print("수정할내용 입력:");
		String modifyContent = scn.nextLine();
		for(int i = 0; i < boardList.size(); i++) {
			if(boardList.get(i).getWriter().equals(modifyName)) {
				Board.setContent(modifyContent);
				System.out.println("수정완료");
			}
		}
	}
	//<<조회기능>>
	public void search() {
		System.out.print("단건검색할이름 입력:");
		String searchName = scn.nextLine();
		for(int i = 0; i < boardList.size(); i++) {
			if(boardList.get(i).getWriter().equals(searchName)) {
				System.out.println(boardList.get(i).toString());
				System.out.println("단건조회완료");
			}
		}
	}
	//목록기능
	public void list() {
		for(int i = 0; i < boardList.size(); i++) {
			System.out.println(boardList.get(i).toString());
		}
		System.out.println("목록조회완료");
	}
	//<<삭제기능>>
	public void remove() {
		System.out.print("삭제할이름 입력:");
		String removeName = scn.nextLine();
		for(int i = 0; i < boardList.size(); i++) {
			if(boardList.get(i).getWriter().equals(removeName)) {
				boardList.remove(i);
				System.out.println("삭제완료");
			}
		}
	}
}
