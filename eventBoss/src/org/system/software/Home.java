package org.system.software;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.system.event.Event;
import org.system.event.Venue;
import org.system.people.Customer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;




public class Home extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Venue venue;
	private Customer customer;

	public Home(Customer user, Venue venue) 
	{
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		
		setTitle("EventBoss - Home");

		//set up window

		setSize(500, 400);
		
		setLocationRelativeTo(null);
		
		this.venue = venue;
		customer = user;
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/zhaoran/Desktop/profpic.png"));
		
		JLabel lblWelcome = new JLabel("Welcome Back "+user.getName()+"!");
		lblWelcome.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblWelcome.setVerticalAlignment(SwingConstants.TOP);
		
		JButton btnEvents = new JButton("Find Tickets");
		
		
		JButton btnViewTickets = new JButton("View Tickets");
		
		JButton btnShopingCart = new JButton("Shopping Cart");
		
		JButton btnEditProfile = new JButton("Edit Profile");
		
		JButton btnQuit = new JButton("Sign Out");
		
		JLabel lblEventboss = new JLabel("EventBoss");
		lblEventboss.setForeground(new Color(255, 140, 0));
		lblEventboss.setFont(new Font("Verdana", Font.BOLD, 28));
		
		JLabel logoLabel = new JLabel();
		
		try{
			String path = "http://www.iconsplace.com/icons/preview/orange/ticket-64.png";
			URL	url = new URL(path);
			BufferedImage image = ImageIO.read(url);
			logoLabel.setIcon(new ImageIcon(image));
		}
			// logoLabel = new JLabel(new ImageIcon(image));
		catch(Exception exp){
			exp.printStackTrace();
			JOptionPane.showMessageDialog(null, 
					"Unable to connect to the Internet or URL not located.", 
					"Error", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		
		//group layout
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel)
					.addGap(80)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnShopingCart, 0, 0, Short.MAX_VALUE)
								.addComponent(btnEvents, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnEditProfile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnViewTickets, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblEventboss)))
					.addContainerGap(109, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(203, Short.MAX_VALUE)
					.addComponent(btnQuit)
					.addGap(199))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblWelcome, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
					.addGap(17))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(14)
									.addComponent(lblEventboss))
								.addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnViewTickets, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEvents, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnShopingCart, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEditProfile, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(lblWelcome)
					.addGap(14))
		);
		getContentPane().setLayout(groupLayout);
		
		btnEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new eventSelectWindow(venue, customer);
			}
		});
		
		btnViewTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tickets_View(user, venue).setVisible(true);
				dispose();
			}
		});
		btnShopingCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// add functionality.............
				
				if(customer.getCartTotal().getSeatsInCart().isEmpty()){
					JOptionPane.showMessageDialog(null, "Cart is empty!", 
							"Error!", JOptionPane.ERROR_MESSAGE);
				}
				else{
					new shoppingCart(venue, venue.getEventList().get(0), customer);
					dispose();
				}
			}
		});
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new login(venue);
			}
		});
		
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditProfile(user).setVisible(true);
			}
		});

	}
}
