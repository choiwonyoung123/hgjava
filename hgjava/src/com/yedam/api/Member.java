package com.yedam.api;

//equals
public class Member {
	String name;
	int age;
	
	Member(){
		
	}
	Member(String name, int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public int hashCode() {
		return this.name.hashCode();
		//return 10;
	}
	@Override
	public String toString() {
		return "이름은 " + name + ", 나이는 " + age;
	}
	//name,age 같으면 논리적으로 동일한 객체
	//equals() 재정의
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member target = (Member) obj;
			if(this.name.equals(target.name) && this.age == target.age) {
				return true;
			}
		}
		return false;
	}
}
