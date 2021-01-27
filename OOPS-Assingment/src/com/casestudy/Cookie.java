package com.casestudy;

public class Cookie  extends DessertItem{
int dozen;
public Cookie() {
	dozen=0;
}
	public Cookie(int dozen) {
	super();
	this.dozen = dozen;
	
}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		double cost= (10*dozen)/12;
		return cost;
	}

}
