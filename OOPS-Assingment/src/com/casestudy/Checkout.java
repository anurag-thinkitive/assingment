package com.casestudy;

public class Checkout {
	
	
	
	double totalcost;
	int candycount;
	int cookiecount;
	int icecreamcount;
	int sundaecount;
	
	
	public void setitem(String item[] ) {
		
if(item[0] =="Candy") {
	candycount=Integer.parseInt(item[1]);
	Candy c=new Candy( candycount);
	totalcost=totalcost+c.cost();
}
if(item[0] =="Cookie") {
	 cookiecount=Integer.parseInt(item[1]);
	Cookie c=new Cookie( cookiecount);
	totalcost=totalcost+c.cost();
}
if(item[0] =="IceCream") {
	icecreamcount=Integer.parseInt(item[1]);
	IceCream c= new IceCream(icecreamcount);
	totalcost=totalcost+c.cost();
}
if(item[0] =="IceCream") {
	icecreamcount=Integer.parseInt(item[1]);
	IceCream c= new IceCream(icecreamcount);
	totalcost=totalcost+c.cost();
}
if(item[0] =="Sundae") {
	sundaecount=Integer.parseInt(item[1]);
	IceCream c= new IceCream(sundaecount);
	totalcost=totalcost+c.cost();
}




}
	
	public double totalcost() {
		
		return  totalcost;
		
	}

	@Override
	public String toString() {
		
			System.out.println("#################   Invoice  ################");
			

			
		return "Checkout [totalcost=" + totalcost + ", candycount=" + candycount + ", cookiecount=" + cookiecount
				+ ", icecreamcount=" + icecreamcount + ", sundaecount=" + sundaecount + "]";
	}

	

	
	

}
