package com.thinkitive.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "demoexam")
public class Exam {
	@Id @Column(name = "e_id")
	private int e_id;
	@Column(name = "name")
	private String name;
	
	


	public int getE_id() {
		return e_id;
	}



	public void setE_id(int e_id) {
		this.e_id = e_id;
	}



	public List<Result> getResult() {
		return result;
	}



	public void setResult(List<Result> result) {
		this.result = result;
	}
@ElementCollection
	@OneToMany( targetEntity=Question.class,mappedBy = "exam",cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
@JsonManagedReference(value = "question-reference") 
	private  List<Question> questions;
	public Exam(int e_id, String name, List<Question> questions, List<Result> result) {
		super();
		this.e_id = e_id;
		this.name = name;
		this.questions = questions;
		this.result = result;
	}
@ElementCollection
	@OneToMany( targetEntity=Result.class,mappedBy = "exam",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference(value = "exam-refernce")
	private List<Result> result;
	
	public Exam() {
		// TODO Auto-generated constructor stub
	}
	


	@Override
	public String toString() {
		return "Exam [e_id=" + e_id + ", name=" + name + ", questions=" + questions + ", result=" + result + "]";
	}



	public Exam(int id, String name, List<Question> questions) {
		super();
		this.e_id = id;
		this.name = name;
		this.questions = questions;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + e_id;
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
		Exam other = (Exam) obj;
		if (e_id != other.e_id)
			return false;
		return true;
	}

	public int getId() {
		return e_id;
	}

	public void setId(int id) {
		this.e_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}


	
	
	

}
