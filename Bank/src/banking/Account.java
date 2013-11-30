package banking;

import java.util.ArrayList;

public abstract class Account {
	private String ID;
	protected float balance;
	protected ArrayList<Transaction> transactions;
	
	public String getID() {
		return ID;
	}

	public float getBalance() {
		return balance;
	}

	public Account(String ID){
		this.ID = ID;
		transactions = new ArrayList<Transaction>();
	}
	
	public abstract void addTransaction(Transaction t);

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	
	public abstract void newTransaction();

	public String toString(Person owner){
		String type = "Sparkonto";
		if(this instanceof Loan)
			type = "Loan";
		return type+";"+ID+";"+ owner.getSSN()+";"+balance;
	}
}
