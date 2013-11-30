package banking;

public class Loan extends Account {

	public Loan(String ID){
		super(ID);
	}

	public void addTransaction(Transaction t) {
		transactions.add(t);
		balance += t.getAmount();
	}

	public void newTransaction() {
		Util.printHeader("Add new transaction to Loan ["+getID()+"] | "+balance+" :-");
		Util.print("Enter amount: ");
		int amount = Util.getIntInput(-(int)balance, 0);
		Util.print("Enter message: ");
		String message = Util.getInput();
		Util.print("Enter date: ");
		String date = Util.getInput();
		Util.print("Enter time: ");
		String time = Util.getInput();
		addTransaction(new Transaction(date, time, message, amount));
	}
}
