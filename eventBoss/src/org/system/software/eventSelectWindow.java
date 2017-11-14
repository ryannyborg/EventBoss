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
import org.system.people.Customer;
import javax.swing.GroupLayout.Alignment;

public class eventSelectWindow extends JFrame {
	/* Insert Variables Here */
	
		public JFrame eventSelectWindowFrame = new JFrame();
	
	// event variables
		private JComboBox eventDD;
		private JLabel eventLabel;
		private JButton eventButton;
		private JPanel eventPanel;
		private String[] eventContent = { };
		private ArrayList<Event> eventList = new ArrayList<Event>();
		
	// button variables
		private JPanel buttonPanel;
		private JButton menuButton;
		private JButton selectSeatsButton;
		
		private Venue venue;
		private Customer customer;

	
	/* CONSTRUCTOR */

	public eventSelectWindow(Venue venue, Customer human){
		eventSelectWindowFrame = new JFrame("EventBoss - Select Event");
		
		eventSelectWindowFrame.setSize(900,200);
		
		eventSelectWindowFrame.setLocationRelativeTo(null);
		
		eventSelectWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		eventSelectWindowFrame.getContentPane().setLayout(new GridLayout(2,1));
		
		eventContent = getEventContent(venue);
		eventList = getEventList(venue);
		
		// for buttons
		this.venue = venue;
		this.customer = human;
		
		buildEventPanel();
		buildButtonPanel();
	
		eventPanel.setBackground(Color.WHITE);
		eventSelectWindowFrame.getContentPane().add(eventPanel);
		
		buttonPanel.setBackground(Color.WHITE);
		eventSelectWindowFrame.getContentPane().add(buttonPanel);
		GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
		gl_buttonPanel.setHorizontalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addGap(332)
					.addComponent(menuButton)
					.addGap(5)
					.addComponent(selectSeatsButton))
		);
		gl_buttonPanel.setVerticalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_buttonPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(menuButton)
						.addComponent(selectSeatsButton)))
		);
		buttonPanel.setLayout(gl_buttonPanel);
	
		eventSelectWindowFrame.setVisible(true);
	}
	
	
	/* SET EVENT DROPDOWN CONTENT */
	public String[] getEventContent(Venue venue){
		ArrayList<Event> eventList = venue.getEventList();
		int i = 0;
		int numEvents = eventList.size();
		String[] eventString = new String[numEvents];
		String tempTitle = "";
		String tempTime = "";
		
		for(i=0;i<numEvents;i++){
			tempTitle = eventList.get(i).getTitle();
			tempTime = eventList.get(i).getEventTime().timeString();
			eventString[i] = tempTitle + " " + tempTime;
		}
		
		return eventString;
	}
	
	/* INCOMING MESSAGE......
	 * PLEASE READ BECAUSE I'LL ONLY SAY IT ONCE....
	 * JAVA DEVELOPERS DONE SCREWED UP WITH THIS ONE....
	 * THANKS FOR INCLUDING THE PAIR FUNCTION...
	 * BECAUSE YOU WANT ME TO CREATE ANOTHER ONE OF THE SAME FUNCTIONS....
	 * TO RETURN A DIFFERENT VARIABLE.....
	 * TO YOU, THANKS....
	 */
	public ArrayList<Event> getEventList(Venue venue){
		ArrayList<Event> eventList = venue.getEventList();
		int i = 0;
		int numEvents = eventList.size();
		String[] eventString = new String[numEvents];
		String tempTitle = "";
		String tempTime = "";
		
		for(i=0;i<numEvents;i++){
			tempTitle = eventList.get(i).getTitle();
			tempTime = eventList.get(i).getEventTime().timeString();
			eventString[i] = tempTitle + " " + tempTime;
		}
		
		return eventList;
	}
	
	
	
	/* SET BUILD FUNCTIONS */
	
	public void buildEventPanel(){
		eventPanel = new JPanel();
		
		eventDD = new JComboBox(eventContent);
		
		eventLabel = new JLabel("<HTML><center>Which event would you like to attend?<BR></center></HTML>");
		
		eventPanel.add(eventLabel);
		eventPanel.add(eventDD);

	}
	
	public void buildButtonPanel(){
		buttonPanel = new JPanel();
		
		menuButton = new JButton("Main Menu");
		selectSeatsButton = new JButton("Select Seats");
		
		// add button functionality
		menuButton.addActionListener(new MenuButtonListener());
		selectSeatsButton.addActionListener(new SelectSeatsButtonListener());
	}

	
	/* BUTTON LISTENERS */
	private class SelectSeatsButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			Event eventPicked;
			int selection = (int) eventDD.getSelectedIndex();
			
			eventPicked = eventList.get(selection);
			
			eventSelectWindowFrame.dispose();
			new seatSelectWindow(venue, eventPicked, customer);
		}
	}
	
	private class MenuButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			// do nothing... yet.
			eventSelectWindowFrame.dispose();
			new Home(customer, venue).setVisible(true);
		}
	}
	
	
}
