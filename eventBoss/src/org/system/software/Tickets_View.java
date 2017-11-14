package org.system.software;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import org.system.event.Seat;
import org.system.event.Event;
import org.system.event.Venue;
import org.system.people.Customer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Tickets_View extends JFrame {
	private static final long serialVersionUID = 1L;

	public Tickets_View(Customer cust, Venue venueOut) 
	{
		setTitle("EventBoss-View Tickets");
		String str=null;

		//set up window

		setSize(500, 400);
		
		setLocationRelativeTo(null);
		
		JButton Back = new JButton("Exit");
		
		JTextPane textPane= new JTextPane();
		
		//initial class values to print venue/event info. based on first element in seatsInCart
		if (cust.getSeatsPurchased().isEmpty()){
		    str=("No tickets purchased.");
    		textPane.setText(str);
		}else{
	        Seat seat = cust.getSeatsPurchased().get(0);
	        Event event = seat.getSeatEvent();
	        Venue venue = event.getEventVenue();
	        
	        //display event, venue
	        str = ( event.getTitle() + "\n" + venue.getVenueName() +"\n");
	        //textPane.setText(str);
	        
	        DecimalFormat df = new DecimalFormat("#.00");
	        
	        for(Seat s: cust.getSeatsPurchased()){//iterate through ticket list
	        	str = str +( "Sect: " + s.getSectionNum() +"    " +"   Row: " + s.getRowNum()+ "    "+ "   Seat: " + s.getSeatNum() 
	                 + "    $" + df.format(s.getSeatPrice()) +"\n" );
        		textPane.setText(str);
        	}
		}
				
		JScrollPane scrollPane = new JScrollPane(textPane);
		//JScrollPane jsp = new JScrollPane(textPane);
		//group layout for the window
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(176)
							.addComponent(Back, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(Back, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		
		scrollPane.setViewportView(textPane);
		textPane.setFont(new Font("verdana", Font.PLAIN, 16));
		textPane.setForeground(Color.BLACK);
		
		textPane.setEditable(false);
		getContentPane().setLayout(groupLayout);
		
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home(cust,venueOut).setVisible(true);
				dispose();
			}
		});
	}
}
