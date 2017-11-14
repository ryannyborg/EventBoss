package org.system.software;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.system.people.Account;
import org.system.people.Address;
import org.system.people.Customer;
import org.system.people.PaymentInfo;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;


public class Register extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	protected static final Component Warning= null;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	
	public Register(login uni) 
	{
		getContentPane().setBackground(Color.WHITE);
		
		
		
		setTitle("EventBoss - New Customer");

		//set up window

		setSize(500, 470);
		
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("<HTML><center>Welcome to EventBoss</center></HTML>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnRegister = new JButton("Create New Account");
	
		
		JLabel lblNPassword = new JLabel("Password:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		
		passwordField = new JPasswordField();
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		
		JLabel lblPhone = new JLabel("Phone:");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		
		JLabel lblCity = new JLabel("City");
		
		JLabel lblstate = new JLabel("State");
		
		JLabel lblAddress = new JLabel("Address:");
		
		JLabel lblCountry = new JLabel("Country");
		
		JLabel lblZipCode = new JLabel("Zip Code");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		//grougp layout 
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(124)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(lblAddress)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(lblNPassword)
													.addComponent(lblName)
													.addComponent(lblEmail)
													.addComponent(lblPhone))
												.addGap(21))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblUsername)
												.addGap(18)))
										.addComponent(lblStreet))
									.addGap(36)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(textField_1)
											.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
											.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
										.addComponent(textField, 271, 271, 271)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblZipCode)
									.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
									.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCountry)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblstate)
											.addComponent(lblCity)))
									.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_6)
										.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
									.addGap(100)))))
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNPassword, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhone))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStreet)
						.addComponent(lblAddress))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCity))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblstate)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCountry))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblZipCode))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRegister)
					.addGap(31))
		);
		getContentPane().setLayout(groupLayout);
		
		
		//event listener
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user;
				char[] password;
				String name, Email, Phone, Street, City, State, Country, ZipCode;
				//create address
				Street=textField_4.getText();
				City=textField_5.getText();
				State=textField_6.getText();
				Country=textField_7.getText();
				ZipCode=textField_8.getText();
				Address address=new Address(Street, City, State, Country, ZipCode);
				user = textField.getText();
				password=passwordField.getPassword();
				name=textField_1.getText();
				Email=textField_2.getText();
				Phone= textField_3.getText();
				Customer newcus=new Customer(name,address,Phone,Email, new PaymentInfo());// create new customer
				Account account= new Account(user, password, newcus);//create new account 
				System.cus.add(account);
				System.customers.add(newcus);
				
				if(name=="" || Email=="" || Phone=="" || user=="" || password.length == 0
						|| Street=="" || City=="" || State=="" || Country=="" || ZipCode==""){
					JOptionPane.showMessageDialog(null, "One or more fields not completed.", "Error",JOptionPane.WARNING_MESSAGE);
				}
				else if(password.length < 6){
					JOptionPane.showMessageDialog(null, "Insufficient password length.\nEnter a password longer than six characters."
							, "Error",JOptionPane.WARNING_MESSAGE);
				}
				else{
				JOptionPane.showMessageDialog(null, "New account has been created!", "Account created",JOptionPane.PLAIN_MESSAGE);
				dispose();
				}
			}
		});
	}
}
