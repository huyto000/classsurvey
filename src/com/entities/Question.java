package com.entities;

public class Question {
	private int questionId;
	private String content;
	private int type;
	
	private double result;
	
	public Question() {
		
	}
	
	public Question(int questionId, String content, int type) {
		this.questionId = questionId;
		this.content = content;
		this.type = type;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
}
