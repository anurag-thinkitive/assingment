package com.training;

public class Address {
	private String city;
	private int pincode;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pincode;
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
		Address other = (Address) obj;
		if (pincode != other.pincode)
			return false;
		return true;
	}
	public Address(String city, int pincode) {
		super();
		this.city = city;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return " [city=" + city + ", pincode=" + pincode + "]";
	}
	public void helloworld() {
			System.out.println("hell");
	}

}

