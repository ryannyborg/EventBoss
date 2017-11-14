package org.system.people;

import java.util.ArrayList;

import org.system.event.Seat;

public class Cart {

	//attributes
	double taxRate;
	ArrayList<Seat> seatsInCart;
	int ticketNumber;
	
	//constructors
	public Cart() {
		this.taxRate = -1;
		this.seatsInCart = new ArrayList<Seat>();
		this.ticketNumber = -1;
	}
	
	public Cart(double taxRate, ArrayList<Seat> seatsInCart, int ticketNumber) {		
		this.taxRate = taxRate;
		this.seatsInCart = seatsInCart;
		this.ticketNumber = ticketNumber;
	}
	
	//getters and setters
	public double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public ArrayList<Seat> getSeatsInCart() {
		return seatsInCart;
	}
	public void setSeatsInCart(ArrayList<Seat> seatsInCart) {
		this.seatsInCart = seatsInCart;
	}
	public void addSeatToCart(Seat seat){
		seatsInCart.add(seat);
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public void clearCart(){
		this.seatsInCart.removeAll(seatsInCart);
	}

	//returns tax amount
	public double calculateSubtotalAmount(){
		double subtotal = 0;
		for(Seat temp : seatsInCart){
			subtotal += temp.getSeatPrice();
		}
		return subtotal;
	}
	
	//returns tax amount
	public double calculateTaxAmount(){
		return (calculateSubtotalAmount() * taxRate);
	}
	//returns total price after tax
	public double calculateTotal(){
		return (calculateSubtotalAmount() + calculateTaxAmount());
	}
	
	//checkout: return false if card declined/not present/ticket not avail
	//adds seat to customer's purchasedseat arraylist
	public boolean checkoutCart(PaymentInfo card, Customer customer){
		for (Seat temp : seatsInCart){
		if (!temp.isAvailable())
			return false;//failed if ticket not available
		if (card.getCardCompany() == "NULL" || card.getSecurityCode() == -1)
			return false;//failed if card info not entered, only default constr
		//if no problems with payment
		}
		for (Seat temp : seatsInCart){
		customer.addSeat(temp);
		}
		return true;
	}
}


