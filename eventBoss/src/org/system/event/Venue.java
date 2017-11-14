package org.system.event;

import java.util.ArrayList;

import org.system.people.*;

public class Venue {
	private String venueName;
	private Address venueAddress;
	protected double capacity; // don't need this as a constructor requirement
	private int numLevels;
	private int numSections;
	protected int numRows;
	protected int numSeatsPerRow;
	//private ArrayList<Seat> seatList = new ArrayList<Seat>();
	private ArrayList<Event> eventList = new ArrayList<Event>();
	protected int ListofListCounter = 0;
	
	//constructors
	public Venue(){
		this.venueName = "NULL";
		this.venueAddress = new Address();
		this.capacity = -1;
		this.numLevels = -1;
		this.numSections = -1;
		this.numRows = -1;
		this.numSeatsPerRow = -1;		
	}
	
	public Venue(String venueName, Address venueAddress, int numLevels, 
			int numSections, int numRows, int numSeatsPerRow){
		//ArrayList<Seat> seatListLocal = new ArrayList<Seat>();
		
		this.venueName = venueName;
		this.venueAddress = venueAddress;
		this.numLevels = numLevels;
		this.numSections = numSections;
		this.numRows = numRows;
		this.numSeatsPerRow = numSeatsPerRow;	
		// seatListLocal = assignSeats();
		// seatListofList.add(seatListLocal);
	}
	
	

