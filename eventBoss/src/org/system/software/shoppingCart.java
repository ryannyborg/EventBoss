package org.system.software;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

import org.system.event.Seat;
import org.system.event.Venue;
import org.system.people.Customer;
import org.system.people.PaymentInfo;
import org.system.event.Event;

public class shoppingCart extends JFrame {

	public JFrame shoppingCartWindowFrame = new JFrame();

	// cart variables
	private JPanel cartPanel;
	private JLabel venueLabel;
	private JLabel seatsLabel;

	// right column box
	private Box rightColumnBox = Box.createVerticalBox();;

	// subtotal variables
	private JLabel subtotalLabel;
	private JLabel totalLabel;

	// payment variables
	private JButton paymentButton;
	private JButton paymentViewButton;

	// back and main menu buttons
	private JButton backButton;
	private JButton homeButton;

	// checkout button variables
	JPanel checkoutPanel;
	private JButton checkoutButton;
	
	private Venue venue;

	// constructor//////////////////////////////////////
	public shoppingCart(Venue ven, Event ev, Customer cust) {

		super("EventBoss - Shopping Cart");
		getContentPane().setBackground(Color.WHITE);

		setSize(900, 800);
		
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(new GridLayout(1, 2));						//will be two colomns, Cart panel and rightColumnBox
		
		venue = ven;

		buildCartPanel(cust);

		// add subtotal JPanels to box
		rightColumnBox.add(buildSubtotalPanel(cust));
		
		//rightColumnBox.add(Box.createRigidArea(new Dimension (5,0)));
		//container.add(Box.createRigidArea(new Dimension(5,0)));

		buildPaymentPanel(cust);
		buildPaymentViewPanel(cust);
		buildCheckoutPanel(ven, ev, cust);
		buildUtilityPanel(ven, ev, cust);

		//cartPanel.setBackground(Color.GRAY);
		getContentPane().add(cartPanel);
		//rightColumnBox.setBackground(Color.GRAY);
		getContentPane().add(rightColumnBox);

		if (cust.getPaymentCard().getSecurityCode() == -1) {	//disables checkout and paymentinfoview if sec code == -1
			checkoutButton.setEnabled(false);
			paymentViewButton.setEnabled(false);
		}
		
		setVisible(true);

	}

	// build functions////////////////////////////
	private void buildCartPanel(Customer cust) {
		cartPanel = new JPanel(new BorderLayout());
		cartPanel.setBackground(Color.WHITE);

		Box box = Box.createVerticalBox();

		// initial class values to print venue/event info. based on first
		// element in seatsInCart
		Seat seat = cust.getCartTotal().getSeatsInCart().get(0);
		Event event = seat.getSeatEvent();
		Venue venue = event.getEventVenue();

		// display event, venue
		venueLabel = new JLabel(
				"<HTML><center>" + event.getTitle() + "<BR>" + venue.getVenueName() + "</center></HTML>");
		venueLabel.setFont(new Font("verdana", Font.BOLD, 20));
		venueLabel.setForeground(Color.BLACK);
		box.add(venueLabel);
		
		DecimalFormat df = new DecimalFormat("#.00");

		// display seat ticket information
		for (Seat s : cust.getCartTotal().getSeatsInCart()) {// iterate through// ticket list	
			
			double seatPrice = Double.valueOf(df.format(s.getSeatPrice()));
			seatsLabel = new JLabel("<HTML><left><BR>" + "Sect: " + s.getSectionNum() + "   Row: " + s.getRowNum()
					+ "   Seat: " + s.getSeatNum() + "<BR>$" + df.format(seatPrice) + "<BR>" + "</right></HTML>");
			seatsLabel.setFont(new Font("verdana", Font.PLAIN, 16));
			seatsLabel.setForeground(Color.BLACK);
			box.add(seatsLabel);
		}
		box.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		cartPanel.add(box);

	}

