package com.entities;

public class Student {
	
	private int id;
	private String userName;
	private String passWord;
	private String fullName;
	private String email;
	private String className;
	
	public Student() {}
	
	public Student(int id, String userName, String passWord, String fullName) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
	}

	public Student(String userName,String passWord,String fullName,String email,String className) {
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.email = email;
		this.className = className;
	}
	
	public Student(int id,String userName,String passWord,String fullName,String email,String className) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.email = email;
		this.className = className;
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
