package com.example.bean;
/**
 * 单个试题
 */
import java.io.Serializable;

@SuppressWarnings("serial")
public class Item implements Serializable {
	private String id;
	private String subjectName;
	private String knowledge;
	private String sourcename;
	private String questionTypes;
	private String questionDifficulty;
	private String question;
	private String answer;
	private String resolve;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}
	public String getSourcename() {
		return sourcename;
	}
	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}
	public String getQuestionTypes() {
		return questionTypes;
	}
	public void setQuestionTypes(String questionTypes) {
		this.questionTypes = questionTypes;
	}
	public String getQuestionDifficulty() {
		return questionDifficulty;
	}
	public void setQuestionDifficulty(String questionDifficulty) {
		this.questionDifficulty = questionDifficulty;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getResolve() {
		return resolve;
	}
	public void setResolve(String resolve) {
		this.resolve = resolve;
	}
	
}
