package gym.course_725g61.ida.liu;

import java.util.ArrayList;

public abstract class Person {
	
	private String personID;
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private String address;
	
	private ArrayList<MembershipCard> cards = new ArrayList<>();
	
	public Person(	String personID, 
					String firstName, 
					String lastName, 
					String phoneNumber,
					String address) {
		this.personID 		= personID;
		this.firstName 		= firstName;
		this.lastName    	= lastName;
		this.phoneNumber 	= phoneNumber;
		this.address 	 	= address;
	}
	
	public Person(String personID, String firstName, String lastName) {
		this(personID, firstName, lastName, "", "");
	}
	
	public void addCard(MembershipCard card) {
		this.cards.add(card);
	}
	
	public void remove(MembershipCard card) {
		this.cards.add(card);
	}
	
	public String getPersonID() {
		return personID;
	}
	public void setPersonID(String personID) {
		this.personID = personID;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
