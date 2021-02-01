package com.training.util;

import java.util.ArrayList;
import java.util.List;

import com.training.Book;

public class StoreUtil  <T>{
	int count=0;
	List<T> l=new ArrayList();
	public void addrecord(T b) {
		l.add(b);
	}
	public List getrecords() {
		return l;
	}
public int getnumrecords() {
for(int i=0;i<l.size();i++) {
	count++;
}
return count;
}
}
