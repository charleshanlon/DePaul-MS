package week2;

public class BankAccountArray {
	public static void main(String[] args) {
		BankAccount[] acct = new BankAccount[4];
		acct[0] = new BankAccount("John Smith", 500);
		acct[1] = new BankAccount("Jane Doe", 100);
		acct[3] = new BankAccount("Bart Simpson", 0);
		acct[0].transferTo(acct[3],  20);
	}
}
