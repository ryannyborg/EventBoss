package org.system.software;
import java.util.ArrayList;

import org.system.event.*;
import org.system.people.*;
import org.system.software.System;

public class EventBoss {
	public static void main(String[] args)
	{
		PaymentInfo card = new PaymentInfo();
		
		Address gilaRiverAddress = new Address("9400 W Maryland Ave", "Glendale", "AZ", "United States", "85305");
		
		// Convention for new venue to create a venue:
		// Venue(String venueName, Address venueAddress, int numLevels, int numSectionsPerLevel, int numRows, int numSeatsPerRow)
		Venue gilaRiver = new Venue("Gila River Arena", gilaRiverAddress, 2, 52, 8, 6); // fix numLevels
		
		
		Time coyotesVsFlamesTime = new Time(12,8,2016,7,"00","PM");
		Event coyotesVsFlames = new Event("Arizona Coyotes vs. Calgary Flames", coyotesVsFlamesTime, 
				"Hockey Game", gilaRiver);
		Time coyotesVsPredsTime = new Time(12,10,2016,7,"30","PM");
		Event coyotesVsPreds = new Event("Arizona Coyotes vs. Nashville Predators", coyotesVsPredsTime, 
				"Hockey Game", gilaRiver);
		Time coyotesVsOilersTime = new Time(12,21,2016,7,"30","PM");
		Event coyotesVsOilers = new Event("Arizona Coyotes vs. Edmonton Oilers", coyotesVsOilersTime, 
				"Hockey Game", gilaRiver);
		Time transSiberianTime = new Time(12,26,2016,8,"00","PM");
		Event transSiberian = new Event("Trans-Siberian Orchestra", transSiberianTime,
				"Concert", gilaRiver);
		Time redHotTime = new Time(3,4,2017,8,"00","PM");
		Event redHot = new Event("Red Hot Chili Peppers", redHotTime, "Concert", gilaRiver);
		
		Address customerAddress = new Address("1303 E University Blvd.", "Tucson", "AZ", "United States", "85719");
		
		Customer customer = new Customer("Ryan Nyborg", customerAddress, "(520) 123-4568", "rnyborg@email.arizona.edu", card);
		String user = "rnyborg";
		char[] password={'1','2','3','4','5','6'};
		Account account= new Account(user, password, customer);//create new account 
		System.cus.add(account);
		System.customers.add(customer);
		
		new login(gilaRiver); // venue, customer
		
		
		/* TEMP COMMENT OUT */
		//new eventSelectWindow(gilaRiver);
		
		/* TEMP COMMENT OUT */
		//new seatSelectWindow(gilaRiver, coyotesVsDucks); // open this later for GUI
	}
}
