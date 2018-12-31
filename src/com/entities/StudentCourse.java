package com.entities;

public class StudentCourse {
	int studentCourseId;
	String courseId;
	int studentId;
	
	public StudentCourse() {}
	
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public int getStudentCourseId() {
		return studentCourseId;
	}

	public void setStudentCourseId(int studentCourseId) {
		this.studentCourseId = studentCourseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public StudentCourse(int studentCourseId,String courseId, int studentId) {
		super();
		this.courseId=courseId;
		this.studentCourseId = studentCourseId;
		this.studentId = studentId;
	}
	public StudentCourse(String courseId, int studentId) {
		
		this.courseId=courseId;
		this.studentId = studentId;
	}
}
