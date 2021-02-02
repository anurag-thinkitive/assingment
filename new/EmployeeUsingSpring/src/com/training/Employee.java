package com.training;

import org.springframework.stereotype.Component;


public class Employee {
	
	public int getEmpid() {
		return empid;
	}

	public Employee(int empid, int basicsalary, int hra, int pf, int pt, int medical, int gross, int netsalary,
			String ename) {
		super();
		this.empid = empid;
		this.basicsalary = basicsalary;
		this.hra = hra;
		this.pf = pf;
		this.pt = pt;
		this.medical = medical;
		this.gross = gross;
		this.netsalary = netsalary;
		this.ename = ename;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Employee.count = count;
	}

	public int getBasicsalary() {
		return basicsalary;
	}

	public void setBasicsalary(int basicsalary) {
		this.basicsalary = basicsalary;
	}

	public int getHra() {
		return hra;
	}

	public void setHra(int hra) {
		this.hra = hra;
	}

	public int getPf() {
		return pf;
	}

	public void setPf(int pf) {
		this.pf = pf;
	}

	public int getPt() {
		return pt;
	}

	public void setPt(int pt) {
		this.pt = pt;
	}

	public int getMedical() {
		return medical;
	}

	public void setMedical(int medical) {
		this.medical = medical;
	}

	public int getGross() {
		return gross;
	}

	public void setGross(int gross) {
		this.gross = gross;
	}

	public int getNetsalary() {
		return netsalary;
	}

	public void setNetsalary(int netsalary) {
		this.netsalary = netsalary;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	int empid;
	static int count=(int)(Math.random()*2136);
	int basicsalary;
	int hra;
	int pf;
	int pt;
	int medical;
	int gross;
	int netsalary;
	String ename;
	
	public Employee() {
		
	}
	
	public Employee(int basicsalary, int medical, String ename) {
		super();
	
		this.empid = count;
		count++;
		
		this.basicsalary = basicsalary;
		this.medical = medical;
		this.ename = ename;
		this.hra=(int) (0.5*basicsalary);
		this.pf=(int)(0.12*basicsalary);
		this.pt=200;
		this.gross=basicsalary+hra+medical;
		this.netsalary=gross-pf-pt;
		
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", basicsalary=" + basicsalary + ", hra=" + hra + ", pf=" + pf + ", pt="
				+ pt + ", medical=" + medical + ", gross=" + gross + ", netsalary=" + netsalary + ", ename=" + ename
				+ "]";
	}
	
	

}




	
	
