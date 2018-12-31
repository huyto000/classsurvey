package com.entities;

public class Survey {
	private int surveyId;
	private String courseId;
	private int studentId;
	
	public Survey() {
	}
	public Survey(String courseId, int studentId) {
		this.courseId = courseId;
		this.studentId = studentId;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}
