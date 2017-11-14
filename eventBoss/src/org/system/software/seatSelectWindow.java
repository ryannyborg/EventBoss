package org.system.software;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import org.system.event.*;
import org.system.event.Event;
import org.system.people.Cart;
import org.system.people.Customer;

public class seatSelectWindow extends JFrame {
	
	public JFrame seatSelectWindowFrame = new JFrame();
	
	// venue variables
	private JLabel venueLabel;
	private JButton venueMapButton;
	private JPanel venuePanel;
	private JLabel venueImage;
	
	// quantity variables
	private JLabel quantityLabel;
	private JLabel quantityLabel2;
	private JPanel quantityPanel;
	private JComboBox quantityDD;
	
	/* SEARCH OPTIONS VARIABLES */
	
	private JPanel searchOptionsPanel;
	
	// section variables
	private JComboBox sectionDD;
	private JLabel sectionLabel;
	private JButton searchSectionButton;
	
	// price variables
	private JLabel priceLabel;
	private JComboBox priceDD;
	private JButton searchPriceButton;
	
	/* END */
	
	// ticket variables
	private JLabel ticketsLabel;
	private JButton addTickets;
	private JPanel ticketsPanel;
	
	// back and main menu buttons
	private JButton backButton;
	private JButton homeButton;
	private JPanel utilityPanel;
	
	// ticket logo variables
	private JPanel logoPanel;
	private JLabel logoLabel;
	private JLabel eventSelectedLabel;
	
	// search section button variables
	public Venue venueToSearch;
	public Event eventToSearch;
	public Customer customer;
	
	// The values stored in the quantity dropdown menu
	private String[] quantityNumbers = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10" };
	
	// The values stored in the section dropdown menu
	private String[] sectionNumbers = { "101", "102", "103", "104", "105", "106",
			"107", "108", "109", "110", "111", "112", "113", "114", "115", "116",
			"117", "118", "119", "120", "121", "122", "201", "202", "203", "204",
			"205", "206", "207", "208", "209", "210", "211", "212", "213", "214",
			"215", "216", "217", "218", "219", "220", "221", "222", "223", "224",
			"225", "226", "227", "228", "229", "230"};
	
	// The values stored in the price dropdown menu
	private String[] priceNumbers = { "< $20", "$20-$50", "$50-$75", "$75-$125", "$125 >"};
	
	// Overall variable to store the seatsPicked by a search
	private ArrayList<Seat> seatsFromSearch = new ArrayList<Seat>();
	
