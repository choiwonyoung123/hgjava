package com.yedam.collection;

public class Box<T> { //제내릭으로 정의 > 타입을 사용할때 정의
	T obj;
	
	void setObj(T obj) {
		this.obj = obj;
	}
	T getObj() {
		return obj;
	}
}
