package com.yedam.io.emp;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//초기화(컬렉션) - 추가 - 목록 - 종료(저장)
public class EmpApp {
	List<Employee> storage = new ArrayList<>();
	
	
	public EmpApp() {
		init();
	}
	
	//초기화
	public void init() {
		try {
			File file = new File("C:/temp/emp.dat");
			if(!file.exists()) {
				file.createNewFile();
			}
			else {
				file.delete();
				System.out.println(file.lastModified());
			}
			
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			storage = (List<Employee>) ois.readObject(); //바이트 > 객체생성, 역직렬화, 형변환
			ois.close();
			fis.close();
		} catch (EOFException e) {
			
		} catch (FileNotFoundException e) {
			System.out.println("파일없음");
		}catch (Exception e) {
			System.out.println("알수없는 오류");
		}
	}
	
	public void save() {
		//기본스트림 > 보조스트림 > 저장
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/emp.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(storage); //객체타입을 파일에 작성
			oos.flush();
			fos.flush();
			oos.close();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//등록
	public boolean add(Employee emp) {
		return storage.add(emp);
	}
	
	//목록
	public List<Employee> list(){
		return storage;
	}
}