	/* CONTRUCTOR */
	public seatSelectWindow(Venue venue, Event event, Customer human){
		seatSelectWindowFrame = new JFrame("EventBoss - Select Seats");
		
		seatSelectWindowFrame.setSize(900,480);
		
		seatSelectWindowFrame.setLocationRelativeTo(null);
		
		seatSelectWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		seatSelectWindowFrame.setLayout(new GridLayout(2,3));
		
		// variables for search by section or price button
		venueToSearch = venue;
		eventToSearch = event;
		customer = human;
	
		buildVenuePanel();
		buildQuantityPanel();
		buildSearchOptionsPanel();
		buildTicketsPanel();
		buildUtilityPanel();
		buildLogoPanel();
		
		venuePanel.setBackground(Color.WHITE);
		seatSelectWindowFrame.add(venuePanel);
		
		quantityPanel.setBackground(Color.WHITE);
		seatSelectWindowFrame.add(quantityPanel);
	
		searchOptionsPanel.setBackground(Color.WHITE);
		seatSelectWindowFrame.add(searchOptionsPanel);
		
		ticketsPanel.setBackground(Color.WHITE);
		seatSelectWindowFrame.add(ticketsPanel);
		
		logoPanel.setBackground(Color.WHITE);
		seatSelectWindowFrame.add(logoPanel);
		
		utilityPanel.setBackground(Color.WHITE);
		seatSelectWindowFrame.add(utilityPanel);
		
		
		
		seatSelectWindowFrame.setVisible(true);
	}
	
	
	/* BUILD FUNCTIONS */
	private void buildVenuePanel(){
		venuePanel = new JPanel();
		
		venueLabel = new JLabel("Venue: Gila River Arena"); // make DYNAMIC
		venueLabel.setFont(new Font("verdana", Font.BOLD, 20));
		venueLabel.setForeground(Color.BLACK);
		
		venueMapButton = new JButton("View Venue Map");
		
		venueMapButton.addActionListener(new viewMapButtonListener());
		
		
		
		try{
			String path = "http://s1.evcdn.com/images/block/I0-001/004/401/312-2.jpeg_/gila-river-arena-formerly-jobingcom-arena-12.jpeg";
			URL	url = new URL(path);
			BufferedImage image = ImageIO.read(url);
			venueImage = new JLabel(new ImageIcon(image));
			
			venuePanel.add(venueImage);
		}
		catch(Exception exp){
			exp.printStackTrace();
			JOptionPane.showMessageDialog(null, 
					"Unable to connect to the Internet or URL not located.", 
					"Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	
		venuePanel.add(venueLabel);
		venuePanel.add(venueMapButton);
	}
	
	private void buildQuantityPanel(){
		quantityPanel = new JPanel();
		
		quantityDD = new JComboBox(quantityNumbers);
		
		// add quantity functionality
		// searchSectionButton.addActionListener(new SearchSectionListener());
		
		quantityLabel = new JLabel("<HTML><center>Number of Tickets? </center></HTML>");
		quantityLabel2 = new JLabel("<HTML><center>Need more than 10 tickets?"
				+ "<BR><BR>Visit our box office at: <BR>" + venueToSearch.getVenueAddress().getFirstAddress() 
				+ "<BR>" + venueToSearch.getVenueAddress().getSecondAddress() + "<BR>" + venueToSearch.getVenueAddress().getThirdAddress()
				+ "</center></HTML>");
		quantityPanel.add(quantityLabel);
		quantityPanel.add(quantityDD);
		quantityPanel.add(quantityLabel2);
	}
	
	private void buildSearchOptionsPanel(){
		searchOptionsPanel = new JPanel();
		buildSectionsPanel();
		buildPricePanel();
	}
	
	private void buildSectionsPanel() {
		
		sectionDD = new JComboBox(sectionNumbers);
		searchSectionButton = new JButton("Search By Section");
		
		searchSectionButton.addActionListener(new SearchSectionListener());
		
		sectionLabel = new JLabel("<HTML><center>Please Select A Section: </center></HTML>");
		
		searchOptionsPanel.add(sectionLabel);
		searchOptionsPanel.add(sectionDD);
		searchOptionsPanel.add(searchSectionButton);
	}
	
	private void buildPricePanel() {
		
		priceDD = new JComboBox(priceNumbers);
		searchPriceButton = new JButton("Search By Price");
		
		searchPriceButton.addActionListener(new SearchPriceListener());
		
		priceLabel = new JLabel("<HTML><center><BR>Please Select A Price Range: </center></HTML>");
		
		searchOptionsPanel.add(priceLabel);
		searchOptionsPanel.add(priceDD);
		searchOptionsPanel.add(searchPriceButton);
	}

	private void buildMapPanel(){
		
		try{
			String path = "http://1.cdn.nhle.com/coyotes/v2/ext/images/14-15-map.jpg";
			URL	url = new URL(path);
			BufferedImage image = ImageIO.read(url);
			JLabel label = new JLabel(new ImageIcon(image));
			JFrame map = new JFrame("Seating Chart");
			JPanel mapPanel = new JPanel();
			JButton closeButton = new JButton("Close");
			
			closeButton.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e)
			    {
			       map.dispose();
			    }
			});
			
			mapPanel.add(label);
			mapPanel.add(closeButton);
			
		// insert some functionality for the close button

		
			map.add(mapPanel);
			map.setSize(780, 690);
			map.setResizable(true);
			map.setVisible(true);
		}
		catch(Exception exp){
			exp.printStackTrace();
			JOptionPane.showMessageDialog(null, 
					"Unable to connect to the Internet or URL not located.", 
					"Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void buildTicketsPanel(){
		ticketsPanel = new JPanel();
		
		addTickets = new JButton("Add Selected Tickets to Cart");
	
		addTickets.addActionListener(new AddTicketsListener());
		
		ticketsLabel = new JLabel("<HTML><center>Please select a search option above.</center></HTML>");
		
		ticketsPanel.add(ticketsLabel);
		ticketsPanel.add(addTickets);
	}
	
	public void buildUtilityPanel(){
		utilityPanel = new JPanel();
		
		backButton = new JButton("Back");
		homeButton = new JButton("Main Menu");
	
		backButton.addActionListener(new backButtonListener());
		homeButton.addActionListener(new homeButtonListener());
		
		utilityPanel.add(backButton);
		utilityPanel.add(homeButton);
	}
	
	public void buildLogoPanel(){
		try{
			String path = "http://www.iconsplace.com/icons/preview/orange/ticket-64.png";
			URL	url = new URL(path);
			BufferedImage image = ImageIO.read(url);
			logoLabel = new JLabel(new ImageIcon(image));
			
			String eventInfo = "<HTML><center><BR>Event Selected:<BR>" + eventToSearch.getTitle() + "<BR>" 
					+ eventToSearch.getEventTime().timeString() + "</center></HTML>";
			eventSelectedLabel = new JLabel(eventInfo);
					
					
			logoPanel = new JPanel();
			
			logoPanel.add(logoLabel);
			logoPanel.add(eventSelectedLabel);
		}
		catch(Exception exp){
			exp.printStackTrace();
			JOptionPane.showMessageDialog(null, 
					"Unable to connect to the Internet or URL not located.", 
					"Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/*******************************************************************/
	
	/* BUTTON LISTENERS */
	private class viewMapButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			buildMapPanel();
		}
	}
	
	private class SearchSectionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// FIX ME TO SEARCH BEST AVAILABLE BY SECTION
			
			ArrayList<Seat> seatsPicked = new ArrayList<Seat>();
			
			int sectionNumber = 0; // by default
			int quantityNumber = 0;
			int i = 0;
			
			String selection = (String) sectionDD.getSelectedItem();
			String quantitySelection = (String) quantityDD.getSelectedItem();
			sectionNumber = stringToInt(selection);
			quantityNumber = stringToInt(quantitySelection);
			
			String strForLabel = "";
			String beginningStr = "<HTML><center>Selected Tickets:<BR>";
			
			boolean error = false;
			
			for(i=0;i<quantityNumber;i++){
				
				seatsPicked = searchSection(sectionNumber, quantityNumber, eventToSearch);
				seatsFromSearch = seatsPicked;
				
				if (seatsPicked.get(i).getSectionNum() == -1){
					// ERROR!
					ticketsLabel.setText("<HTML><center>Sorry, tickets for this section are unavailable!</center></HTML>");
					error = true;
					break;
				}
				else{
					// SHOULD... keep adding on longer label
					strForLabel = strForLabel + "<BR>Section: " 
							+ seatsPicked.get(i).getSectionNum() + " Row: " + seatsPicked.get(i).getRowNum() + " Seat: " 
							+ seatsPicked.get(i).getSeatNum();
				}
			}
			
			
			if(error == false){
				ticketsLabel.setText(beginningStr + strForLabel + "<BR></center></HTML>" );
			}
			
			
			
		}
	}
	
