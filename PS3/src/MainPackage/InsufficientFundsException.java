package MainPackage;

public class InsufficientFundsException extends Exception {
	private double amount;
	
	public InsufficientFundsException(double amount){
		this.amount = amount;
		errorMessage();
	}
	
	public void errorMessage(){
		System.out.println("Insufficient Funds. You need $"+getAmount()+" more.");
	}
	
	public double getAmount(){
		return this.amount;
	}
}
