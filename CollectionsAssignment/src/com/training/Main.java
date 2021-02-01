package com.training;

import java.util.HashSet;
import java.util.Set;

import com.training.util.PrintUtil;
import com.training.util.SortUtil;
import com.training.util.StoreUtil;

public class Main {
public static <T> void main(String[] args) {
	Set<String> author=new HashSet<String>();
	author.add("anu");
	author.add("rag");
	
	Book b=new Book(1,"james",author,324);
	Book b1=new Book(2,"jordan",author,903);
	Book b2=new Book(3,"joan",author,700);
	Book b3=new Book(4,"carry",author,404);
	StoreUtil<T> st=new StoreUtil<T>();
	st.addrecord((T) b);
	st.addrecord((T) b1);
	st.addrecord((T) b2);
	st.addrecord((T) b3);
	int n= st.getnumrecords();
	System.out.println(n);
	PrintUtil p=new PrintUtil();
	p.printRecords(st.getrecords());
	
	SortUtil s=new SortUtil();
	System.out.println(s.sortbyname(st.getrecords()));
	
	System.out.println(s.sortByPrice(st.getrecords()));
	
	
}
}
