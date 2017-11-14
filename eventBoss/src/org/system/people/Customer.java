package org.system.people;

import java.util.ArrayList;

import org.system.event.Seat;

public class Customer {

	//attributes
	String name;
	Address address;
	String phone;
	String email;
	PaymentInfo paymentCard;
	ArrayList<Seat> seatsPurchased = new ArrayList<Seat>();
	Cart cartTotal;
	Account accountInfo;
	
	//constructors
	public Customer() {
		this.name = "NULL";
		this.address = new Address();
		this.phone = "NULL";
		this.email = "NULL";
		this.paymentCard = new PaymentInfo();
		this.seatsPurchased = new ArrayList<Seat>();
		this.cartTotal = new Cart();
	}
	public Customer(String name, Address address, String phone, String email, PaymentInfo paymentCard){ //Account accountInfo) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.paymentCard = paymentCard;
		this.seatsPurchased = new ArrayList<Seat>();
		this.cartTotal = new Cart();
	}
	public Customer(String name, Address address, String phone, String email, PaymentInfo paymentCard,
			ArrayList<Seat> seatsPurchased, Cart cartTotal){ //Account accountInfo) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.paymentCard = paymentCard;
		this.seatsPurchased = seatsPurchased;
		this.cartTotal = cartTotal;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PaymentInfo getPaymentCard() {
		return paymentCard;
	}
	public void setPaymentCard(PaymentInfo paymentCard) {
		this.paymentCard = paymentCard;
	}
	public ArrayList<Seat> getSeatsPurchased() {
		return seatsPurchased;
	}
	public void setSeatsPurchased(ArrayList<Seat> seatsPurchased) {
		this.seatsPurchased = seatsPurchased;
	}
	public Cart getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(Cart cartTotal) {
		this.cartTotal = cartTotal;
	}

	public void addSeat(Seat seat){
		this.seatsPurchased.add(seat);
	}
	
	
}
