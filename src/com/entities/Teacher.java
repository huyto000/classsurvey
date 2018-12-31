package com.entities;

public class Teacher {
	
	
	private int id;
	private String userName;
	private String passWord;
	private String fullName;
	private String email;
	
	public Teacher() {
		
	}
	
	public Teacher(int id, String userName, String passWord, String fullName) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
	}

	public Teacher(String userName, String passWord, String fullName, String email) {
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.email = email;
	}
	
	
	public Teacher(int id, String userName, String passWord, String fullName, String email) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.email = email;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
