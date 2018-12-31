package com.entities;

public class Member {
	private int memberId;
	private String username;
	private String password;
	private String fullname;
	private int role;    // 1 - Student, 2 - Teacher, 3 - Admin
	
	public Member() {
		
	}
	
	public Member(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Member(String username, String password, String fullname, int role) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
}
