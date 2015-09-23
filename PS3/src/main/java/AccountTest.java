import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountTest {
	
	@Test //(expected = InsufficientFundsException.class)
	public void testWithdraw() throws InsufficientFundsException {
		Account account0 = new Account(1122,20000);
		account0.setAnnualInterestRate(0.045);
		assertEquals(true,account0.getMonthlyInterestRate()==0.00375);
		account0.withdraw(2500);
		account0.deposit(3000);
		System.out.println("balance = $"+account0.getBalance());
		System.out.println("monthly IR = %"+account0.getMonthlyInterestRate()*100);
		System.out.println("date created = "+account0.getDateCreated());
		assertEquals(false,account0.withdraw(100000));
	}
}