	private class SearchPriceListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// FIX ME TO SEARCH BEST AVAILABLE BY PRICE
			ArrayList<Seat> seatsPicked = new ArrayList<Seat>();
			
			int quantityNumber = 0;
			int i = 0;
			
			String selection = (String) priceDD.getSelectedItem();
			String quantitySelection = (String) quantityDD.getSelectedItem();
			quantityNumber = stringToInt(quantitySelection);
			
			String strForLabel = "";
			String beginningStr = "<HTML><center>Selected Tickets:<BR>";
			
			boolean error = false;
			
			for(i=0;i<quantityNumber;i++){
				
				seatsPicked = searchPrice(selection, quantityNumber);
				seatsFromSearch = seatsPicked;
				
				if (seatsPicked.get(i).getSectionNum() == -1){
					// ERROR!
					ticketsLabel.setText("<HTML><center>Sorry, tickets for this section are unavailable!</center></HTML>");
					error = true;
					break;
				}
				else{
					// SHOULD... keep adding on longer label
					strForLabel = strForLabel + "<BR>Section: " 
							+ seatsPicked.get(i).getSectionNum() + " Row: " + seatsPicked.get(i).getRowNum() + " Seat: " 
							+ seatsPicked.get(i).getSeatNum();
				}
			}
			
			
			if(error == false){
				ticketsLabel.setText(beginningStr + strForLabel + "<BR></center></HTML>" );
			}
			
		}
	}
	
	private class AddTicketsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// FIX ME TO MOVE TO CART WINDOW
			if(!seatsFromSearch.isEmpty()){
				// add seat to customer
				int j = 0;
				
				// add the seats to the customer
				for(j=0;j<seatsFromSearch.size();j++){
					//  Cart(double taxRate, ArrayList<Seat> seatsInCart, int ticketNumber)
					
				}
				
				Cart customerCart = new Cart(0.10, seatsFromSearch, 1);
				customer.setCartTotal(customerCart);
				
				seatSelectWindowFrame.setVisible(false);
				new shoppingCart(venueToSearch, eventToSearch, customer); // insert a customer, venue, seat
			}
			else{
				// do nothing here...
				JOptionPane.showMessageDialog(null, "No tickets were selected.", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private class backButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// TO MOVE EVENTS (PREVIOUS) WINDOW
			seatSelectWindowFrame.dispose();
			new eventSelectWindow(venueToSearch, customer);
		}
	}
	
	private class homeButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// TO MOVE TO MAIN MENU WINDOW
			seatSelectWindowFrame.dispose();
			new Home(customer, venueToSearch).setVisible(true);
		}
	}
	 
	/*******************************************************************/
	
	/* ADDITIONAL FUNCTIONS */
	public int stringToInt(String string){
		int result = Integer.parseInt(string);
		return result;
	}
	
	public ArrayList<Seat> searchSection(int sectionNumber, int quantity, Event event){
		ArrayList<Seat> temp = eventToSearch.searchSection(sectionNumber, quantity, event);
		return temp;
	}
	
	public ArrayList<Seat> searchPrice(String string, int quantity){
		
		int upperBound = 0;
		int lowerBound = 0;
		ArrayList<Seat> notFound = new ArrayList<Seat>();
	
		
		if(string == "< $20"){
			upperBound = 20;
			lowerBound = 0;
			ArrayList<Seat> temp = eventToSearch.searchPrice(upperBound, lowerBound, quantity);
			return temp;
		}
		else if(string == "$20-$50"){
			upperBound = 50;
			lowerBound = 20;
			ArrayList<Seat> temp = eventToSearch.searchPrice(upperBound, lowerBound, quantity);
			return temp;
		}
		else if(string == "$50-$75"){
			upperBound = 75;
			lowerBound = 50;
			ArrayList<Seat> temp = eventToSearch.searchPrice(upperBound, lowerBound, quantity);
			return temp;
		}
		else if(string == "$75-$125"){
			upperBound = 125;
			lowerBound = 75;
			ArrayList<Seat> temp = eventToSearch.searchPrice(upperBound, lowerBound, quantity);
			return temp;
		}
		else if(string == "$125 >"){
			upperBound = 200; // would normally be infinity but prices don't go over $150
			lowerBound = 125;
			ArrayList<Seat> temp = eventToSearch.searchPrice(upperBound, lowerBound, quantity);
			return temp;
		}
		
		else{
			// error
			// add error handling HERE!
			return notFound;
		}
	
	}
	
	
}
