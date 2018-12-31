package com.entities;

public class Course {
	String courseId;
	String courseName;
	int teacherId;
	String teacherName;
	
	public Course() {}
	
	public Course(String courseId, String courseName, int teacherId) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.teacherId = teacherId;
		
	}
	
	public Course(String courseId, String courseName, String teacherName) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.teacherName = teacherName;
	}

	
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
}
