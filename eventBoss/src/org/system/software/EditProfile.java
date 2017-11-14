package org.system.software;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.system.people.Address;
import org.system.people.Customer;
import org.system.people.PaymentInfo;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class EditProfile extends JFrame{
	private static final long serialVersionUID = 1L;
	protected static final Component Warning= null;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	
	
	
	
	public EditProfile(Customer toEdit) 
	{
		getContentPane().setBackground(Color.WHITE);
		
		
		
		setTitle("EventBoss - Edit Profile");

		//set up window

		setSize(500, 600);
		
		setLocationRelativeTo(null);
		
		JButton btnRegister = new JButton("Enter");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		
		JLabel lblPhone = new JLabel("Phone:");
		
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
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblPaymentinfo = new JLabel("Payment Info:");
		
		JRadioButton rdbtnVisa = new JRadioButton("Visa");
		
		JRadioButton rdbtnMastercard = new JRadioButton("MasterCard");
		
		JRadioButton rdbtnDiscovery = new JRadioButton("Discover");
		
		JRadioButton rdbtnAmex = new JRadioButton("Amex");
	
		rdbtnDiscovery.setHorizontalAlignment(SwingConstants.LEFT);
		
		//create radio button group
		ButtonGroup group1 = new ButtonGroup();
		group1.add(rdbtnVisa );
		group1.add(rdbtnMastercard);
		group1.add(rdbtnDiscovery);
		group1.add(rdbtnAmex);
		
		JLabel lblCardType = new JLabel("Card company:");
		
		JLabel lblCardType_1 = new JLabel("Card Type:");
		
		JRadioButton rdbtnDebit = new JRadioButton("Debit");
		
		JRadioButton rdbtnCredit = new JRadioButton("Credit");
		
		//create radio button group
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rdbtnDebit);
		group2.add(rdbtnCredit);
		
		JLabel lblCardNumber = new JLabel("Card Number:");
		
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		JLabel lblSec = new JLabel("Security Code:");
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		
		JLabel lblExpireDate = new JLabel("Expire Date:");
		
		JLabel lblYear = new JLabel("Year:");
		
		JLabel lblMonth = new JLabel("Month:");
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		
		
		
		JButton btnClose = new JButton("Cancel");
		//group layout 
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAddress)
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblZipCode)
										.addComponent(lblCountry))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEmail)
										.addComponent(lblName)
										.addComponent(lblPhone))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(14)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(textField_2, Alignment.LEADING)
												.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_3))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblStreet)
										.addComponent(lblCity)
										.addComponent(lblstate))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))))
							.addGap(145))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPaymentinfo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCardType_1)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblSec)
											.addGap(18)
											.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
											.addGap(158))
										.addComponent(lblExpireDate)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCardType)
												.addComponent(lblCardNumber)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(rdbtnVisa)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(rdbtnMastercard, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(rdbtnDiscovery)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(rdbtnAmex)
											.addGap(23))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(16)
											.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnClose))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(6)
											.addComponent(lblMonth)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblYear)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
									.addGap(182)))))
					.addGap(0))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(160)
					.addComponent(rdbtnDebit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnCredit)
					.addContainerGap(357, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(164)
					.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(251, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhone)
						.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(lblStreet)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCity)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblstate)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCountry))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZipCode)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblPaymentinfo))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblCardType_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnDebit)
						.addComponent(rdbtnCredit))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCardType)
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnVisa)
						.addComponent(rdbtnMastercard)
						.addComponent(rdbtnDiscovery)
						.addComponent(rdbtnAmex))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCardNumber)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSec)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblExpireDate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMonth)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYear)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegister)
						.addComponent(btnClose)))
		);
		getContentPane().setLayout(groupLayout);
		
	
		
		//event listener
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String Company=null,Type=null;
					
					
				// get card company
					if(rdbtnVisa.isSelected()) 
						Company=rdbtnVisa.getText();
					else if(rdbtnMastercard.isSelected())
						Company=rdbtnMastercard.getText();
					else if (rdbtnDiscovery.isSelected())
						Company=rdbtnMastercard.getText();
					
				// get card type
					if(rdbtnDebit.isSelected()){
						Type=rdbtnDebit.getText();
					}else if (rdbtnCredit.isSelected()){
						Type=rdbtnCredit.getText();
					}
				
				long cardNum=Long.parseLong(textField_9.getText());
				int securityCode=Integer.parseInt(textField_10.getText());
				int expMonth=Integer.parseInt(textField_11.getText());
				int expYear=Integer.parseInt(textField_12.getText());
				
				PaymentInfo pay= new PaymentInfo(Company,Type,cardNum,securityCode,expMonth,expYear); 	
				toEdit.setPaymentCard(pay);
				
				//change address
				String name, Email, Phone, Street, City, State, Country, ZipCode;
				Street=textField_4.getText();
				City=textField_5.getText();
				State=textField_6.getText();
				Country=textField_7.getText();
				ZipCode=textField_8.getText();
				Address address=new Address(Street, City, State, Country, ZipCode);
				toEdit.setAddress(address);
				
				
				name=textField_1.getText();
				Email=textField_2.getText();
				Phone= textField_3.getText();
				toEdit.setName(name);
				toEdit.setEmail(Email);
				toEdit.setPhone(Phone);
				
				JOptionPane.showMessageDialog(null, "New account has been created!", "Account created",JOptionPane.PLAIN_MESSAGE);
				dispose();
			}
		});
		
		
		btnClose.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
	}
}
