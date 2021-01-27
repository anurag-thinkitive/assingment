package com.casestudy;

public class TestCheckout {
public static void main(String[] args) {
	Checkout c=new Checkout();
	
	c.setitem(new String[]{"Candy","12"});
	c.setitem(new String[]{"Cookie","12"});
	c.setitem(new String[]{"IceCream","12"});
	c.setitem(new String[]{"sundaecount","12"});
	System.out.println(c);
}

	
	
}
