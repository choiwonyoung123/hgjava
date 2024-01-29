package com.yedam.phonebook;

public class PhoneInfo {
	private String name;
	private String phone;
	public PhoneInfo(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	public void showPhoneInfo() {
		System.out.println("name:" + name);
		System.out.println("phone:" + phone);
	}

	@Override
	public String toString() {
		return InputSelect.NORMAL + "," + name + "," + phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
