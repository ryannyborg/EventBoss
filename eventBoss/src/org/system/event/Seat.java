package org.system.event;

import org.system.people.Customer;

public class Seat{
	
	//attributes
	int sectionNum;
	int rowNum;
	int seatNum;
	double seatPrice;
	Customer seatHolder;
	boolean isAvailable;//true=available; false=sold/unavailable
	boolean onHold; //true = not available to be searched; false = available to be searched
	Event seatEvent;
	
	public Seat() {
		this.sectionNum = -1;
		this.rowNum = -1;
		this.seatNum = -1;
		this.seatPrice = -1;
		this.seatHolder = new Customer();
		this.isAvailable = false;
		this.seatEvent = new Event();
	}

	public Seat(int sectionNum, int rowNum, int seatNum, double seatPrice, 
			Customer seatHolder, boolean isAvailable, boolean onHold, Event seatEvent) {
		this.sectionNum = sectionNum;
		this.rowNum = rowNum;
		this.seatNum = seatNum;
		this.seatPrice = seatPrice;
		this.seatHolder = seatHolder;
		this.isAvailable = isAvailable;
		this.onHold = onHold;
		this.seatEvent = seatEvent;
	}

	public int getSectionNum() {
		return sectionNum;
	}
	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public double getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}
	public Customer getSeatHolder() {
		return seatHolder;
	}
	public void setSeatHolder(Customer seatHolder) {
		this.seatHolder = seatHolder;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public boolean onHold(){
		return onHold;
	}
	public void setOnHold(boolean onHold){
		this.onHold = onHold;
	}
	public Event getSeatEvent() {
		return seatEvent;
	}
	public void setSeatEvent(Event seatEvent) {
		this.seatEvent = seatEvent;
	}
	
	
}
