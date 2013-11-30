package banking;

public class Saving extends Account {
	public Saving(String ID){
		super(ID);
	}

	public void addTransaction(Transaction t) {
		if(t.getAmount()+balance <0){
			Util.println("Amount not allowed");
			return;
		}
		transactions.add(t);
		balance += t.getAmount();
	}
	
	public void newTransaction() {
		Util.printHeader("Add new transaction to Savings ["+getID()+"] | "+balance+" :-");
		Util.print("Enter amount: ");
		int amount = Util.getIntInput(-(int)balance, Integer.MAX_VALUE);
		Util.print("Enter message: ");
		String message = Util.getInput();
		Util.print("Enter date: ");
		String date = Util.getInput();
		Util.print("Enter time: ");
		String time = Util.getInput();
		addTransaction(new Transaction(date, time, message, amount));
	}
}
