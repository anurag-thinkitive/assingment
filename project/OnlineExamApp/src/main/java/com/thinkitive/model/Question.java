package com.thinkitive.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Component
@Entity
@Table(name = "demoquestion")
public class Question {
	
	@Id @Column(name = "q_id")
	private int q_id;
	@Column(name = "setorder")
	private int order;
	@Column(name = "question")
	private String question;
	@Column(name = "option1")
	private String option1;
	@Column(name = "option2")
	private String option2;
	@Column(name = "option3")
	private String option3;
	@Column(name = "option4")
	private String option4;
	@Column(name = "answer")
	private String answer;
	
	@ManyToOne()
	@JsonBackReference(value = "question-reference")
	 private Exam exam;
	public Question(int q_id, int order, String question, String option1, String option2, String option3,
			String option4, String answer, Exam exam, int correctoption) {
		super();
		this.q_id = q_id;
		this.order = order;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.exam = exam;
		this.correctoption = correctoption;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	@Column(name = "correctoption")
	private int correctoption ;
	
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	public int getCorrectoption() {
		return correctoption;
	}
	public void setCorrectoption(int correctoption) {
		this.correctoption = correctoption;
	}
	public Question() {
		// TODO Auto-generated constructor stub
	}


	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
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
	public Question(int q_id, int order, String question, String option1, String option2, String option3,
			String option4, String answer, int correctoption) {
		super();
		this.q_id = q_id;
		this.order = order;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.correctoption = correctoption;
	}
	@Override
	public String toString() {
		return "Question [q_id=" + q_id + ", order=" + ", question=" + question + ", option1=" + option1
				+ ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", answer=" + answer
				+ ", exam=" +   ", correctoption=" + correctoption + "]";
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + q_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (q_id != other.q_id)
			return false;
		return true;
	}
	
	
	
}
