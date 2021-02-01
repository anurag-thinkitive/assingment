package com.training.util;

import java.util.Collections;
import java.util.List;

import com.training.CompareBooksByName;
import com.training.CompareBooksByPrice;
import com.training.Book;

public class SortUtil  {
public List sortbyname(List l){
	CompareBooksByName nam=new CompareBooksByName();
	Collections.sort(l, nam);
	return l;
	
	
}
public List  sortByPrice(List l) {
	CompareBooksByPrice pric=new CompareBooksByPrice();
	Collections.sort(l, pric);
	return l;
}

}
