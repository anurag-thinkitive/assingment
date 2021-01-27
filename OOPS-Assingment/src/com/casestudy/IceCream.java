package com.casestudy;

public class IceCream  extends DessertItem{
int no;
public IceCream(int  no) {
	this .no=no;
}



	@Override
	public double cost() {
		// TODO Auto-generated method stub
		double cost=no*10;
		return cost;
		
	}
	

}
