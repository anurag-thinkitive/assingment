package com.thinkitive.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name = "demostudent")
public class Student {
	@Id @Column(name = "s_id")
	private int s_id;
	@Column(name="name")
	private String name;
	@Column(name="username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "status")
	private boolean status;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}@ElementCollection
	@OneToMany(targetEntity=Result.class,mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference(value = "student-reference")
	private List<Result> result;
	
	
	public Student(int id, String name, String username, String password, List<Result> result) {
		super();
		this.s_id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.result = result;
	}
	public List<Result> getResult() {
		return result;
	}
	public void setResult(List<Result> result) {
		this.result = result;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return s_id;
	}
	public void setId(int id) {
		this.s_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Student other = (Student) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", status=" + status + ", result=" + result + "]";
	}
	public Student(int s_id, String name, String username, String password, boolean status, List<Result> result) {
		super();
		this.s_id = s_id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.status = status;
		this.result = result;
	}
	
	
	

}
