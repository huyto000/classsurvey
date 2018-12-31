package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entities.Admin;
import com.entities.Member;
import com.entities.Student;
import com.entities.Teacher;
import com.utils.DatabaseUtils;

public class LoginDao {
	public static ArrayList<Student> getListStudent(Connection conn){
		ArrayList<Student> listStudent = new ArrayList<Student>();
		String sql = "select * from student";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("student_id");
				String username = rs.getString("userName");
				String password = rs.getString("passWord");
				String fullname = rs.getString("fullName");
				
				Student student = new Student(id, username, password, fullname);
				
				listStudent.add(student);
			}
			
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listStudent;
	}
	
	public static ArrayList<Teacher> getListTeacher(Connection conn){
		ArrayList<Teacher> listTeacher = new ArrayList<Teacher>();
		String sql = "select * from teacher";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("teacher_id");
				String username = rs.getString("userName");
				String password = rs.getString("passWord");
				String fullname = rs.getString("fullName");
				
				Teacher teacher = new Teacher(id, username, password, fullname);
				
				listTeacher.add(teacher);
			}
			
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listTeacher;
	}
	
	public static ArrayList<Admin> getListAdmin(Connection conn){
		ArrayList<Admin> listAdmin = new ArrayList<Admin>();
		String sql = "select * from admin";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				Admin admin = new Admin(username, password);
				
				listAdmin.add(admin);
			}
			
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listAdmin;
	}
	
	public static Member AuthenticationMember(Member member) throws ClassNotFoundException, IOException, SQLException {
		Connection conn = DatabaseUtils.getConnection();
		ArrayList<Student> listStudent = LoginDao.getListStudent(conn);
		ArrayList<Teacher> listTeacher = LoginDao.getListTeacher(conn);
		ArrayList<Admin> listAdmin = LoginDao.getListAdmin(conn);
		
		member.setRole(0);
		
		for(Student student : listStudent) {
			if(member.getUsername().equals(student.getUserName()) && member.getPassword().equals(student.getPassWord())) {
				member.setRole(1);
				member.setMemberId(student.getId());
				member.setFullname(student.getFullName());
			}
		}
		for(Teacher teacher : listTeacher) {
			if(member.getUsername().equals(teacher.getUserName()) && member.getPassword().equals(teacher.getPassWord())) {
				member.setRole(2);
				member.setMemberId(teacher.getId());
				member.setFullname(teacher.getFullName());
			}
		}
		for(Admin admin : listAdmin) {
			if(member.getUsername().equals(admin.getUsername()) && member.getPassword().equals(admin.getPassword())) {
				member.setRole(3);
			}
		}
		
		return member;
	}
}
