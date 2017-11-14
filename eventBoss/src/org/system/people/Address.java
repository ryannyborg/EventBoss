package org.system.people;

public class Address {
	String street;
	String city;
	String state;
	String country;
	String zipCode;
	
	//constructore
	public Address(String street, String city, String state, String country, String zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}
	public Address() {
		this.street = "NULL";
		this.city = "NULL";
		this.state = "NULL";
		this.country = "NULL";
		this.zipCode = "NULL";
	}
	
	//getters and setters
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/* Below is for printing the box office address to screen
	 * It is split into three because I needed to add breaks
	 * in between the parts or else it would have been too long.
	 */
	public String getFirstAddress(){
		String firstAddress = this.street;
		return firstAddress;
	}
	
	public String getSecondAddress(){
		String secondAddress = this.city + ", " + this.state;
		return secondAddress;
	}
	
	public String getThirdAddress(){
		String thirdAddress = this.country + " " + this.zipCode;
		return thirdAddress;
	}
	
	
}