	private Box buildSubtotalPanel(Customer cust) {
		Box box = Box.createVerticalBox();						//builds box for price items to be added to
		
		// sets the decimal format
		DecimalFormat df = new DecimalFormat("#.00"); 
		
		double subtotal = Double.valueOf(df.format(cust.getCartTotal().calculateSubtotalAmount()));
		double taxAmount = Double.valueOf(df.format(cust.getCartTotal().calculateTaxAmount()));
		double total = Double.valueOf(df.format(cust.getCartTotal().calculateTotal()));

		// display subtotal and tax amount
		subtotalLabel = new JLabel("<HTML><left> Subtotal: $" + df.format(subtotal)
				+ "<BR>Tax: $" + df.format(taxAmount) + "<BR><BR></left></HTML>");
		subtotalLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
		subtotalLabel.setForeground(Color.BLACK);
		
		
		
		// total.setText(new DecimalFormat("##.##").format(i2));
		
		// display total
		totalLabel = new JLabel("<HTML><center> Total: $" + df.format(total) + "</center></HTML>");
		totalLabel.setFont(new Font("Verdana", Font.BOLD, 28));
		totalLabel.setForeground(new Color(204, 0, 51));

		//add both elements to box
		box.add(subtotalLabel);
		box.add(totalLabel);
		box.setAlignmentX(Component.CENTER_ALIGNMENT);

		box.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		return box;												//returns box to be added to rightColumnBox

	}

	private void buildPaymentPanel(Customer cust) {

		paymentButton = new JButton("Update Payment Information");
		paymentButton.setPreferredSize(new Dimension(300, 200));//does nothing

		paymentButton.addActionListener(new UpdatePaymentInfoListener(cust));
		paymentButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		rightColumnBox.add(paymentButton);
	}

	private class UpdatePaymentInfoListener implements ActionListener {
		private Customer cust;

		public UpdatePaymentInfoListener(Customer cust) {
			this.cust = cust;
		}

		public void actionPerformed(ActionEvent e) {
			PaymentInfo payment = new PaymentInfo();
			
			
			String[] cardChoices = { "Visa", "MasterCard", "Discover", "American Express" };
		    String[] cardtypeChoices = { "Credit", "Debit" };
		    String[] monthChoices = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		    String[] yearChoices = { "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" };
		    
			
			//joptionpanes to store all user input into payment
			payment.setCardCompany(JOptionPane.showInputDialog(null, "Please enter your Card Company",
			        "Card Company", JOptionPane.QUESTION_MESSAGE, null, cardChoices, // Array of choices
			        cardChoices[0]));
			payment.setCardType(JOptionPane.showInputDialog(null, "Please select your Card Type",
			        "Card Type", JOptionPane.QUESTION_MESSAGE, null, cardtypeChoices, // Array of choices
			        cardtypeChoices[0]));
			payment.setCardNumber(Long.parseLong(JOptionPane.showInputDialog("Please enter your Card Number")));
			
			Object temp = JOptionPane.showInputDialog(null, "Please select your Card's Expiration Month",
			        "Expiration Month", JOptionPane.QUESTION_MESSAGE, null, monthChoices, // Array of choices
			        monthChoices[0]);
			payment.setExpMonth(Integer.parseInt(temp.toString()));
			
			Object temp2 = JOptionPane.showInputDialog(null, "Please select your Card's Expiration Year",
			        "Expiration Year", JOptionPane.QUESTION_MESSAGE, null, yearChoices, // Array of choices
			        yearChoices[0]);
			payment.setExpYear(Integer.parseInt(temp2.toString()));
			
			payment.setSecurityCode(Integer.parseInt(JOptionPane.showInputDialog("Please enter your Security Code")));

			// confirm information
			int confirmed = JOptionPane.showConfirmDialog(null,
					"Card Company: " + payment.getCardCompany() + "\nCard Type: " + payment.getCardType()
							+ "\nCard Number: " + payment.getCardNumber() + "\nExp Month: " + payment.getExpMonth()
							+ "\nExp Year: " + payment.getExpYear() + "\nSecurity Code: " + payment.getSecurityCode(),
					"Is this correct?", JOptionPane.YES_NO_OPTION);

			if (confirmed == JOptionPane.YES_OPTION) {

				cust.getPaymentCard().setCardCompany(payment.getCardCompany());
				cust.getPaymentCard().setCardType(payment.getCardType());
				cust.getPaymentCard().setCardNumber(payment.getCardNumber());
				cust.getPaymentCard().setExpMonth(payment.getExpMonth());
				cust.getPaymentCard().setExpYear(payment.getExpYear());
				cust.getPaymentCard().setSecurityCode(payment.getSecurityCode());


				checkoutButton.setEnabled(true);// re enables checkout with
												// proper payment info
				paymentViewButton.setEnabled(true);
			}
		}
	}

