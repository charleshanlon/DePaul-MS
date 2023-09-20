package week2;

public class BankAccount {

	/**
	 * Create an account with the given owner and initial balance.
	 * 
	 * @param owner The name of the account owner.
	 * @param initialBalance The initial balance when the account is created.
	 */
	public BankAccount(String owner, double initialBalance) {
		throw new RuntimeException("Not implemented.");
	}
	
	/**
	 * Get the balance in the account.
	 * @return the balance in the account.
	 */
	public double getBalance() {
		throw new RuntimeException("Not implemented.");
	}
	
	/**
	 * Deposit the given amount into the account.
	 * 
	 * @param amount the amount to be deposited.
	 */
	public void deposit(double amount) {
		throw new RuntimeException("Not implemented.");
	}
	
	/**
	 * Withdraw the given amount from the account.
	 * 
	 * @param amount the amount to be withdrawn
	 * @throws IllegalArgumentException if the amount to be withdrawn is greater than the balance.
	 */
	public void withdraw(double amount) {
		throw new RuntimeException("Not implemented.");
	}

	/**
	 * Transfer the given amount from this account to other account.
	 * 
	 * @param otherAccount the account that will receive the transfer
	 * @param amount the amount to be transfered.
	 * @throws IllegalArgumentException if the amount to be transfered is greater than the balance.
	 */
	public void transferTo(BankAccount otherAccount, double amount) {
		throw new RuntimeException("Not implemented.");
	}
	
	/**
	 * Gets the name of the account owner.
	 * 
	 * @return the name of the account owner.
	 */
	public String getOwner() {
		throw new RuntimeException("Not implemented.");
	}
}
