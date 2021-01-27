package com.casestudy;

public class Candy extends DessertItem {
double kg;
int rate;
public Candy() {
super();
kg=0;
}

	public Candy(int kg) {
	super();
	this.kg = kg;
	
}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		double  cost = (50*kg)/1000;
		
		return cost;
		
		
	}
	
	

}
