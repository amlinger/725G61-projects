package banking;

/*
 * @author Henrik Laurentz, henla728 
 */

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class BankingSystem {

	private ArrayList<Person> persons;
	private Scanner scanner = null;
	private String personPath = System.getProperty("user.dir")+"\\kunder.txt";
	private String accountPath = System.getProperty("user.dir")+"\\konton.txt";
	private String choice = "";
	
	public BankingSystem() {
		persons = new ArrayList<Person>();
		readPersons();
		readTransactions();
	}
	
	public void run(){
		inputLoop();
		writeTransactions();
	}

	private void inputLoop() {
		Util.printWelcome();
		while (true) {
			Util.printHeader("Choose a person by SSN in the list below. 'quit' to quit");
			printPersons(persons);
			choice = Util.getInput(getAllSSN());
			if(choice.equals("quit"))
				break;
			Person chosen= getPerson(choice);
			chosen.printAccounts();
			Util.printHeader("Choose an account-ID in the list above. 'quit' to quit");
			choice = Util.getInput(chosen.getAccountIDs());
			if(choice.equals("quit"))
				break;
			chosen.getAccountByID(choice).newTransaction();
		}
	}

	private ArrayList<String> getAllSSN() {
		ArrayList<String> allowed = new ArrayList<String>();
		for(Person p : persons)
			allowed.add(p.getSSN());
		return allowed;
	}
	
	public Person getPerson(String ssn){
		for(Person p : persons)
			if(p.getSSN().equals(ssn))
				return p;
		return null;
	}
	
	public void printPersons(ArrayList<Person> persons) {
		Util.println();
		String[] atts = { "Name", "SSN" };
		System.out.format("%1$-30s|%2$-11s%n", atts[0], atts[1]);
		Util.println("------------------------------+----------");
		for (Person person : persons) {
			System.out.format("%1$-30s|%2$-11s%n", person.getName(),
					person.getSSN());
		}
		Util.println();
	}

	public void readPersons() {
		try {
			scanner = new Scanner(new FileInputStream(personPath));
		} catch (FileNotFoundException e) {
			Util.println("File not found");
			return;
		}
		while (scanner.hasNext()) {
			String[] inputArr = scanner.nextLine().split(";");
			persons.add(new Person(inputArr[0], inputArr[2], inputArr[1],
					inputArr[3]));
		}
		scanner.close();
	}

	public void readTransactions() {
		String[] input;
		Account account;
		Person person;
		try {
			scanner = new Scanner(new FileInputStream(accountPath));
		} catch (FileNotFoundException e) {
			Util.println("File not found");
			return;
		}
		input= scanner.nextLine().split(";");
		while (scanner.hasNext()) {
			person = getPerson(input[2]);
			if(input[0].equals("Sparkonto"))
				account = new Saving(input[1]);
			else
				account = new Loan(input[1]);
			input = scanner.nextLine().split(";");
			while(input[0].equals("T")){
				String date = input[1].split(" ")[0];
				String time = input[1].split(" ")[1];
				String message = input[2];
				float amount = Float.parseFloat(input[3]);
				account.addTransaction(new Transaction(date,time,message,amount));
				if(!scanner.hasNext())
					break;
				input = scanner.nextLine().split(";");
			}
			person.addAccount(account);
			
		}
		scanner.close();
	}
	private void writeTransactions() {
		BufferedWriter bf;
		FileWriter file;
		try {
		file = new FileWriter(accountPath);
		bf = new BufferedWriter(file);
		for(Person p : persons)
			for(Account a : p.getAccounts()){
				bf.write(a.toString(p)+"\n");
				for(Transaction t : a.transactions)
					bf.write(t.toString()+"\n");
			}
		bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new BankingSystem().run();
	}
}
