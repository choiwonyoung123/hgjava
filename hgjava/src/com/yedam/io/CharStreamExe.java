package com.yedam.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//문자기반 입출력
public class CharStreamExe {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		Class cls = CharStreamExe.class;
		String path = cls.getResource("ByteStreamExe.class").getPath();
		System.out.println(path);
		path = "/D:/git/hgjava/hgjava/src/com/yedam/io/ByteStreamExe.java";
		try {
			FileReader fr = new FileReader(path);
			while(true) {				
				int read = fr.read();
				if(read == -1) {
					break;
				}
				System.out.print((char)read);
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end of program..");
		
	}
	static void write() {
		try {
			FileWriter fw = new FileWriter("C:/temp/text.dat");
			while(true) {				
				System.out.print("입력:");
				String str = scn.nextLine();
				if(str.equals("stop")) {
					break;
				}
				fw.write(str + "\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
