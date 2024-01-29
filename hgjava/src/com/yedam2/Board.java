package com.yedam2;

import java.text.SimpleDateFormat;
import java.util.Date;

//데이터 정의 클래스
public class Board {
	//<<필드>>
	private int textNum;
	private String title;
	private String content;
	private String writer;
	private Date wrtieDate;
	//<<생성자>>
	public Board(int textNum, String title, String content, String writer, Date wrtieDate) {
		super();
		this.textNum = textNum;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.wrtieDate = wrtieDate;
	}
	//<<메소드>>
	//toString
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return textNum + "," + title + "," + content + "," + writer + "," + sdf.format(wrtieDate);
	}
	//getter,setter
	public int getTextNum() {
		return textNum;
	}
	public void setTextNum(int textNum) {
		this.textNum = textNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public static void setContent(String content) {
		content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWrtieDate() {
		return wrtieDate;
	}
	public void setWrtieDate(Date wrtieDate) {
		this.wrtieDate = wrtieDate;
	}
}
