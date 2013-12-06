package gym.course_725g61.ida.liu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Gym {
	
	private ArrayList<Customer> customers = new ArrayList<>();
	private HashMap<String, String> mainMenu = new HashMap<String, String>();
	private HashMap<String, String> customerMenu = new HashMap<String, String>();;
	private Reader reader;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Gym gym = new Gym();
		gym.start();
	}
	
	private void init() {
		this.mainMenu.put("Help", " Prints the list of all possible choices for this level in the menu. Like you are doing now!");
		this.mainMenu.put("Add customer", "Prompts you for information about a new customer.");
		this.mainMenu.put("Choose customer", "Choose a customer");
		this.mainMenu.put("Quit", "Exits program.");
		reader = new Reader(System.in);
	}
	
	public void start() {
		
		init();
		String action = "";
		
		System.out.println("Welcome to your Gym!");
		
		System.out.print("Possible actions:\n| ");
		for(String s: this.mainMenu.keySet()) 
			System.out.print(s + " | ");
		System.out.println();
		
		do {
			
			System.out.println("What would you like to do? (Choose by typing first character)");
			action = reader.nextNonEmpty("Hey, you must provide an option!");
			
			switch(action.toLowerCase().charAt(0)) {
			
			case 'h':
				System.out.println();
				for(Entry<String, String> entry : this.mainMenu.entrySet())
					System.out.println("* " + entry.getKey() + " - " + entry.getValue());
				System.out.println();
				break;
			
			case 'c':
				handleCustomer(reader);
				break;
			case 'a': 
				addCustomer(reader);
				break;
			case 'q':
				System.out.println("KTHNXBYE");
				System.exit(0);
				break;
			
			default:
				System.out.println("Sorry, but '" + action + "' is not a valid action. Please try again.");
				break;
			}
		
		
		} while(!action.equalsIgnoreCase("quit"));
		
		
		System.out.println("Thank you, come again!");
	}
	
	/**
	 * 
	 * @param reader
	 */
	private void addCustomer(Reader reader) {
		System.out.println("Enter a first name for the customer.");
		String firstName 	= reader.nextNonEmpty("You have to enter a first name!");
		System.out.println("Enter a last name for the customer.");
		String lastName  	= reader.nextNonEmpty("You have to enter a last name!");
		System.out.println("Enter the custmers personal identification number. \n" +
				"(Remember, this may not be changed later on.");
		String personalID	= reader.nextNonEmpty("Personal number format error.");
		
		Customer created = new Customer(personalID, lastName, firstName);
		
		this.customers.add(created);
		
		System.out.println(created + " was added to the gym.\nWelcome, " + created.getFullName());
	}



	private void editCustomer(Customer chosen) {

		System.out.println("You have chosen to edit " + chosen.getFullName());
		System.out.println("To edit, type in new value and press <ENTER> if you would like to leave the value as is.");
		
		String next;
		
		System.out.println("First name is " + chosen.getFirstName());
		if(!(next = reader.nextLine()).isEmpty())
			chosen.setFirstName(next);
		

		System.out.println("Last name is " + chosen.getLastName());
		if(!(next = reader.nextLine()).isEmpty())
			chosen.setLastName(next);
		
		System.out.println(chosen.getFullName() + " was updated succesfully!");
	}

	private void handleCustomer(Reader reader) {
		
		if(this.customers.isEmpty()) {
			System.out.println("Sorry, but there are no customers at your Gym.");
			return;
		}
		
		System.out.println("Select the personal ID for a customer:");
		Customer chosen = reader.autoComplete(this.customers);
		
		System.out.println("You selected " + chosen.getFullName());
		
		System.out.print("Possible actions:\n| ");
		for(String s: this.customerMenu.keySet()) 
			System.out.print(s + " | ");
		System.out.println();
		
		boolean loop = true;
		String action = "";
		
		while(loop) {

			System.out.println("What would you like to do? (Choose by typing first character)");
			action = reader.nextNonEmpty("Hey, you must provide an option!");
			
			switch(action.toLowerCase().charAt(0)) {
			case 'h':
				// TODO: Print help for this menu.
				break;
			case 'e':
				this.editCustomer(chosen);
				break;
			default:
				System.out.println("Sorry, but '" + action + "' is not a valid action. Please try again.");
				break;
			
				
			}
		}
	}
	
	

}
