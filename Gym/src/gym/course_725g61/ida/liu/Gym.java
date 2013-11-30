package gym.course_725g61.ida.liu;

import java.util.ArrayList;

public class Gym {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Gym gym = new Gym();
		gym.start();
	}
	
	public void start() {
		
		Reader reader = new Reader(System.in);
		String action = "";
		
		System.out.println("Welcome to TraixcerciserCenter 2000!");
		do {
			
			System.out.println("What would you like to do? ");
			
			action = reader.nextLine();
			
			switch(action.charAt(0)) {
			
			case 'h':
				System.out.println("Don't want to help.");
				break;
			
			case 'c':
				handleCustomer(reader);
				break;
			
			case 'e':
			case 'q':
				action = "quit";
				break;
			
			default:
				System.out.println("Sorry, but '" + action + "' is not a valid action. Please try again.");
				break;
			}
		
		
		} while(!action.equalsIgnoreCase("quit"));
		
		
		System.out.println("Thank you, come again!");
	}

	private void handleCustomer(Reader reader) {
		
		ArrayList<String> a = new ArrayList<>();
		a.add("900819-3337");
		a.add("900819-3365");
		a.add("900719-3337");
		a.add("900819-3338");
		
		System.out.println("You selected " + reader.autoComplete(a));
		
		
	}
	
	

}