	//getters and setters
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public Address getVenueAddress() {
		return venueAddress;
	}
	public void setVenueAddress(Address venueAddress) {
		this.venueAddress = venueAddress;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public int getNumLevels() {
		return numLevels;
	}
	public void setNumLevels(int numLevels) {
		this.numLevels = numLevels;
	}
	public int getNumSections() {
		return numSections;
	}
	public void setNumSections(int numSections) {
		this.numSections = numSections;
	}

	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public int getNumSeatsPerRow() {
		return numSeatsPerRow;
	}

	public void setNumSeatsPerRow(int numSeatsPerRow) {
		this.numSeatsPerRow = numSeatsPerRow;
	}
	
	/* ASSIGN EVENTS TO AN ARRAY LIST */
	public void addEvent(Event event){
		eventList.add(event);
	}
	
	public ArrayList<Event> getEventList(){
		return eventList;
	}
	
	
//	/* ASSIGN SEATS TO SECTION, ROW, SEATNUM, PRICE*/
//	// CREATE SEAT MATRIX
//	public ArrayList<Seat> assignSeats(){
//		int secL=101; // for lower level sections
//		int secU=201; // for upper level sections
//		int row=1; // for rows
//		int seat=1; //for seats
//		double price = 0.00;
//		Customer human = new Customer();
//		Event event = new Event();
//		Seat temp;
//		
//		ArrayList<Seat> seatList = new ArrayList<Seat>();
//		
//		
//		/* Create Lower Level Matrix */
//		for(secL=101;secL<=122;secL++){ //Section
//			for(row=1;row<=numRows;row++){ //Row
//				for(seat=1;seat<=numSeatsPerRow;seat++){ //Seat
//					price = findPrice(secL);
//					temp = new Seat(secL,row,seat,price,human,true,false,event);
//					seatList.add(temp);
//				}
//			}
//		}
//		
//		/* Create Upper Level Matrix */
//		for(secU=201;secU<=230;secU++){
//			for(row=1;row<=numRows;row++){ //Row
//				for(seat=1;seat<=numSeatsPerRow;seat++){ //Seat
//					price = findPrice(secU);
//					temp = new Seat(secU,row,seat,price,human,true,false,event);
//					seatList.add(temp);
//				}
//			}
//		}
//		
//		capacity = seatList.size();
//
//		
//		return seatList;
//	}
	
	
	/* FINDS PRICE FOR SECTION */
	public double findPrice(int sectionNum){
		double price = 0.00;
	
		if(sectionNum == 101 || sectionNum == 122 || sectionNum == 201 || sectionNum == 230){
			price = 150.00; // $150 for any seat in these sections
		}
		else if(sectionNum == 102 || sectionNum == 110 || sectionNum == 113 || sectionNum == 121){
			price = 100.00; // $100 for any seat in these sections
		} 
		else if(sectionNum == 103 || sectionNum == 104 || sectionNum == 105 || sectionNum == 106 ||
				sectionNum == 107 || sectionNum == 108 || sectionNum == 109 || sectionNum == 114 ||
				sectionNum == 115 || sectionNum == 116 || sectionNum == 117 || sectionNum == 118 || 
				sectionNum == 119){
			price = 75.00; // $75 for any seat in these sections
		}
		else if(sectionNum == 201 || sectionNum == 215 || sectionNum == 216 || sectionNum == 230){
			price = 50.00; // $50 for any seat in these sections
		}
		else if(sectionNum == 202 || sectionNum == 203 || sectionNum == 213 || sectionNum == 214 ||
				sectionNum == 217 || sectionNum == 218 || sectionNum == 228 || sectionNum == 229 ||
				sectionNum == 204 || sectionNum == 213 || sectionNum == 219 || sectionNum == 227){
			price = 30.00; // $30 for any seat in these sections
		}
		else if(sectionNum == 205 || sectionNum == 206 || sectionNum == 207 || sectionNum == 208 ||
				sectionNum == 209 || sectionNum == 210 || sectionNum == 211 || sectionNum == 220 ||
				sectionNum == 221 || sectionNum == 222 || sectionNum == 223 || sectionNum == 224 || 
				sectionNum == 225 || sectionNum == 226){
			price = 15.00; // $15 for any seat in these sections
		}
		else{
			// invalid section
			price = 1000000; // $1,000,000 if we made a mistake
		}
		
		return price;
	}
	
	
//	public void assignSeats(Event eventToAdd){
//		int secL=101; // for lower level sections
//		int secU=201; // for upper level sections
//		int row=1; // for rows
//		int seat=1; //for seats
//		int i = 0; // iterator to edit each seat in arrayList
//
//		double price = 0.00;
//		Customer human = new Customer();
//		Event event = new Event();
//		Seat temp;
//		
//		ArrayList<Seat> seatList = new ArrayList<Seat>();
//		
//		
//		//eventList.add(eventToAdd);
//		
//		ArrayList<Seat> seatListLocal = new ArrayList<Seat>();
//		
////		for(j=0;j<seatListofList.size();j++){
////			Event temp = seatListofList.get(j).get(0).getSeatEvent();
////			if(temp == eventToAdd){
////				seatList = seatListofList.get(j);
////			}
////		}
//		
//	
//		/* Edit Lower Level Matrix */
//		for(secL=101;secL<=122;secL++){ //Section
//			for(row=1;row<=numRows;row++){ //Row
//				for(seat=1;seat<=numSeatsPerRow;seat++){ //Seat
//					price = findPrice(secL);
//					temp = new Seat(secL,row,seat,price,human,true,false,event);
//					seatList.add(temp);
//					seatListofList.get(ListofListCounter).get(i).setSeatEvent(eventToAdd);
//					i++;
//				}
//			}
//		}
//		
//		/* Edit Upper Level Matrix */
//		for(secU=201;secU<=230;secU++){
//			for(row=1;row<=numRows;row++){ //Row
//				for(seat=1;seat<=numSeatsPerRow;seat++){ //Seat
//					price = findPrice(secU);
//					temp = new Seat(secU,row,seat,price,human,true,false,event);
//					seatList.add(temp);
//					seatListofList.get(ListofListCounter).get(i).setSeatEvent(eventToAdd);
//					i++;
//				}
//			}
//		}
//		
//		ListofListCounter++;
//		
//		capacity = seatList.size();
//	}
	
	
	
	public int calculateSeatsAvailable(){
		return 0;//XXXXXXXXXXXXXXXFIX
	}
	
}

