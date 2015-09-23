import java.util.Date;

public class Account {
	private int id = 0;
	private double balance = 0.0;
	private double annualInterestRate = 0.0;
	private Date dateCreated = new Date();
	
	public Account(){
		//empty
	}
	
	public Account(int id, double balance){
		this.id = id;
		this.balance = balance;
	}
	
	/*
	 * Withdraws an amount. I implemented the logic that was mentioned in PS3 assignment. 
	 */
	public void withdraw(double amount) throws InsufficientFundsException {
		if ((this.balance-amount)>=0){
			this.balance-=amount;
		}
		else{
			double needed = amount-this.balance;
			throw new InsufficientFundsException(needed);
		}
	}
	
	public void deposit(double amount){
		if (amount>=0){
			this.balance+=amount;
		}
		else{
			System.out.println("You can't \"deposit\" a negative amount to steal from the account.");
		}
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public Date getDateCreated(){
		return this.dateCreated;
	}
	
	public double getMonthlyInterestRate(){
		return (this.annualInterestRate/12.0);
		//This doesn't work for some reason :(
		
		/*
		double monthly = (Math.pow(1+this.annualInterestRate,1/12))-1;
		System.out.println(this.annualInterestRate+"______"+monthly);
		return(monthly);
		*/
	}
}
