package com.thinkitive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "demoadmin")
public class Admin {
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin(int a_id, String name, String username, String password, boolean status) {
		super();
		this.a_id = a_id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Admin [a_id=" + a_id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", status=" + status + "]";
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
		Admin other = (Admin) obj;
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
	public int getId() {
		return a_id;
	}
	public void setId(int id) {
		this.a_id = id;
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
	@Id @Column(name = "a_id")
	private int a_id;
	@Column(name="name")
	private String name;
	@Column(name="username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "status")
	private boolean status;
}
