package com.twilio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener, ItemListener {

	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel phoneNumberLabel;
	private static JTextField phoneNumberText;
	private static JButton button;
	private static JLabel success;
	private static JCheckBox dailyMessage;
	private Recipient test;
	private static JPanel panel;


	public static void subscribe() {

		panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(500, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Get Dad Jokes");
		frame.add(panel);

		panel.setLayout(null);

		userLabel = new JLabel("Name");
		userLabel.setBounds(12, 20, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(105, 20, 165, 25);
		panel.add(userText);

		phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setBounds(12, 50, 100, 25);
		panel.add(phoneNumberLabel);

		phoneNumberText = new JTextField(20);
		phoneNumberText.setBounds(105, 50, 165, 25);
		panel.add(phoneNumberText);

		button = new JButton("Send Joke");
		button.setBounds(170, 80, 100, 25);
		button.addActionListener(new GUI());
		panel.add(button);

		success = new JLabel("");
		success.setBounds(12, 110, 300, 25);
		panel.add(success);
		
		//have to get this working with the quartz scheduler
		//dailyMessage = new JCheckBox("Receive a joke every day");
		//dailyMessage.setBounds(12, 130, 400, 15);
		//dailyMessage.setSelected(false);
		//dailyMessage.addItemListener(new GUI());
		//panel.add(dailyMessage);

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = userText.getText();
		String phoneNumber = phoneNumberText.getText();
		this.test = new Recipient(user, phoneNumber);
		final String phoneTest = "+15554443333";
		
		int requiredPhoneLength = phoneTest.length();
		int userPhoneLength = phoneNumber.length();
		String requiredStartNumber = phoneTest.substring(0, 1);
		String userStartNumber = phoneNumber.substring(0, 1);
		boolean valid = (requiredPhoneLength == userPhoneLength && requiredStartNumber.equals(userStartNumber));
		//dailies = new ArrayList<Recipient>();
		//Recipient one = new Recipient("Joe", "+18706596366");
		

		if (valid) {
			
			this.test.sendMessage();
			
			/*if(dailyMessage.isSelected()) {
				
				String name = userText.getText();
				String number = phoneNumberText.getText();
				Recipient.addRecipient(name, number);
				System.out.println(name + number);
				
							
			}*/
			
			userText.setText("");
			phoneNumberText.setText("");
			
			
			
		} else success.setText("Try the phone number again with this format +1XXXXXXXXXX");
		
		

		success.setText("Coming at you!");

	}
	


	@Override
	public void itemStateChanged(ItemEvent e) {
		
		Object source = e.getItemSelectable();
		
		if(source == dailyMessage) {
			
			 dailyMessage.setSelected(true);
			 
			
			
		}
		
	}


		
			
	}



