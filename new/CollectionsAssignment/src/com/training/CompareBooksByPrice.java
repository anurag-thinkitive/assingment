package com.training;

import java.util.Comparator;

public class CompareBooksByPrice implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		// TODO Auto-generated method stub
		return b1.getPrice().compareTo(b2.getPrice());
	}

}
