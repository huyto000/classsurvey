package com.entities;

public class Answer {
	private int answerId;
	private int answerContent;
	
	public Answer() {
		
	}
	public Answer(int answerId, int answerContent) {
		this.answerId = answerId;
		this.answerContent = answerContent;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public int getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(int answerContent) {
		this.answerContent = answerContent;
	}
}