	private void buildPaymentViewPanel(Customer cust) {
		paymentViewButton = new JButton("View Payment Information");

		paymentViewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		paymentViewButton.addActionListener(new PaymentViewListener(cust));
		rightColumnBox.add(paymentViewButton);
	}

	private class PaymentViewListener implements ActionListener {
		private Customer cust;
		private PaymentInfo payment;

		public PaymentViewListener(Customer cust) {
			this.cust = cust;
			this.payment = cust.getPaymentCard();
		}

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,
					"Card Company: " + payment.getCardCompany() + "\nCard Type: " + payment.getCardType()
							+ "\nCard Number: " + payment.getCardNumber() + "\nExp Month: " + payment.getExpMonth()
							+ "\nExp Year: " + payment.getExpYear() + "\nSecurity Code: " + payment.getSecurityCode(),
					"Current Payment Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void buildCheckoutPanel(Venue ven, Event ev, Customer cust) {
		checkoutButton = new JButton("Checkout");

		checkoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		checkoutButton.addActionListener(new CheckoutListener(ven, ev, cust));
		rightColumnBox.add(checkoutButton);

	}

	private class CheckoutListener implements ActionListener {
		private Customer cust;
		private Event ev;
		private Venue ven;
		

		public CheckoutListener(Venue ven, Event ev, Customer cust) {
			this.cust = cust;
			this.ev = ev;
			this.ven = ven;
		}

		public void actionPerformed(ActionEvent e) {
			for (Seat temp : cust.getCartTotal().getSeatsInCart()) {
				if (!temp.isAvailable()) {//if a ticket is unavailable to purchase
					JOptionPane.showMessageDialog(null, "One of your tickets was either unavailable or on hold.\nYou will be returned to the seat select menu.", 
							"Error!", JOptionPane.ERROR_MESSAGE);
					dispose();
					new seatSelectWindow(ven, ev, cust);
				}
			}
			for(Seat temp: cust.getCartTotal().getSeatsInCart()){//add seats to customer's list and mark unavailable
				cust.addSeat(temp);
				temp.setAvailable(false);
				temp.setOnHold(false);
			}
			JOptionPane.showMessageDialog(null, "Your checkout and payment was a success!\nYou will be returned to the home screen.", 
					"Success!", JOptionPane.INFORMATION_MESSAGE);
			cust.getCartTotal().clearCart();
			dispose();
			new Home(cust, ven).setVisible(true);

		}
	}

	public void buildUtilityPanel(Venue ven, Event ev, Customer cust) {
		// utilityPanel = new JPanel();

		backButton = new JButton("Back");
		homeButton = new JButton("Main Menu");

		backButton.addActionListener(new backButtonListener(ven, ev, cust));
		homeButton.addActionListener(new homeButtonListener(cust));
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		rightColumnBox.add(backButton);
		rightColumnBox.add(homeButton);
	}

	private class backButtonListener implements ActionListener {
		private Customer cust;
		private Event ev;
		private Venue ven;

		public backButtonListener(Venue ven, Event ev, Customer cust) {
			this.cust = cust;
			this.ev = ev;
			this.ven = ven;
		}

		public void actionPerformed(ActionEvent e) {
			// TO MOVE EVENTS (PREVIOUS) WINDOW
			// shoppingCartWindowFrame.dispose();
			cust.getCartTotal().clearCart();
			dispose();
			new seatSelectWindow(ven, ev, cust);
		}
	}

	private class homeButtonListener implements ActionListener {
		private Customer cust;

		public homeButtonListener(Customer cust) {
			this.cust = cust;
		}

		public void actionPerformed(ActionEvent e) {
			// TO MOVE TO MAIN MENU WINDOW
			dispose();
			new Home(cust, venue).setVisible(true);
		}
	}
}


/*
To Fix:
pass through a login to fix homeButtonListener
Need to access customer class in updatePaymentInfoButton and checkoutButton
*/