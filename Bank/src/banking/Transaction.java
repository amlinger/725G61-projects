package banking;

public class Transaction {

	private String date,time,message;
	private float amount;
	
	public Transaction(String date, String time, String message, float amount){
		this.date = date;
		this.time = time;
		this.message = message;
		this.amount = amount;
	}
	
	public Transaction(){
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String toString(){
		return "T;"+date+" "+time+";"+message+";"+amount;
	}
}
