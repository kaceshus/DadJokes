package com.twilio;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Recipient {
	
	private String name; 
	private String phoneNumber;
	private static Recipient newMember;
	private static ArrayList<Recipient> dailies = new ArrayList<Recipient>();
	final static String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
	final static String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
	
	
	public Recipient(String name, String phoneNumber) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
			
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getDailyMessage() {
		String[] textsToSend = new String[31];
		Random random = new Random();

		textsToSend[0] = this.name + ", Why did the \uD83C\uDFC8 coach go to the bank?\nTo get his quarter back.\uD83D\uDE02";
		textsToSend[1] = this.name + ", Why can't a \uD83D\uDC06 hide?\nHe's always spotted.\uD83D\uDE02";
		textsToSend[2] = this.name + ", Did you hear about the claustrophobic astronaut?\nHe just wanted a bit more space.\uD83D\uDE02";
		textsToSend[3] = this.name + ", Why did the orange lose the race? \nIt ran out of uD83E\uDD64 \uD83D\uDE02";
		textsToSend[4] = this.name + ", How you fix a broken pumpkin?\n With a pumpkin patch.\uD83D\uDE02";
		textsToSend[5] = this.name + ", Why are \uD83D\uDC1F so smart? \nThey live in schools\uD83D\uDE02";
		textsToSend[6] = this.name + ", What's the best thing about Switzerland?\nI don't know, but the flag is a big \u2795. \uD83D\uDE02 ";
		textsToSend[7] = this.name + ", Why did the uD83D\uDC68 fall down the well? \nBecause he couldn’t see that well!\uD83D\uDE02";
		textsToSend[8] = this.name + ", What did the sink tell the \uD83D\uDEBD?\nYou look flushed!\uD83D\uDE02";
		textsToSend[9] = this.name + ", Where do \uD83D\uDEA2 go when they're sick?\nTo the dock.\uD83D\uDE02";
		textsToSend[10] = this.name + ", What has ears but cannot hear?\nA cornfield!\uD83D\uDE02";
		textsToSend[11] = this.name + ", Can February March?\n No,but April May!\uD83D\uDE02";
		textsToSend[12] = this.name + ", Why was 6 afraid of 7?\nBecause 7 ate nine!\uD83D\uDE02";
		textsToSend[13] = this.name + ", I'm so good at \uD83D\uDE34 that I do it with my eyes closed\uD83D\uDE02";
		textsToSend[14] = this.name + ", What do you call a \u270F with two erasers? \nPointless.\uD83D\uDE02";
		textsToSend[15] = this.name + ", Did you hear the one about the roof?\nNever mind, it's over your head.\uD83D\uDE02";
		textsToSend[16] = this.name + ", What's brown and sticky?\nA stick.\uD83D\uDE02";
		textsToSend[17] = this.name + ", I hated facial hair but then it grew on me.\uD83D\uDE02";
		textsToSend[18] = this.name + ", It really takes guts to be an organ donor.\uD83D\uDE02";
		textsToSend[19] = this.name + ", Did you hear the rumor about butter?\nWell, I'm not going to go spreading it!\uD83D\uDE02";
		textsToSend[20] = this.name + ", What did the plumber say to the singer?\nNice pipes.\uD83D\uDE02";
		textsToSend[21] = this.name + ", I was going to tell a time-traveling joke, but you didn't like it.\uD83D\uDE02";
		textsToSend[22] = this.name + ", I ordered a \uD83D\uDC14 and an \uD83E\uDD5A online. I'll let you know.\uD83D\uDE02";
		textsToSend[23] = this.name + ", What kind of \uD83D\uDC5F does a lazy person wear?\nLoafers.\uD83D\uDE02";
		textsToSend[24] = this.name + ", Why'd the fisherman order the halibut?\nJust for the halibut\uD83D\uDE02";
		textsToSend[25] = this.name + ", Why is Peter Pan always flying? \nBecause he Neverlands\uD83D\uDE02";
		textsToSend[26] = this.name + ", How do you throw a party in outer space?\nYou planet \uD83D\uDE02.";
		textsToSend[27] = this.name + ", Why was the \uD83E\uDDF9 late to class? \nIt over-swept.\uD83D\uDE02";
		textsToSend[28] = this.name + ", You can't trust atoms. They make up everything!!\uD83D\uDE02";
		textsToSend[29] = this.name + ", How does a lawyer say goodbye? \nI'll be suing ya!\uD83D\uDE02";
		textsToSend[30] = this.name + ", What does a nosey pepper do?\n It gets jalapeño business.\uD83D\uDE02";

				
		return textsToSend[random.nextInt(31)];
				

	}
	
	public Message sendMessage() {
		
		
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	
		Message message = Message.creator(new PhoneNumber(this.phoneNumber), new PhoneNumber(System.getenv("MY_PHONE_NUMBER")), getDailyMessage()).create();
		//print out SID as proof message was sent
		System.out.println("Message SID: " + message.getSid());
		
		return message;

		
	}
	
	public static void addRecipient(String name, String number ) {
		newMember = new Recipient(name, number);
		dailies.add(0, newMember);
				
		
	}
	public static void sendDailies() {
		//System.out.println(dailies);
		System.out.println(dailies.size());
		
//		for(Recipient recipients : dailies) {
//			recipients.sendMessage();
//		}
	
	
	
	
	

}
}
