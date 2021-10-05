package com.ajaxstudy.contact.domain;

public class Result {
	private String status;
	private String message;

	public Result() {
		// TODO Auto-generated constructor stub
	}
	public Result(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	//toString¸Ş¼Òµå
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
