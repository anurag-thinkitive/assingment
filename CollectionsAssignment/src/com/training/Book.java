package com.training;

import java.util.Set;

public class Book {
private int id;
private String name;
private Set<String> author;
private Integer price;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Book() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Set<String> getAuthor() {
	return author;
}
public void setAuthor(Set<String> author) {
	this.author = author;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
@Override
public String toString() {
	return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
}
public Book(int id, String name, Set<String> author, int price) {
	super();
	this.id = id;
	this.name = name;
	this.author = author;
	this.price = price;
}




}
