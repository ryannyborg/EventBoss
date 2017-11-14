package org.system.event;

import java.util.ArrayList;

import org.system.people.Customer;

public class Event extends Venue{

	//attributes
	String title;
	Time eventTime;
	String description;
	Venue eventVenue;
	ArrayList<Seat> seatList = new ArrayList<Seat>();
	
	//constructors
	public Event() {
		this.title = "NULL";
	//  this.eventTime = new Time();
		this.description = "NULL";
	//	this.eventVenue = new Venue();
	}
	
	public Event(String title, Time eventTime, String description, Venue eventVenue) {
		this.title = title;
		this.eventTime = eventTime;
		this.description = description;
		this.eventVenue = eventVenue;
		assignSeats();
		addEventToArena(eventVenue);
	}

	//getters and setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Time getEventTime() {
		return eventTime;
	}
	public void setEventTime(Time eventTime) {
		this.eventTime = eventTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Venue getEventVenue() {
		return eventVenue;
	}
	public void setEventVenue(Venue eventVenue) {
		this.eventVenue = eventVenue;
	}
	
//	public void setEventToSeats(){
//		eventVenue.assignSeats(this);
//	}
	
	public void addEventToArena(Venue eventVenue){
		eventVenue.addEvent(this);
	}
	
	
	/* TO ASSIGN SEATS */
	public void assignSeats(){
		int secL=101; // for lower level sections
		int secU=201; // for upper level sections
		int row=1; // for rows
		int seat=1; //for seats

		double price = 0.00;
		Customer human = new Customer();
		Seat temp;
		//eventList.add(eventToAdd);

		
//		for(j=0;j<seatListofList.size();j++){
//			Event temp = seatListofList.get(j).get(0).getSeatEvent();
//			if(temp == eventToAdd){
//				seatList = seatListofList.get(j);
//			}
//		}
		
		numRows = eventVenue.getNumRows();
		numSeatsPerRow = eventVenue.getNumSeatsPerRow();
		ListofListCounter = 0;
	
		/* Edit Lower Level Matrix */
		for(secL=101;secL<=122;secL++){ //Section
			for(row=1;row<=numRows;row++){ //Row
				for(seat=1;seat<=numSeatsPerRow;seat++){ //Seat
					price = findPrice(secL);
					temp = new Seat(secL,row,seat,price,human,true,false,this);
					seatList.add(temp);
				}
			}
		}
		
		/* Edit Upper Level Matrix */
		for(secU=201;secU<=230;secU++){
			for(row=1;row<=numRows;row++){ //Row
				for(seat=1;seat<=numSeatsPerRow;seat++){ //Seat
					price = findPrice(secU);
					temp = new Seat(secU,row,seat,price,human,true,false,this);
					seatList.add(temp);
				}
			}
		}
		
		capacity = seatList.size();
	}
	
	
	/* SEARCH BY SECTION */
	public ArrayList<Seat> searchSection(int sectionDesired, int quantity, Event event){
		ArrayList<Seat> notFound = new ArrayList<Seat>();
		ArrayList<Seat> returnList = new ArrayList<Seat>();
		int i=0; // iterator for the arrayList
		int j=0; // iterator for seatlistoflist
		boolean tempAvailable = false;
		boolean tempOnHold = true;
		int tempSection = -1;
	
		
		/* Rest OnHold for button press */
		for(i=0;i<capacity;i++){
			seatList.get(i).setOnHold(false); // puts the seat "on hold"
		}
		
		int counter = 0;
		
		/* Search ArrayList */
		for(i=0;i<capacity;i++){ //Section
			tempAvailable = seatList.get(i).isAvailable;
			tempOnHold = seatList.get(i).onHold;
			tempSection = seatList.get(i).getSectionNum();
			if(tempAvailable == true && tempOnHold == false && tempSection == sectionDesired){
				returnList.add(seatList.get(i));
				seatList.get(i).setOnHold(true); // puts the seat "on hold"
				counter++;
				if(counter == quantity){
					break;
				}
			}
		}
		
		if(!returnList.isEmpty()){
			return returnList;
		}
		
		else{
			return notFound; // ERROR!
		}
		
	}
	
	
	/* SEARCH BY PRICE */
	// make this into an arrayList return function
	public ArrayList<Seat> searchPrice(int upperBound, int lowerBound, int quantity){
		ArrayList<Seat> notFound = new ArrayList<Seat>();
		ArrayList<Seat> returnList = new ArrayList<Seat>();
		int i=0; // iterator for the arrayList
		boolean tempAvailable = false;
		boolean tempOnHold = true;
		double tempPrice = -1.0;
		
		int counter = 0;
		
		/* Rest OnHold for button press */
		for(i=0;i<capacity;i++){
			seatList.get(i).setOnHold(false); // puts the seat "on hold"
		}
		
		
		/* Search ArrayList */
		for(i=0;i<capacity;i++){ //Section
			tempAvailable = seatList.get(i).isAvailable;
			tempOnHold = seatList.get(i).onHold;
			tempPrice = seatList.get(i).getSeatPrice();
			if(tempAvailable == true && tempOnHold == false && tempPrice < upperBound && tempPrice >= lowerBound){
				returnList.add(seatList.get(i));
				seatList.get(i).setOnHold(true); // puts the seat "on hold"
				counter++;
				if(counter == quantity){
					break;
				}
			}
		}
		
		if(!returnList.isEmpty()){
			return returnList;
		}
		
		else{
			return notFound; // ERROR!
		}
		
	}
	
	
	
}
