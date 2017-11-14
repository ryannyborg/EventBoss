package org.system.people;

import java.util.Arrays;

public class Account {

	String username;
	char[] password;
	Customer human;
	
	//constructors
	public Account() {
		this.username = "NULL";
		this.password = new char[0];
		this.human = new Customer();
	}
	public Account(String username, char[] password, Customer human) {
		this.username = username;
		this.password = password;
		this.human = human;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public Customer getHuman() {
		return human;
	}
	public void setHuman(Customer human) {
		this.human = human;
	}
	
	//returns true or false depending on correct password
	public boolean checkPassword(char[] userInpPassword){
		if(Arrays.equals(password, userInpPassword))
			return true;
		else
			return false;
	}
}
