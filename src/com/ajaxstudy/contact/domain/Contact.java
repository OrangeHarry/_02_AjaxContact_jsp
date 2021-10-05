package com.ajaxstudy.contact.domain;

public class Contact {
	// 필드
	private long no;
	private String name;
	private String tel;
	private String address;

	// 생성자
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(long no, String name, String tel, String address) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	// getter setter 메소드
	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// 재정의 된 toString 메소드
	@Override
	public String toString() {
		return "Contact [no=" + no + ", name=" + name + ", tel=" + tel + ", address=" + address + "]";
	}

}
