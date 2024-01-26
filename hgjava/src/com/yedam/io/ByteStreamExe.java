package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ByteStreamExe {
	//입력출력 > 복사
	//바이트출력 스트림
	public static void main(String[] args) {
		//문자기반 입출력
		try {
			FileReader fr = new FileReader("C:/temp/text.dat");
			BufferedReader br = new BufferedReader(fr);
			while(true) {				
				String read = br.readLine(); //한라인씩 읽기
				if(read == null) { //eof > null 반환
					break;
				}
				System.out.println(read);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("end of file..");
	}
	static void write() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/sample.dat");
			fos.write(10);
			fos.write(20);
			fos.write(30);
			fos.flush();
			fos.close(); //자원환원
		} catch (IOException e) {
			System.out.println("end of file..");
		}
	}
	static void read() {
		//복사 보조스트림
		try {			
			FileInputStream fis = new FileInputStream("C:/temp/npp.exe");
			FileOutputStream fos = new FileOutputStream("C:/temp/copy2.exe");
			//보조스트림 buffered
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			
			while(true) {				
				int buf = bis.read();
				if(buf == -1) {
					break;
				}
				fos.write(buf);
			}
			bos.flush();
			bos.close();
			fos.flush();
			fos.close();
			bis.close();
			fis.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//복사
		try {			
			FileInputStream fis = new FileInputStream("C:/temp/npp.exe");
			FileOutputStream fos = new FileOutputStream("C:/temp/copy.exe");
			byte[] byteAry = new byte[100];
			
			while(true) {				
				int buf = fis.read(byteAry);
				if(buf == -1) {
					break;
				}
				fos.write(byteAry);
			}
			fos.flush();
			fos.close();
			fis.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//파일 출력
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/sample.dat");
			fos.write(10);
			fos.write(20);
			fos.write(30);
			fos.flush();
			fos.close(); //자원환원
		} catch (IOException e) {
			e.printStackTrace();
		}
		//파일 입력
		try {
			FileInputStream fis = new FileInputStream("C:/temp/sample.dat");
			while(true) {				
				int bytes = fis.read(); //eof > -1반환
				if(bytes == -1) {
					break;
				}
				System.out.println(bytes);
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
