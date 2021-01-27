package com.casestudy;

public  abstract class DessertItem {
private   String name;
 public DessertItem() {
	
	 
 }

public DessertItem(String name) {
	super();
	this.name = name;
}

public abstract double cost();

public  final  String name() {
	return this.name;
}
}
