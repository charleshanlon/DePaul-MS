package week2;

import edu.princeton.cs.algs4.StdOut;

public class UseBankAccount {
	public static void main(String[] args) {
		BankAccount acct = new BankAccount("John Smith", 500.00);
		StdOut.printf("%s balance is: %f%n", acct.getOwner(), acct.getBalance());
		acct.withdraw(200.00);
		acct.deposit(25.00);
		StdOut.printf("%s balance is: %f%n", acct.getOwner(), acct.getBalance());
		
		//acct.withdraw(10000);
		
		/*
		BankAccount acct2 = new BankAccount("Jane Doe", 100.00);
		acct.transferTo(acct2, 50);
		StdOut.printf("%s balance is: %f%n", acct.getOwner(), acct.getBalance());
		StdOut.printf("%s balance is: %f%n", acct2.getOwner(), acct2.getBalance());
		*/
	}
}
