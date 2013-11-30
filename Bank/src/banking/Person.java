package banking;

import java.util.ArrayList;

public class Person {
	private String name, address, telephone;
	private String SSN;
	private ArrayList<Account> accounts;

	public Person(String name, String address, String SSN, String telephone) {
		this.name = name;
		this.address = address;
		this.SSN = SSN;
		this.telephone = telephone;
		accounts = new ArrayList<Account>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addAccount(Account a) {
		accounts.add(a);
	}

	public ArrayList<Account> getSavingAccounts() {
		ArrayList<Account> temp = new ArrayList<Account>();
		for (Account a : accounts)
			if (a instanceof Saving)
				temp.add((Saving) a);
		return temp;
	}

	public ArrayList<Account> getLoanAccounts() {
		ArrayList<Account> temp = new ArrayList<Account>();
		for (Account a : accounts)
			if (a instanceof Loan)
				temp.add((Loan) a);
		return temp;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String SSN) {
		this.SSN = SSN;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	private void printAccount(ArrayList<Account> accounts) {
		Util.println();
		String[] atts = { "Id", "Balance" };
		for (Account account : accounts) {
			Util.println(" ___Account______________");
			Util.println("|                        |");
			System.out.format("| %1$-10s|%2$-11s |%n", atts[0], atts[1]);
			Util.println("| ----------+----------- |___Transactions__________________________");
			System.out
					.format("| %1$-10s|%2$-11s                                           |%n",
							account.getID(), account.getBalance());
			System.out.format(
					"|_____________   %1$-15s %2$11s %3$12s %4$7s  |%n",
					"Note", "Amount", "Date", "Time");
			Util.println("\t      |  ---------------+-----------+------------+-------  |");
			for (Transaction t : account.getTransactions()) {
				System.out
						.format("\t      |  %1$-15s|%2$11s|%3$12s|%4$7s  |%n",
								t.getMessage(), t.getAmount(), t.getDate(),
								t.getTime());
			}
			Util.println("\t      |____________________________________________________|");
		}
		Util.println();

	}
	
	public ArrayList<String> getAccountIDs(){
		ArrayList<String> list = new ArrayList<String>();
		for(Account a : accounts)
			list.add(a.getID());
		return list;
	}
	public Account getAccountByID(String id){
		for(Account a : accounts)
			if(a.getID().equals(id))
				return a;
		return null;
	}

	public void printAccounts() {
		if (getLoanAccounts().size() > 0) {
			Util.printHeader("Loan accounts for " + name + " [" + SSN + "]");
			printAccount(getLoanAccounts());
		}
		if (getSavingAccounts().size() > 0) {
			Util.printHeader("Saving accounts for " + name + " [" + SSN + "]");
			printAccount(getSavingAccounts());
		}
	}

}
