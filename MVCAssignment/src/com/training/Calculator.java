package com.training;

public class Calculator {

	private  Integer a;
private Integer b;
public double add (Integer a,Integer b) {
	double ans=0;
	ans=a+b;
	return ans;
}
public double mul (Integer a,Integer b) {
	double ans=1;
	
		
		ans=a*b;
	
	return ans;
}

@Override
public String toString() {
	return "Calculator [a=" + a + ", b=" + b + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((a == null) ? 0 : a.hashCode());
	result = prime * result + ((b == null) ? 0 : b.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Calculator other = (Calculator) obj;
	if (a == null) {
		if (other.a != null)
			return false;
	} else if (!a.equals(other.a))
		return false;
	if (b == null) {
		if (other.b != null)
			return false;
	} else if (!b.equals(other.b))
		return false;
	return true;
}
public Integer getA() {
	return a;
}
public void setA(Integer a) {
	this.a = a;
}
public Integer getB() {
	return b;
}
public void setB(Integer b) {
	this.b = b;
}
public int div(Integer a,Integer b) {
return a/b;
}
public int sub(Integer a,Integer b) {
return a-b;
}
}
