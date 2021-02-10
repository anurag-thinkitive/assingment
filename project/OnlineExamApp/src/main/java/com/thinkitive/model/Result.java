package com.thinkitive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "demoresult")
public class Result {
	@Id @Column(name = "r_id" )
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int r_id;
	public Result() {
		// TODO Auto-generated constructor stub
	}
	
	private int marks;
	@ManyToOne()
	@JsonBackReference(value = "exam-refernce")
	 private Exam exam;

	@ManyToOne()
	@JsonBackReference(value = "student-reference")
	private Student student;
	public int getId() {
		return r_id;
	}
	public void setId(int id) {
		this.r_id = id;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + r_id;
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
		Result other = (Result) obj;
		if (r_id != other.r_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Result [id=" + r_id + ", marks=" + marks + ", exam=" +  ", student=" + student + "]";
	}
	public Result(int id, int marks, Exam exam, Student student) {
		super();
		this.r_id = id;
		this.marks = marks;
		this.exam = exam;
		this.student = student;
	}
	
	
	 
	
	
	

}
