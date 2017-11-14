package org.system.software;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import org.system.event.Venue;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;


public class login extends JFrame  {
	
	
	private static final long serialVersionUID = 1L;
	protected static final Component Warning= null;
	private JTextField textField;
	private JPasswordField passwordField;
	private int flag=0;
	private login uni;
	private Venue venue;
	
	public login(Venue venue) 
	{
		
		
		
		
		getContentPane().setBackground(Color.WHITE);
		//super(windowTitle);
		setTitle("EventBoss - Welcome");

		//set up window

		setSize(500, 300);
		
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("<HTML><center>Welcome to EventBoss</center></HTML>");
		lblNewLabel_1.setForeground(new Color(255, 140, 0));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNPassword = new JLabel("Password:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign In");
		
		JLabel lblUsername = new JLabel("Username:");
		
		passwordField = new JPasswordField();
		//grougp layout 
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(108)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(16)
									.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
									.addComponent(btnSignIn, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addGap(31))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addComponent(lblUsername)
											.addGap(18))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNPassword)
											.addGap(21)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordField)
										.addComponent(textField, 268, 268, Short.MAX_VALUE))))
							.addGap(155)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNPassword, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSignIn, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		//Event listeners 
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user;
				char[] password;
				user = textField .getText();
				password=passwordField.getPassword();
				
		           for (int i=0; i<System.cus.size();i++) {
		               if(System.cus.get(i).getUsername().equals(user)){
		            	   flag=1;
		                   if(System.cus.get(i).checkPassword(password)){
		                	   new Home(System.cus.get(i).getHuman(),venue).setVisible(true);
		                	   dispose();
		                	   flag=2;
		                	   break;
		                   }
		               }
		           }if (flag==0){
					JOptionPane.showMessageDialog(Warning, "user doesn't exist"
		        	   		+ "", "Password",JOptionPane.WARNING_MESSAGE);  
		           }else if (flag==1){
		        	   JOptionPane.showMessageDialog(Warning, "password is not correct"
			        	   		+ "", "Password",JOptionPane.WARNING_MESSAGE);  
		        	   flag=0;
		           }
			}
		});	
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register(uni).setVisible(true);
			}
		});	
		setVisible(true);
	}

}



